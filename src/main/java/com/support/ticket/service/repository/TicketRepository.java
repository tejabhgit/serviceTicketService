package com.support.ticket.service.repository;

import com.support.ticket.service.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, UUID> {


}