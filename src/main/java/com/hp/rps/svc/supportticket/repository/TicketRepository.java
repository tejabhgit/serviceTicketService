package com.hp.rps.svc.supportticket.repository;

import com.hp.rps.svc.supportticket.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, UUID> {

    Ticket findTopByOrderByIdDesc();

    Optional<Ticket> findByIdOrSupportTicketId(UUID id, String supportTicketId);
}