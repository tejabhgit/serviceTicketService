package com.TicketService.supportTicketService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "svc-rps-support-ticket API", version = "2.0", description = "Ticket Information"))
public class SvcRpsSupportTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcRpsSupportTicketApplication.class, args);
		log.info("svc-rps-support-ticket API with inputs {}, {} and {}", 1,2,3);
	}

}
