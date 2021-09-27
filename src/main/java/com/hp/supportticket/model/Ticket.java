package com.hp.supportticket.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Ticket")
public class Ticket {
	@Id
	private UUID id;
	@Indexed(name = "ticketResponses_index", direction = IndexDirection.ASCENDING)
	private List<TicketContent> ticketContents;
	private String supportTicketId;
	private MetaInfo metaInfo;
	private String openTraceId;
	private String spanId;
}
