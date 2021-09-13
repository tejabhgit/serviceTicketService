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
	private CurrentAgent currentAgent;
	private Category category;
	private Device device;
	private int issueOpened	;
	private int issueClosed;
	private String state;
	private String description;
}
