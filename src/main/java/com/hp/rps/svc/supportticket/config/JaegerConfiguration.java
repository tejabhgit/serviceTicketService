package com.hp.rps.svc.supportticket.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.exporter.jaeger.JaegerGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;

import java.util.concurrent.TimeUnit;

/**
 * All SDK management takes place here, away from the instrumentation code,
 * which should only access the OpenTelemetry APIs.
 */
public class JaegerConfiguration {

    private static final String OTEL_SERVICE_NAME = "otel-jaeger-ticket";

    /**
     * Initialize an OpenTelemetry SDK with a Jaeger exporter and a
     * SimpleSpanProcessor.
     *
     * @param jaegerHost The host of your Jaeger instance.
     * @param jaegerPort the port of your Jaeger instance.
     * @return A ready-to-use {@link OpenTelemetry} instance.
     */
    public static OpenTelemetry initOpenTelemetry(String jaegerHost, int jaegerPort) {
        // Create a channel towards Jaeger end point
        ManagedChannel jaegerChannel = ManagedChannelBuilder.forAddress(jaegerHost, jaegerPort).usePlaintext().build();
        // Export traces to Jaeger
        JaegerGrpcSpanExporter jaegerExporter = JaegerGrpcSpanExporter.builder().setChannel(jaegerChannel)
                .setTimeout(300000000, TimeUnit.SECONDS).build();

        Resource serviceNameResource = Resource
                .create(Attributes.of(ResourceAttributes.SERVICE_NAME, OTEL_SERVICE_NAME));
        // Set to process the spans by the Jaeger Exporter
        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(jaegerExporter))
                .setResource(Resource.getDefault().merge(serviceNameResource)).build();
        OpenTelemetrySdk openTelemetry = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

        // it's always a good idea to shut down the SDK cleanly at JVM exit.
        Runtime.getRuntime().addShutdownHook(new Thread(tracerProvider::shutdown));

        return openTelemetry;
    }
}
