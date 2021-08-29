package com.TicketService.supportTicketService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "supportTicketService API", version = "2.0", description = "Ticket Information"))
public class supportTicketServiceApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(supportTicketServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(supportTicketServiceApplication.class, args);
		LOGGER.info("supportTicketService API with inputs {}, {} and {}", 1,2,3);
	}

}
