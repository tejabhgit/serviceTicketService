package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Builder
@Data
public class MetaInfo {

    @Version
    @Field("VERSION")
    private long version;

    @Field("CREATED_BY")
    @CreatedBy
    private UUID createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Field("CREATED_DATE")
    @CreatedDate
    private Date createdDate;

    @Field("LAST_MODIFIED_BY")
    @LastModifiedBy
    private UUID lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Field("LAST_MODIFIED_DATE")
    @LastModifiedDate
    private Date lastModifiedDate;

    @Field("DELETED_BY")
    private UUID deletedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Field("DELETED_DATE")
    private Date deletedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Field("ISSUED_OPENED_DATE")
    private Date issueOpened;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Field("ISSUED_CLOSED_DATE")
    private Date issueClosed;

}
