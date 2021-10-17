package com.hp.rps.svc.supportticket.listeners;

import com.hp.rps.svc.supportticket.model.Session;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

public class SessionEntityCallback implements BeforeConvertCallback<Session>, Ordered {
    @Override
    public Session onBeforeConvert(Session entity, String collection) {
        if (entity.isNew()) {
            entity.setId(UUID.randomUUID());
        }
        return entity;
    }

    @Override
    public int getOrder() {
        return 101;
    }
}
