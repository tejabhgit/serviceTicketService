package com.hp.rps.svc.supportticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Ticket")
public class Ticket {
	@Id
	private UUID id;
	@Indexed(name = "ticketResponses_index", direction = IndexDirection.ASCENDING)
	private TicketContent ticket;
	private String supportTicketId;
	private MetaInfo metaInfo;
	private String openTraceId;
	private String spanId;
}
