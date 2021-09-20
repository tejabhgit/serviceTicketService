package com.TicketService.supportTicketService.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsResponse;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdResponse;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.TicketService.supportTicketService.model.Ticket;
import com.TicketService.supportTicketService.repository.TicketRepository;
import com.example.grpc.server.grpcserver.AddTicketResponse;
import com.example.grpc.server.grpcserver.Category;
import com.example.grpc.server.grpcserver.CurrentAgent;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketResponse;
import com.example.grpc.server.grpcserver.Device;
import com.example.grpc.server.grpcserver.TicketServiceGrpc;
import com.example.grpc.server.grpcserver.TicketContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import util.CommonUtil;

import static com.TicketService.supportTicketService.services.TicketServiceValidator.*;

@Slf4j
@GrpcService
public class TicketService extends TicketServiceGrpc.TicketServiceImplBase {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private CurrentAgentService currentAgentService;

    @Autowired
    private DeviceService deviceService;

    @Override
    @Timed
    public void findAllTickets(FindAllTicketsRequest request, StreamObserver<FindAllTicketsResponse> responseObserver) {
        Page<Ticket> pagedResult = null;
        try {
            //validations
            if (!validateFindAllRequest(request)){
                return;
                //error handling
            };

            Pageable paging = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getSortBy()));

            pagedResult = Objects.nonNull(paging) ? repository.findAll(paging) : repository.findAll(Pageable.unpaged());

            com.example.grpc.server.grpcserver.Pageable pageableGrpc = com.example.grpc.server.grpcserver.Pageable.newBuilder()
                    .setLast(pagedResult.isLast())
                    .setTotalElements(pagedResult.getTotalElements())
                    .setTotalPages(pagedResult.getTotalPages())
                    .setNumberOfElements(pagedResult.getNumberOfElements())
                    .setFirst(pagedResult.isFirst())
                    .setNumber(pagedResult.getNumber())
                    .setEmpty(pagedResult.isEmpty()).build();
            FindAllTicketsResponse findAllTicketsResponse = FindAllTicketsResponse.newBuilder().setPageable(pageableGrpc).build();
            responseObserver.onNext(findAllTicketsResponse);

            List<TicketContent> listTicketResponse = new ArrayList<TicketContent>();

            if (pagedResult.hasContent()) {
                List<Ticket> listTicketPage = pagedResult.getContent();

                listTicketPage.stream().filter(Objects::nonNull)
                        .filter(ticketPage -> ticketPage.getTicketContents() != null)
                        .forEach(ticketPage -> {

                    CurrentAgent currentAgent = CurrentAgent.newBuilder()
                            .setUserId(ticketPage.getTicketContents().get(0).getCurrentAgent().getUserId())
                            .setFirstName(ticketPage.getTicketContents().get(0).getCurrentAgent().getFirstName())
                            .setLastName(ticketPage.getTicketContents().get(0).getCurrentAgent().getLastName())
                            .setGravatar(ticketPage.getTicketContents().get(0).getCurrentAgent().getGravatar())
                            .build();

                    Category category = Category.newBuilder()
                            .setName(ticketPage.getTicketContents().get(0).getCategory().getName())
                            .setDescription(ticketPage.getTicketContents().get(0).getCategory().getDescription())
                            .build();

                    Device device = Device.newBuilder()
                            .setDeviceId(ticketPage.getTicketContents().get(0).getDevice().getDeviceId())
                            .setHostname(ticketPage.getTicketContents().get(0).getDevice().getHostname())
                            .setState(ticketPage.getTicketContents().get(0).getDevice().getState())
                            .setOs(ticketPage.getTicketContents().get(0).getDevice().getOs())
                            .build();

                    TicketContent ticketResponseGrpc = TicketContent.newBuilder()
                            .setId(ticketPage.getTicketContents().get(0).getId())
                            .setCurrentAgent(currentAgent)
                            .setCategory(category)
                            .setDevice(device)
                            .setIssueOpened(ticketPage.getTicketContents().get(0).getIssueOpened())
                            .setIssueClosed(ticketPage.getTicketContents().get(0).getIssueClosed())
                            .setState(ticketPage.getTicketContents().get(0).getState())
                            .setDescription(ticketPage.getTicketContents().get(0).getDescription()).build();
                    listTicketResponse.add(ticketResponseGrpc);
                });
            }
            listTicketResponse.stream().filter(listTicketRes -> listTicketRes.hasDevice())
                    .forEach(listTicketRes -> {
                        responseObserver.onNext(FindAllTicketsResponse
                                .newBuilder().setTicketContent(listTicketRes).build());
                    });
            responseObserver.onCompleted();
            log.info("Found all tickets of size: {}",listTicketResponse.size() );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    @Timed
    public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {

        try {
            //validations
            if (!validateGetRequest(request)){
                return;
                //error handling
            };

            UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
            log.info("Fetching Ticket by Ticket id : {}", uuid);
            Optional<Ticket> ticket = repository.findById(uuid);

            CurrentAgent currentAgent = CurrentAgent.newBuilder()
                    .setUserId(ticket.get().getTicketContents().get(0).getCurrentAgent().getUserId())
                    .setFirstName(ticket.get().getTicketContents().get(0).getCurrentAgent().getFirstName())
                    .setLastName(ticket.get().getTicketContents().get(0).getCurrentAgent().getLastName())
                    .setGravatar(ticket.get().getTicketContents().get(0).getCurrentAgent().getGravatar())
                    .build();

            Category category = Category.newBuilder()
                    .setName(ticket.get().getTicketContents().get(0).getCategory().getName())
                    .setDescription(ticket.get().getTicketContents().get(0).getCategory().getDescription())
                    .build();

            Device device = Device.newBuilder()
                    .setDeviceId(ticket.get().getTicketContents().get(0).getDevice().getDeviceId())
                    .setHostname(ticket.get().getTicketContents().get(0).getDevice().getHostname())
                    .setState(ticket.get().getTicketContents().get(0).getDevice().getState())
                    .setOs(ticket.get().getTicketContents().get(0).getDevice().getOs())
                    .build();

            TicketContent ticketResponseGrpc = TicketContent.newBuilder()
                    .setId(ticket.get().getTicketContents().get(0).getId())
                    .setCurrentAgent(currentAgent)
                    .setCategory(category)
                    .setDevice(device).setIssueOpened(ticket.get().getTicketContents().get(0).getIssueOpened())
                    .setIssueClosed(ticket.get().getTicketContents().get(0).getIssueClosed())
                    .setState(ticket.get().getTicketContents().get(0).getState())
                    .setDescription(ticket.get().getTicketContents().get(0).getDescription()).build();

            GetTicketByIdResponse getTicketResponse = GetTicketByIdResponse.newBuilder().setTicketContent(ticketResponseGrpc).build();
            responseObserver.onNext(getTicketResponse);
            responseObserver.onCompleted();
            log.info("Retrieved Ticket id : {}", uuid);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    @Timed (value = "addTicket",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"}
    )
    public void addTicket(AddTicketRequest request, StreamObserver<AddTicketResponse> responseObserver) {

        try {

            //validations
            if (!validateAddRequest(request)){
                return;
            };

            log.info("Creating a Support Ticket resource {}", request.getDeviceId());
            Ticket ticket = new Ticket();
            String ticketId = CommonUtil.unique();
            ticket.setId(UUID.fromString(ticketId));

            //service to fetch Current Agent
            com.TicketService.supportTicketService.model.CurrentAgent currentAgent = currentAgentService.getCurrentAgent(request);

            //service to fetch Device Agent
            com.TicketService.supportTicketService.model.Device device = deviceService.getDevice(request);

            com.TicketService.supportTicketService.model.Category category = new com.TicketService.supportTicketService.model.Category();
            category.setDescription(request.getDescription());
            category.setName(request.getCategory());

            com.TicketService.supportTicketService.model.TicketContent ticketContent = new com.TicketService.supportTicketService.model.TicketContent();
            ticketContent.setId(ticketId); //generated ticket id
            ticketContent.setCurrentAgent(currentAgent);
            ticketContent.setCategory(category);
            ticketContent.setDevice(device);
            ticketContent.setIssueOpened(12346789);
            ticketContent.setIssueClosed(78945612);
            ticketContent.setState("Active");
            ticketContent.setDescription("Ticket Support is being worked");

            //create metadata

            List<com.TicketService.supportTicketService.model.TicketContent> ticketResponseList = new ArrayList<>();
            ticketResponseList.add(ticketContent);
            ticket.setTicketContents(ticketResponseList);
            repository.save(ticket);
            AddTicketResponse addTicketReponse = AddTicketResponse.newBuilder().setResponseId(201).build();
            responseObserver.onNext(addTicketReponse);
            responseObserver.onCompleted();
            log.info("Successfully added a Support Ticket resource {}", request.getDeviceId());

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    @Timed
    public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {
        try {
            //validations
            if (!validateDeleteRequest(request)){
                return;
            };
            UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
            log.info("Deleting Ticket by Ticket id : {}", uuid);
            repository.deleteById(uuid);
            DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder().setResponse("Ticket deleted with id : " + uuid).build();
            responseObserver.onNext(deleteTicketResponse);
            responseObserver.onCompleted();
            log.info("Deleted Ticket id : {}", uuid);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}

