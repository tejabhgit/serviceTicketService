package com.hp.rps.svc.supportticket.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {


    /*@Bean
    public void errorService() throws IOException, InterruptedException {
        UnknownStatusDescriptionInterceptor unknownStatusDescriptionInterceptor = new UnknownStatusDescriptionInterceptor(Arrays.asList(IllegalArgumentException.class));{
            Server server = ServerBuilder.forPort(9090)
                    .addService(ServerInterceptors.intercept(new ErrorServiceImpl(), unknownStatusDescriptionInterceptor))
                    .build();

            System.out.println("Starting server...");
            server.start();
            System.out.println("Server started!");
            server.awaitTermination();
    }}*/
}