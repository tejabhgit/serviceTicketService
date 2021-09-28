package com.hp.rps.svc.supportticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SupportTicket")
public class SupportTicket {

	private String id;
	private CurrentAgent current_agent;
	private Category category;
	private String deviceId;
	private String issue_opened;
	private String issue_closed;
	private String state;
	private String description;
	
}
