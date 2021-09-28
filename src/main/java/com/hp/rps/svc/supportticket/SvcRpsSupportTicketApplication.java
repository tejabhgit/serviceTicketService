package com.hp.rps.svc.supportticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SvcRpsSupportTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcRpsSupportTicketApplication.class, args);
		log.info("svc-rps-support-ticket API with inputs {}, {} and {}", 1,2,3);
	}

}
