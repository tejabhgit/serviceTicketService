package com.hp.rps.svc.supportticket.config;

import com.hp.rps.svc.supportticket.listeners.SessionEntityCallback;
import com.hp.rps.svc.supportticket.listeners.TicketEntityCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.UUID;

@Configuration
@EnableMongoAuditing
public class MongoConfig {

    @Bean
    public AuditorAware<UUID> myAuditorProvider() {
        return new AuditorAwareImpl();
    }

    @Bean
    public TicketEntityCallback registerTicketCallback() {
        return new TicketEntityCallback();
    }

    @Bean
    public SessionEntityCallback registerSessionCallback() {
        return new SessionEntityCallback();
    }

}