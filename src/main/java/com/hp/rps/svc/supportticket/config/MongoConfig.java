package com.hp.rps.svc.supportticket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {


    @Bean
    public BeforeSaveListener beforeSaveListener() {
        return new BeforeSaveListener();
    }

}