package com.TicketService.supportTicketService.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.TicketService.supportTicketService.model.Ticket;
import com.TicketService.supportTicketService.repository.TicketRepository;




@RestController
public class TicketServiceController {
	
	
	@Autowired
	private TicketRepository repository;

	@PostMapping("/addTicket")
	public ResponseEntity <String> saveTicket(@RequestBody Ticket ticket) {
		try {
		repository.save(ticket);
		return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
		}catch(Exception  e) {
			return new ResponseEntity<>("Not Added Successfully", HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/findAllTickets")
	public List<Ticket> getTickets() {
		return repository.findAll();
	}

	@GetMapping("/findAllTickets/{id}")
	public ResponseEntity<Object> getTicket(@PathVariable int id) {	
		Optional<Ticket> ticket= repository.findById(id);
		if (repository.findById(id).empty() != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ticket);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(ticket);

		}
		
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTicket(@PathVariable int id) {
		repository.deleteById(id);
		return "Ticket deleted with id : " + id;
	}
	
	
	
}
