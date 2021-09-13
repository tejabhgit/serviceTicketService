package com.TicketService.supportTicketService.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdResponse;
import lombok.extern.slf4j.Slf4j;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.TicketService.supportTicketService.model.Content;
import com.TicketService.supportTicketService.model.Ticket;
import com.TicketService.supportTicketService.repository.TicketRepository;
import com.example.grpc.server.grpcserver.AddTicketReponse;
import com.example.grpc.server.grpcserver.Category;
import com.example.grpc.server.grpcserver.CurrentAgent;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketResponse;
import com.example.grpc.server.grpcserver.Device;
import com.example.grpc.server.grpcserver.TicketServiceGrpc;

@Slf4j
@GrpcService
public class TicketService extends TicketServiceGrpc.TicketServiceImplBase {

    @Autowired
    private TicketRepository repository;

    @Override
    public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {

        try {
            log.info("Fetching Ticket by Ticket id : {}", request.getId());
            Optional<Ticket> ticket = repository.findById(request.getId());

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
            log.info("Retrieved Ticket id : {}", request.getId());
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void addTicket(AddTicketRequest request, StreamObserver<AddTicketReponse> responseObserver) {

        try {
            log.info("Creating a Support Ticket resource {}", request.getId());
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
            log.info("Successfully added a Support Ticket resource {}", request.getId());

        }catch(Exception e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {
        try {
            log.info("Deleting Ticket by Ticket id : {}", request.getId());
            repository.deleteById(request.getId());
            DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder().setResponse("Ticket deleted with id : "+request.getId()).build();
            responseObserver.onNext(deleteTicketResponse);
            responseObserver.onCompleted();
            log.info("Deleted Ticket id : {}", request.getId());
        }catch(Exception e) {
            log.error(e.getMessage());
        }
    }

}

