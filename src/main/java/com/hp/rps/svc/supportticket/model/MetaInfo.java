package com.hp.rps.svc.supportticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "MetaInfo")
public class MetaInfo {
    private String version;
    private String createdDate;
    private String UpdatedDate;
    private String deletedDate;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
}
