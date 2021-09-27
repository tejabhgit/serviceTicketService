package com.hp.supportticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TicketContent")
public class TicketContent {

	String id;
	private CurrentAgent currentAgent;
	private Category category;
	private Device device;
	private String issueOpened	;
	private String issueClosed;
	private String state;
	private String description;
}
