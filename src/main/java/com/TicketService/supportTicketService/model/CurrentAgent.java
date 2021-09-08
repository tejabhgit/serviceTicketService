package com.TicketService.supportTicketService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CurrentAgent")
public class CurrentAgent {

	private String userId;
	private String firstName;
	private String lastName;
	private String gravatar;

}
