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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@Document(collection = "Session")
@TypeAlias("session")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session implements Serializable {
    @Id
    @Indexed
    @Field("ID")
    private UUID id;

    @Indexed(sparse = true)
    @Field("CURR_AGENT_USR_ID")
    private UUID currentAgentUserId;

    @Indexed
    @Field("DEVICE_ID")
    @NotNull(message = "Please provide a DEVICE_ID")
    @NotBlank(message = "Please provide a DEVICE_ID")
    private UUID deviceId;

    @Field("META_INFO")
	private MetaInfo metaInfo;

    @Field("SUPP_TICKET_ID")
    @Indexed(sparse = true)
    @NotNull(message = "Please provide a SUPP_TICKET_ID")
    @NotBlank(message = "Please provide a SUPP_TICKET_ID")
    private String supportTicketId;

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }
}
