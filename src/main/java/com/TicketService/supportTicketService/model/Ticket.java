package com.TicketService.supportTicketService.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Ticket")
public class Ticket {

	@Id
	private String id;
	private boolean last;
	private int totalElements;
	private int totalPages;
	private int numberOfElements;
	private boolean first;
	private int number;
	private boolean empty;	
	private List<Content> content;
}
