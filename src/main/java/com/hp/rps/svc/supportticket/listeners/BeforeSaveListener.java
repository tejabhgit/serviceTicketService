package com.hp.rps.svc.supportticket.listeners;

import com.hp.rps.svc.supportticket.model.MetaInfo;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableMongoAuditing
public class BeforeSaveListener extends AbstractMongoEventListener<MetaInfo> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<MetaInfo> event) {

        Date timestamp = new Date();
        if (event.getSource().getCreatedDate() == null)
            event.getSource().builder().createdDate(timestamp);
        event.getSource().builder().lastModifiedDate(timestamp);
        super.onBeforeSave(event);
    }
}
