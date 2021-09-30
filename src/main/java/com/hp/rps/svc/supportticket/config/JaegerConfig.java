package com.hp.rps.svc.supportticket.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import io.jaegertracing.internal.JaegerTracer;
@Configuration
//@EnableScheduling
public class JaegerConfig {

    /*@Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(schedulingExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor schedulingExecutor() {
        return Executors.newScheduledThreadPool(2);
    }*/

    @Bean
    public JaegerTracer jaegerTracer() {

        return new io.jaegertracing.Configuration("svc-rps-support-ticket")
                .withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
                        .withParam(1))
                .withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
                .getTracer();
    }
}