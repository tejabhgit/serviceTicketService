package com.hp.rps.svc.supportticket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class NatsStreamConfig {

/*    @Bean
    public Function<Flux<String>, Flux<String>> toUpperCase() {
        return flux -> {
            return flux.map(input -> input.toUpperCase());
        };
    }

    @PollableBean
    public Supplier<Flux<String>> stringSupplier() {
        return () -> Flux.range(0, 5).map(i -> {
            return "foobar " + i;
        });
    }

    @Bean
    public Consumer<Flux<String>> stringLogger() {
        return flux -> {
            flux.subscribe(log::info);
        };
    }*/
}
