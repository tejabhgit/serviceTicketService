package com.hp.rps.svc.supportticket.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

public class JaegerExample {

    private static final String INSTRUMENTATION_LIBRARY = "io.opentelemetry.example.JaegerExample";

    private final static Logger logger = LoggerFactory.getLogger(JaegerExample.class);

    private final Tracer tracer;

    public JaegerExample(OpenTelemetry openTelemetry) {
        tracer = openTelemetry.getTracer(INSTRUMENTATION_LIBRARY);
    }

    private void myWonderfulUseCase() {
        // Generate a span
        Span span = this.tracer.spanBuilder("Start my wonderful use case").startSpan();
        logger.info("TraceID : {}", span.getSpanContext().getTraceIdAsHexString());
        logger.info("SpanId : {}", span.getSpanContext().getSpanIdAsHexString());
        span.addEvent("Event 0");
        // execute my use case - here we simulate a wait
        doWork();
        span.addEvent("Event 1");
        span.end();
    }

    private void doWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do the right thing here
        }
    }

    public static void main(String[] args) {
        // Parsing the input
      /*  if (args.length < 2) {
            logger.info("Missing [hostname] [port]");
            System.exit(1);
        }
        String jaegerHostName = args[0];
        int jaegerPort = Integer.parseInt(args[1]);*/

        // it is important to initialize your SDK as early as possible in your
        // application's lifecycle
        OpenTelemetry openTelemetry = JaegerConfiguration.initOpenTelemetry("localhost", 14250);

        // Start the example
        JaegerExample example = new JaegerExample(openTelemetry);
        // generate a few sample spans
        for (int i = 0; i < 10; i++) {
            example.myWonderfulUseCase();
        }

        logger.info("Bye");
    }
}