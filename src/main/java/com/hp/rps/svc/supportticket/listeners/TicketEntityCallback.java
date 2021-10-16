package com.hp.rps.svc.supportticket.listeners;

import com.hp.rps.svc.supportticket.model.Ticket;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

public class TicketEntityCallback implements BeforeConvertCallback<Ticket>, Ordered {
    @Override
    public Ticket onBeforeConvert(Ticket entity, String collection) {
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
