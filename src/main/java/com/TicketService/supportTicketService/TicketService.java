package com.TicketService.supportTicketService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.TicketService.supportTicketService.model.Content;
import com.TicketService.supportTicketService.model.Ticket;
import com.TicketService.supportTicketService.repository.TicketRepository;
import com.example.grpc.server.grpcserver.*;

@GrpcService
public class TicketService extends TicketServiceGrpc.TicketServiceImplBase {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketService.class);
	
	@Autowired
	private TicketRepository repository;

	@Override
	public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {
	
		try {
		int id =request.getId();
		LOGGER.info("Id {}", id);
		Optional<Ticket> ticket = repository.findById(id);
		
		CurrentAgent currentAgent = CurrentAgent.newBuilder().
				setUserId(ticket.get().getContent().get(0).getCurrentAgent().getUserId()).setFirstName(ticket.get().getContent().get(0).getCurrentAgent().getFirstName()).
				setLastName(ticket.get().getContent().get(0).getCurrentAgent().getLastName()).setGravatar(ticket.get().getContent().get(0).getCurrentAgent().getGravatar()).build();
		
		Category category = Category.newBuilder().setName(ticket.get().getContent().get(0).getCategory().getName()).
				setDescription(ticket.get().getContent().get(0).getCategory().getDescription()).build();
		
		Device device = Device.newBuilder().
				setDeviceId(ticket.get().getContent().get(0).getDevice().getDeviceId()).
				setHostname(ticket.get().getContent().get(0).getDevice().getHostname()).
				setState(ticket.get().getContent().get(0).getDevice().getState()).setOs(ticket.get().getContent().get(0).getDevice().getOs()).build();
		
		com.example.grpc.server.grpcserver.Content content = com.example.grpc.server.grpcserver.Content.newBuilder().setId(ticket.get().getContent().get(0).getId()).
				setCurrentAgent(currentAgent).setCategory(category).setDevice(device).setIssueOpened(ticket.get().getContent().get(0).getIssueOpened()).
				setIssueClosed(ticket.get().getContent().get(0).getIssueClosed()).setState(ticket.get().getContent().get(0).getState()).
				setDescription(ticket.get().getContent().get(0).getDescription()).build();
	
		
		
		GetTicketByIdResponse getTicketResponse = GetTicketByIdResponse.newBuilder().setLast(ticket.get().isLast()).setTotalElements(ticket.get().getTotalElements()).setTotalPages(ticket.get().getTotalPages()).
				setNumberOfElements(ticket.get().getNumber()).setFirst(ticket.get().isFirst()).setNumber(ticket.get().getNumber()).setEmpty(ticket.get().isEmpty()).setContent(content).build();
		responseObserver.onNext(getTicketResponse);
        responseObserver.onCompleted();
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void addTicket(AddTicketRequest request, StreamObserver<AddTicketReponse> responseObserver) {
		
		try {
			 Ticket ticket = new Ticket();
			 ticket.setId(request.getId());
			 ticket.setLast(request.getLast());
			 ticket.setTotalElements(request.getTotalElements());
			 ticket.setTotalPages(request.getTotalPages());
			 ticket.setFirst(request.getFirst());
			 ticket.setNumber(request.getNumber());
			 ticket.setEmpty(request.getEmpty());
			 com.TicketService.supportTicketService.model.CurrentAgent currentAgent = new  com.TicketService.supportTicketService.model.CurrentAgent();	 
			 currentAgent.setUserId(request.getContent(0).getCurrentAgent().getUserId());
			 currentAgent.setGravatar(request.getContent(0).getCurrentAgent().getGravatar());
			 currentAgent.setFirstName(request.getContent(0).getCurrentAgent().getFirstName());
			 currentAgent.setLastName(request.getContent(0).getCurrentAgent().getLastName());
			  
			 com.TicketService.supportTicketService.model.Category category = new com.TicketService.supportTicketService.model.Category();
			 category.setDescription(request.getContent(0).getCategory().getDescription());
			 category.setName(request.getContent(0).getCategory().getName());
			 
			 com.TicketService.supportTicketService.model.Device device = new com.TicketService.supportTicketService.model.Device();
			 device.setDeviceId(request.getContent(0).getDevice().getDeviceId());
			 device.setHostname(request.getContent(0).getDevice().getHostname());
			 device.setOs(request.getContent(0).getDevice().getOs());
			 device.setState(request.getContent(0).getDevice().getState());
			 
			 com.TicketService.supportTicketService.model.Content content = new com.TicketService.supportTicketService.model.Content();
			 content.setId(request.getContent(0).getId());
			 content.setCurrentAgent(currentAgent);
			 content.setCategory(category);
			 content.setDevice(device);
			 content.setIssueOpened(request.getContent(0).getIssueOpened());
			 content.setIssueClosed(request.getContent(0).getIssueClosed());
			 content.setState(request.getContent(0).getState());
			 content.setDescription(request.getContent(0).getDescription());
			 
			 List<Content> contentList = new ArrayList<>();
			 contentList.add(content);
			 ticket.setContent(contentList);
			 
			 repository.save(ticket);
			 
			 AddTicketReponse addTicketReponse = AddTicketReponse.newBuilder().setResponseId(200).build();
			 responseObserver.onNext(addTicketReponse);
		     responseObserver.onCompleted();		 
			 
			}catch(Exception e) {	
				LOGGER.error(e.getMessage());
			}
			 
	  }
	
	@Override
	public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {

		try {
			repository.deleteById(request.getId());
			DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder().setResponse("Ticket deleted with id : "+request.getId()).build();
			responseObserver.onNext(deleteTicketResponse);
		    responseObserver.onCompleted();	
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	}

