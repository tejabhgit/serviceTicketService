package com.TicketService.supportTicketService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.TicketService.supportTicketService.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, Integer>{


}