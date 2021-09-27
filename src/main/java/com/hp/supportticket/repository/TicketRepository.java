package com.hp.supportticket.repository;

import com.hp.supportticket.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, UUID> {


}