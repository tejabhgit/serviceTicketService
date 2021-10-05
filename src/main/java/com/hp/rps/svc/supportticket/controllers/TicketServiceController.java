package com.hp.rps.svc.supportticket.controllers;

import com.hp.rps.svc.supportticket.model.MessageResource;
import com.hp.rps.svc.supportticket.model.Ticket;
import com.hp.rps.svc.supportticket.repository.TicketRepository;
import com.hp.rps.svc.supportticket.services.JaegerClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

//@EnableBinding(Source.class)
@RestController
public class TicketServiceController {
	
	private TicketRepository ticketRepository;
	private StreamBridge streamBridge;
	private JaegerClientService jaegerClientService;

	@Autowired
	public TicketServiceController (TicketRepository ticketRepository, StreamBridge streamBridge,JaegerClientService jaegerClientService){
		this.ticketRepository = ticketRepository;
		this.streamBridge= streamBridge;
		this.jaegerClientService= jaegerClientService;
	}

	@PostMapping("/addTicket")
	public ResponseEntity <String> saveTicket(@RequestBody Ticket ticket) {
		//input validations
		try {
			ticketRepository.save(ticket);
			return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
		}catch(Exception  e) {
			return new ResponseEntity<>("Not Added Successfully", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAllTickets")
	public Page<Ticket> getTickets(Pageable pageable) {
		return ticketRepository.findAll(pageable);
	}

	@GetMapping("/findAllTickets/{id}")
	public ResponseEntity<Object> getTicket(@PathVariable String id) {
		UUID uuid = StringUtils.isNotBlank(id) ? UUID.fromString(id) : null;
		Optional<Ticket> ticket= ticketRepository.findById(uuid);
		if (ticketRepository.findById(uuid).empty() != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ticket);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(ticket);
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTicket(@PathVariable String id) {
		UUID uuid = StringUtils.isNotBlank(id) ? UUID.fromString(id) : null;
		ticketRepository.deleteById(uuid);
		return "Ticket deleted with id : " + uuid;
	}

	@PostMapping("/publish")
	public MessageResource publish(){
		MessageResource messageResource = new MessageResource();
		messageResource.setName("RPS_TICKET");
		 streamBridge.send("notificationEventSupplier-out-0", MessageBuilder.withPayload(messageResource.getName()).build());
		return messageResource;
	}

	@GetMapping("/jaeger/client/{id}")
	public Mono<String> get(@PathVariable("id") Integer id) {
		return jaegerClientService.get(id);
	}

}
