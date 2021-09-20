package com.TicketService.supportTicketService.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.TicketService.supportTicketService.model.Ticket;
import com.TicketService.supportTicketService.repository.TicketRepository;



@RestController
public class TicketServiceController {

	@Autowired
	private TicketRepository repository;

	@PostMapping("/addTicket")
	public ResponseEntity <String> saveTicket(@RequestBody Ticket ticket) {
		//input validations
		try {
			repository.save(ticket);
			return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
		}catch(Exception  e) {
			return new ResponseEntity<>("Not Added Successfully", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAllTickets")
	public Page<Ticket> getTickets(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/findAllTickets/{id}")
	public ResponseEntity<Object> getTicket(@PathVariable String id) {
		UUID uuid = StringUtils.isNotBlank(id) ? UUID.fromString(id) : null;
		Optional<Ticket> ticket= repository.findById(uuid);
		if (repository.findById(uuid).empty() != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ticket);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(ticket);
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTicket(@PathVariable String id) {
		UUID uuid = StringUtils.isNotBlank(id) ? UUID.fromString(id) : null;
		repository.deleteById(uuid);
		return "Ticket deleted with id : " + uuid;
	}



}
