package com.TicketService.supportTicketService.nats.server;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.JetStreamManagement;
import io.nats.client.Nats;
import io.nats.client.api.PublishAck;
import io.nats.client.api.StorageType;
import io.nats.client.api.StreamConfiguration;
import io.nats.client.api.StreamInfo;
import io.nats.client.support.JsonUtils;

@Configuration
@ComponentScan(basePackages = "com.TicketService")
public class AppConfig {

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Connection connect =  Nats.connect("nats://localhost:4222");
			JetStreamManagement jsm = connect.jetStreamManagement();

			// Build the configuration
			StreamConfiguration streamConfig = StreamConfiguration.builder()
					.name("StreamTest1")
					.subjects("TopicTest1")
					.storageType(StorageType.Memory)
					.build();
			// Create the stream
			StreamInfo streamInfo = jsm.addStream(streamConfig);
			JsonUtils.printFormatted(streamInfo);

			JetStream js = connect.jetStream();
			PublishAck ack = js.publish("TopicTest1", "one".getBytes());
			JsonUtils.printFormatted(ack);

			ack = js.publish("TopicTest1", "two".getBytes());
			JsonUtils.printFormatted(ack);
		};
	}

}