package com.TicketService.supportTicketService.nats.server;

import io.nats.client.*;
import io.nats.client.api.AckPolicy;
import io.nats.client.api.ConsumerConfiguration;
import io.nats.client.support.JsonUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.time.Duration;
import static com.TicketService.supportTicketService.nats.util.NatsJsUtils.*;


@Configuration
@ComponentScan(basePackages = "com.TicketService")
public class AppConfigServer {

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {

			String stream = "fs-strm-ticket-";
			String subjectPrefix = "fs-sub-ticket-";
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

							publish(js, subjectA,"RPS_1_Data from Ticket Service", 1);
							publish(js, subjectB,"RPS_2_Data from Ticket Service", 1);
							publish(js, subjectA,"RPS_3_Data from Ticket Service", 1);
							publish(js, subjectB,"RPS_4_Data from Ticket Service", 1);

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