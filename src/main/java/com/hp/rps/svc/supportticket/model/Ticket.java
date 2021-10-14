package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Document(collection = "Ticket")
public class Ticket implements Serializable {
    @Id
    @Indexed
    private UUID id;

    private UUID currentAgentUserId;

    private Category category;

    private UUID deviceId;

	private MetaInfo metaInfo;

    @Indexed(sparse = true)
    private String state;

    @Indexed(sparse = true)
    private String description;

    @Indexed(sparse = true)
    private String supportTicketId;
}
