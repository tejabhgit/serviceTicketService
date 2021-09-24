package com.support.ticket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.cloud.stream.annotation.EnableBinding;

import javax.xml.transform.Source;

@Slf4j
@EnableBinding(Source.class)
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "svc-rps-support-ticket API", version = "2.0", description = "Ticket Information"))
public class SvcRpsSupportTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcRpsSupportTicketApplication.class, args);
		log.info("svc-rps-support-ticket API with inputs {}, {} and {}", 1,2,3);
	}

}
