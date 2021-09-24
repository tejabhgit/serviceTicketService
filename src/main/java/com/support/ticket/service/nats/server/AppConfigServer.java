/*
package com.TicketService.supportTicketService.nats.server;

import io.nats.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@Configuration
public class AppConfigServer  {



	private static final String ORDER_SERVICE = "orderService";

	*/
/**
	 * The NATS subject for incoming message is stored in the SUBJECT header.
	 *//*

	public static final String SUBJECT = "subject";

	*/
/**
	 * If an incoming message has a reply to subject, that will be stored in the REPLY_TO header for propogation to the NatsMessageSource.
	 *//*

	public static final String REPLY_TO = "reply_to";


	@Autowired
	@Qualifier("output")
	private MessageChannel output;

	public AppConfigServer(MessageChannel output) {
		this.output = output;
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {

			String stream_Ticket = "fs-strm-rps-ticket-";
			String subjectPrefix_Ticket = "fs-sub-rps-ticket-";
			String subjectWild_Ticket = subjectPrefix_Ticket + ".*";
			String subjectA_Ticket = subjectPrefix_Ticket + ".A";
			String subjectB_Ticket = subjectPrefix_Ticket + ".B";

			String stream_session = "fs-strm-rps-session-";
			String subjectPrefix_session = "fs-sub-rps-session-";
			String subjectWild_Session = subjectPrefix_session + ".*";
			String subjectA_Session = subjectPrefix_session + ".A";
			String subjectB_Session = subjectPrefix_session + ".B";

			// try  {
			Connection nc = Nats.connect("nats://localhost:4222");
			Optional.ofNullable(nc);

			// JetStreamManagement jsm = nc.jetStreamManagement();
			nc.createDispatcher((msg) -> {


				try {
					String data = "From Ticket Sevice";
					Map<String, Object> headers = new HashMap<>();
					headers.put(SUBJECT, subjectA_Ticket);
					headers.put(REPLY_TO, "reply_to");
					GenericMessage<byte[]> m = new GenericMessage<byte[]>(data.getBytes(StandardCharsets.US_ASCII), headers);
					output.send(m);
				}
				catch (Exception e) {
					//logger.warn("exception sending message to output channel", e);
				}
			});

		};
	}


}*/
