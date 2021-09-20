package com.TicketService.supportTicketService.repository;

import com.TicketService.supportTicketService.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, UUID> {


}