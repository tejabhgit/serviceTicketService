package com.support.ticket.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TicketResponse")
public class TicketContent {

	String id;
	private CurrentAgent currentAgent;
	private Category category;
	private Device device;
	private int issueOpened	;
	private int issueClosed;
	private String state;
	private String description;
}
