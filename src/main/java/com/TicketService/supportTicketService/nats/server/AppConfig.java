package com.TicketService.supportTicketService.nats.server;


import static com.TicketService.supportTicketService.nats.server.ExampleUtils.uniqueEnough;
import static com.TicketService.supportTicketService.nats.server.NatsJsUtils.createStream;
import static com.TicketService.supportTicketService.nats.server.NatsJsUtils.publish;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.JetStreamManagement;
import io.nats.client.JetStreamSubscription;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.PushSubscribeOptions;
import io.nats.client.api.AckPolicy;
import io.nats.client.api.ConsumerConfiguration;
import io.nats.client.api.PublishAck;
import io.nats.client.api.StorageType;
import io.nats.client.api.StreamConfiguration;
import io.nats.client.api.StreamInfo;
import io.nats.client.support.JsonUtils;
import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.Nats;
import io.nats.client.api.PublishAck;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.TicketService")
public class AppConfig {

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {/*
			//Connection connect =  Nats.connect("nats://localhost:4222");
			
			try (Connection nc =  Nats.connect("nats://localhost:4222");) {
				JetStreamManagement jsm = nc.jetStreamManagement();
				StreamConfiguration streamConfig = StreamConfiguration.builder()
			.name("RPSTicketStream")
			.subjects("RPSTicket")
				.storageType(StorageType.Memory)
				.build();
//		// Create the stream
		StreamInfo streamInfo = jsm.addStream(streamConfig);
		JetStream js = nc.jetStream();
		
		JsonUtils.printFormatted(streamInfo);
		

		 List<CompletableFuture<PublishAck>> futures = new ArrayList<>();
         for (int x = 1; x <= 100; x++) {
             System.out.println("About to publish " + x);
             CompletableFuture<PublishAck> future = js.publishAsync("RPSTicket", ("data"+x).getBytes());
             futures.add(future);
         }
	        }
//			JetStreamManagement jsm = connect.jetStreamManagement();
//
//			// Build the configuration
//			StreamConfiguration streamConfig = StreamConfiguration.builder()
//					.name("StreamTest1")
//					.subjects("TopicTest1")
//					.storageType(StorageType.Memory)
//					.build();
//			// Create the stream
//			StreamInfo streamInfo = jsm.addStream(streamConfig);
//			JsonUtils.printFormatted(streamInfo);
//
//			JetStream js = connect.jetStream();
//			PublishAck ack = js.publish("TopicTest1", "one".getBytes());
//			JsonUtils.printFormatted(ack);
//
//			ack = js.publish("TopicTest1", "two".getBytes());
//			JsonUtils.printFormatted(ack);			
		*/
			

			/*	Connection connect =  Nats.connect("nats://localhost:4222");

	            JetStream js = connect.jetStream();
	         // NoAck 1. Set up the noAck consumer / deliver subject configuration
	            ConsumerConfiguration cc = ConsumerConfiguration.builder()
	                    .ackPolicy(AckPolicy.None)
	                    .ackWait(Duration.ofSeconds(1))
	                    .build();

	            PushSubscribeOptions pso = PushSubscribeOptions.builder()
	                    .deliverSubject("RPSTicket")
	                    .configuration(cc)
	                    .build();

	            // NoAck 2. Set up the JetStream and regular subscriptions
	            //          Notice the JetStream subscribes to the real subject
	            //          and the regular subscribes to the delivery subject
	            //          Order matters, you must do the JetStream subscribe first
	            JetStreamSubscription jsSub = js.subscribe("RPSTicket", pso);
	            connect.flush(Duration.ofSeconds(5));
//	            JetStreamSubscription sub = js.subscribe("RPSTicket");
	            Message m = jsSub.nextMessage(Duration.ofSeconds(3));
	            m.ack();
	            System.out.println("Message: " + m.getSubject() + " " + new String(m.getData()));
	            JsonUtils.printFormatted(m.metaData());
	//
//	            m = sub.nextMessage(Duration.ofSeconds(3));
//	            m.ack();
//	            System.out.println("Message: " + m.getSubject() + " " + new String(m.getData()));
//	            JsonUtils.printFormatted(m.metaData());
	 * 
	*///
			//	Connection connect =  Nats.connect("nats://localhost:4222");			
			//	  ExampleArgs exArgs = ExampleArgs.builder().build(args, usageString);
				
			      //  String ue = uniqueEnough();
			        String stream = "rps-stream";
			        String subjectPrefix = "fs-sub-";
			        String subjectWild = subjectPrefix + ".*";
			        String subjectA = subjectPrefix + ".A";
			        String subjectB = subjectPrefix + ".B";

			        try (Connection nc = Nats.connect("nats://localhost:4222")) {

			            JetStreamManagement jsm = nc.jetStreamManagement();

			            try {
			                // creates a memory stream. We will clean it up at the end.
			                createStream(jsm, stream, subjectWild);

			                // Create our JetStream context to publish and receive JetStream messages.
			                JetStream js = nc.jetStream();

			                publish(js, subjectA,"RPS_1_Data", 1);
			                publish(js, subjectB,"RPS_2_Data", 1);
			                publish(js, subjectA,"RPS_3_Data", 1);
			                publish(js, subjectB,"RPS_3_Data", 1);
/*
			                // 1. create a subscription that subscribes to the wildcard subject
			                ConsumerConfiguration cc = ConsumerConfiguration.builder()
			                        .ackPolicy(AckPolicy.None) // don't want to worry about acking messages.
			                        .build();

			                PushSubscribeOptions pso = PushSubscribeOptions.builder().configuration(cc).build();

			                JetStreamSubscription sub = js.subscribe(subjectWild, pso);
			                nc.flush(Duration.ofSeconds(5));

			                Message m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("1A1. Message should be from " + subjectA + ": " + m.getSubject()
			                        + " sequence # 1: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("1B2. Message should be from " + subjectB + ": " + m.getSubject()
			                        + " sequence # 2: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("1A3. Message should be from " + subjectA + ": " + m.getSubject()
			                        + " sequence # 3: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("1B4. Message should be from " + subjectB + ": " + m.getSubject()
			                        + " sequence # 4: " + m.metaData().streamSequence());

			                // 2. create a subscription that subscribes only to the A subject
			                cc = ConsumerConfiguration.builder()
			                        .ackPolicy(AckPolicy.None) // don't want to worry about acking messages.
			                        .filterSubject(subjectA)
			                        .build();

			                pso = PushSubscribeOptions.builder().configuration(cc).build();

			                sub = js.subscribe(subjectWild, pso);
			                nc.flush(Duration.ofSeconds(5));

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("2A1. Message should be from " + subjectA + ": " + m.getSubject()
			                        + " sequence # 1: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("2A3. Message should be from " + subjectA + ": " + m.getSubject()
			                        + " sequence # 3: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("2x. Message should be null: " + m);

			                // 3. create a subscription that subscribes only to the A subject
			                cc = ConsumerConfiguration.builder()
			                        .ackPolicy(AckPolicy.None) // don't want to worry about acking messages.
			                        .filterSubject(subjectB)
			                        .build();

			                pso = PushSubscribeOptions.builder().configuration(cc).build();

			                sub = js.subscribe(subjectWild, pso);
			                nc.flush(Duration.ofSeconds(5));

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("3A2. Message should be from " + subjectB + ": " + m.getSubject()
			                        + " sequence # 2: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("3A4. Message should be from " + subjectB + ": " + m.getSubject()
			                        + " sequence # 4: " + m.metaData().streamSequence());

			                m = sub.nextMessage(Duration.ofSeconds(1));
			                System.out.println("3x. Message should be null: " + m);*/
			            }
			            finally {
			                // be a good citizen and remove the example stream
			             //   jsm.deleteStream(stream);
			            }
			        }
			        catch (Exception e) {
			            e.printStackTrace();
			        }
				
				
				
				
			
		
		
		
		};
	}

}