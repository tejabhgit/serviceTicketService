package com.hp.rps.svc.supportticket.config;

import com.hp.rps.svc.supportticket.model.MetaInfo;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.util.Date;

public class BeforeSaveListener extends AbstractMongoEventListener<MetaInfo> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<MetaInfo> event) {

        Date timestamp = new Date();
        MetaInfo metaInfo = event.getSource();
            if(metaInfo.getCreatedDate() == null){
                MetaInfo.builder().createdDate(timestamp);
            }
        MetaInfo.builder().lastModifiedDate(timestamp);
        super.onBeforeSave(event);
    }
}
