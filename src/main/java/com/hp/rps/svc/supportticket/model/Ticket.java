package com.hp.rps.svc.supportticket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.UUID;


@Builder
@Data
@Document(collection = "Ticket")
@TypeAlias("ticket")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket implements Serializable {
    @Id
    @Indexed
    @Field("ID")
    private UUID id;

    @Indexed
    @Field("CURR_AGENT_USR_ID")
    private UUID currentAgentUserId;

    @Field("CATEGORY")
    private Category category;

    @Indexed
    @Field("DEVICE_ID")
    private UUID deviceId;

    @Field("META_INFO")
    private MetaInfo metaInfo;

    @Field("STATE")
    @Indexed(sparse = true)
    private String state;

    @Field("DESCRIPTION")
    @Indexed(sparse = true)
    private String description;

    @Field("SUPP_TICKET_ID")
    @Indexed(sparse = true)
    private String supportTicketId;

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }
}
