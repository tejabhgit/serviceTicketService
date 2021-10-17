package com.hp.rps.svc.supportticket.repository;

import com.hp.rps.svc.supportticket.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends MongoRepository<Session, UUID> {

    Session findTopByOrderByIdDesc();

    Optional<Session> findByIdOrSupportTicketId(UUID id, String supportTicketId);
}