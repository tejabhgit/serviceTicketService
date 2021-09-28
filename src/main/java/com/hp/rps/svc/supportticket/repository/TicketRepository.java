package com.hp.rps.svc.supportticket.repository;

import com.hp.rps.svc.supportticket.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, UUID> {


}