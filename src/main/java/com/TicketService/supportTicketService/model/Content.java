package com.TicketService.supportTicketService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Content")
public class Content {

	String id;
	CurrentAgent currentAgent;
	Category category;
	Device device;
	private int issueOpened	;
	private int issueClosed;
	private String state;
	private String description;
}
