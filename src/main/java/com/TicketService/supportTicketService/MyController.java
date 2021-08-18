package com.TicketService.supportTicketService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;

//import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/greeting")
	public String greeting() throws IOException, InterruptedException {
		
		Connection connect =  Nats.connect("nats://localhost:4222");
		
		/*Dispatcher dispatcher = connect.createDispatcher(message -> {
			System.out.println(String.format("Received Message[%s] from [%s]",
					new String(message.getData(), StandardCharsets.UTF_8), message.getSubject()));
		});*/
		//dispatcher.subscribe("com.techprimers.*");
		//connect.publish("foo.bar", "Hi there!".getBytes());
		//Subscription sub = connect.subscribe("foo.bar");
		 //Message msg = sub.nextMessage(Duration.ofSeconds(1));
		
		Dispatcher d = connect.createDispatcher((msg) -> {
	        System.out.printf("Received message \"%s\" on subject \"%s\"\n", 
	                                new String(msg.getData(), StandardCharsets.UTF_8), 
	                                msg.getSubject());
	    });
	    d.subscribe("com.techprimers.*");
		
		return "Welcome to my youtube channel";
	}

}
