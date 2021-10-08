package com.hp.rps.svc.supportticket.datalayer;

import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.hp.rps.svc.supportticket.model.Ticket;
import com.hp.rps.svc.supportticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketDataService {

    @Autowired
    private TicketRepository ticketRepository;

    public Optional<Ticket> findByRequest(UUID uuid, String supportTicketId){
        return ticketRepository.findByIdOrSupportTicketId(uuid, supportTicketId);
    }

    public void insert(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void update(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void deleteTicket(UUID uuid) {
        ticketRepository.deleteById(uuid);
    }

    public Page<Ticket> findAllPagedResponse(FindAllTicketsRequest request, Page<Ticket> pagedResult) {
        Pageable paging = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getSortBy()));
        pagedResult = Objects.nonNull(paging) ? ticketRepository.findAll(paging) : ticketRepository.findAll(Pageable.unpaged());
        return pagedResult;
    }

    public List<Ticket> getAllByExample(Ticket ticket){
        Example<Ticket> example = Example.of(ticket);
        return ticketRepository.findAll(example);
    }

/*    public long getNext() {
        Ticket last = ticketRepository.findTopByOrderByIdDesc();
        long lastNum = last.seq;
        return (lastNum + 1);
    }*/

}
