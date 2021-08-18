package com.TicketService.supportTicketService;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

@Configuration
@ComponentScan(basePackages = "com.TicketService")
public class AppConfig {
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Connection connect =  Nats.connect("nats://localhost:4222");
			/*Dispatcher dispatcher = connect.createDispatcher(message -> {
				System.out.println(String.format("Received Message[%s] from [%s]",
						new String(message.getData(), StandardCharsets.UTF_8), message.getSubject()));
			});*/  
			//dispatcher.subscribe("com.TicketService.*");
			//connect.publish("foo.bar", "Hi there!".getBytes());
			//Subscription sub = connect.subscribe("foo.bar");
			 //Message msg = sub.nextMessage(Duration.ofSeconds(1));
			
			Dispatcher d = connect.createDispatcher((msg) -> {
		        System.out.printf("Received message \"%s\" on subject \"%s\"\n", 
		                                new String(msg.getData(), StandardCharsets.UTF_8), 
		                                msg.getSubject());
		    });
		    d.subscribe("com.TicketService.*");
//			
			
		};
	}

}
