package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.AddTicketResponse;
import com.example.grpc.server.grpcserver.CategoryGrpc;
import com.example.grpc.server.grpcserver.CurrentAgentGrpc;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketResponse;
import com.example.grpc.server.grpcserver.DeviceGrpc;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsResponse;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdResponse;
import com.example.grpc.server.grpcserver.MetaInfoGrpc;
import com.example.grpc.server.grpcserver.PageableGrpc;
import com.example.grpc.server.grpcserver.TicketContentGrpc;
import com.example.grpc.server.grpcserver.TicketServiceGrpc;
import com.hp.rps.svc.supportticket.errorhandling.custom.PagedResultNotFoundException;
import com.hp.rps.svc.supportticket.errorhandling.custom.SVCRPSSupportTicketBusinessException;
import com.hp.rps.svc.supportticket.errorhandling.custom.ValidationException;
import com.hp.rps.svc.supportticket.model.Category;
import com.hp.rps.svc.supportticket.model.CurrentAgent;
import com.hp.rps.svc.supportticket.model.Device;
import com.hp.rps.svc.supportticket.model.MetaInfo;
import com.hp.rps.svc.supportticket.model.Ticket;
import com.hp.rps.svc.supportticket.model.TicketContent;
import com.hp.rps.svc.supportticket.repository.TicketRepository;
import com.hp.rps.svc.supportticket.util.CommonUtil;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Null;
import java.util.*;

@Slf4j
@GrpcService
public class TicketService extends TicketServiceGrpc.TicketServiceImplBase {


    private TicketRepository repository;
    private CurrentAgentService currentAgentService;
    private DeviceService deviceService;

    @Autowired
    public void TicketService(TicketRepository repository,
                              CurrentAgentService currentAgentService,
                              DeviceService deviceService) {
        this.repository = repository;
        this.currentAgentService = currentAgentService;
        this.deviceService = deviceService;
    }

    @Override
    @Timed
    public void findAllTickets(FindAllTicketsRequest request, StreamObserver<FindAllTicketsResponse> responseObserver) {
        Page<Ticket> pagedResult = null;
        try {

            //validations
            if (!TicketServiceValidator.validateFindAllRequest(request)) {
                throw new SVCRPSSupportTicketBusinessException("validateFindAllRequest falied as Request couldn't be validated");
                //error handling
            }
            ;

            Pageable paging = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getSortBy()));

            pagedResult = Objects.nonNull(paging) ? repository.findAll(paging) : repository.findAll(Pageable.unpaged());

            PageableGrpc pageableGrpc = PageableGrpc.newBuilder()
                    .setLast(pagedResult.isLast())
                    .setTotalElements(pagedResult.getTotalElements())
                    .setTotalPages(pagedResult.getTotalPages())
                    .setNumberOfElements(pagedResult.getNumberOfElements())
                    .setFirst(pagedResult.isFirst())
                    .setNumber(pagedResult.getNumber())
                    .setEmpty(pagedResult.isEmpty()).build();
            FindAllTicketsResponse findAllTicketsResponse = FindAllTicketsResponse.newBuilder().setPageableGrpc(pageableGrpc).build();
            responseObserver.onNext(findAllTicketsResponse);

            List<TicketContentGrpc> listTicketResponse = new ArrayList<TicketContentGrpc>();

            if (pagedResult.hasContent()) {
                List<Ticket> listTicketPage = pagedResult.getContent();

                listTicketPage.stream().filter(Objects::nonNull)
                        .filter(ticketPage -> ticketPage.getTicket() != null)
                        .forEach(ticketPage -> {

                            CurrentAgentGrpc currentAgentGrpc = CurrentAgentGrpc.newBuilder()
                                    .setUserId(ticketPage.getTicket().getCurrentAgent().getUserId())
                                    .setFirstName(ticketPage.getTicket().getCurrentAgent().getFirstName())
                                    .setLastName(ticketPage.getTicket().getCurrentAgent().getLastName())
                                    .setGravatar(ticketPage.getTicket().getCurrentAgent().getGravatar())
                                    .build();

                            CategoryGrpc categoryGrpc = CategoryGrpc.newBuilder()
                                    .setName(ticketPage.getTicket().getCategory().getName())
                                    .setDescription(ticketPage.getTicket().getCategory().getDescription())
                                    .build();

                            DeviceGrpc deviceGrpc = DeviceGrpc.newBuilder()
                                    .setDeviceId(ticketPage.getTicket().getDevice().getDeviceId())
                                    .setHostname(ticketPage.getTicket().getDevice().getHostname())
                                    .setState(ticketPage.getTicket().getDevice().getState())
                                    .setOs(ticketPage.getTicket().getDevice().getOs())
                                    .build();
                            MetaInfoGrpc metaInfoGrpc = MetaInfoGrpc.newBuilder()
                                    .setCreatedDate(StringUtils.isNotBlank(ticketPage.getMetaInfo().getCreatedDate()) ? ticketPage.getMetaInfo().getCreatedDate() : " ")
                                    .setUpdatedDate(StringUtils.isNotBlank(ticketPage.getMetaInfo().getUpdatedDate()) ? ticketPage.getMetaInfo().getUpdatedDate() : " ")
                                    .setDeletedDate(StringUtils.isNotBlank(ticketPage.getMetaInfo().getDeletedDate()) ? ticketPage.getMetaInfo().getDeletedDate() : " ")
                                    .setVersion(StringUtils.isNotBlank(ticketPage.getMetaInfo().getVersion()) ? ticketPage.getMetaInfo().getVersion() : " ")
                                    .build();

                            TicketContentGrpc ticketResponseGrpc = TicketContentGrpc.newBuilder()
                                    .setId(ticketPage.getTicket().getId())
                                    .setCurrentAgent(currentAgentGrpc)
                                    .setCategory(categoryGrpc)
                                    .setDevice(deviceGrpc).setIssueOpened(ticketPage.getTicket().getIssueOpened())
                                    .setIssueOpened(StringUtils.isNotBlank(ticketPage.getTicket().getIssueOpened()) ? ticketPage.getTicket().getIssueOpened() : " ")
                                    .setIssueClosed(StringUtils.isNotBlank(ticketPage.getTicket().getIssueClosed()) ? ticketPage.getTicket().getIssueClosed() : " ")
                                    .setState(ticketPage.getTicket().getState())
                                    .setDescription(ticketPage.getTicket().getDescription())
                                    .setMetaInfo(metaInfoGrpc)
                                    .setSupportTicketId(ticketPage.getSupportTicketId())
                                    .setOpenTraceId(StringUtils.isNotBlank(ticketPage.getOpenTraceId()) ? ticketPage.getOpenTraceId() : " ")
                                    .setSpanId(StringUtils.isNotBlank(ticketPage.getSpanId()) ? ticketPage.getSpanId() : " ")
                                    .build();
                            listTicketResponse.add(ticketResponseGrpc);
                        });
            }
            listTicketResponse.stream().filter(listTicketRes -> listTicketRes.hasDevice())
                    .forEach(listTicketRes -> {
                        responseObserver.onNext(FindAllTicketsResponse
                                .newBuilder().setTicket(listTicketRes).build());
                    });
            responseObserver.onCompleted();
            log.info("Found all tickets of size: {}", listTicketResponse.size());
        } catch (Exception e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    // Here is our custom exception information
                          //  .augmentDescription().
                   // .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
        }
    }

    @Override
    @Timed
    public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {

        try {
            //validations

            List<Exception> errors = new ArrayList<Exception>();
            if (!TicketServiceValidator.validateGetRequest(request)) {
                throw new ValidationException("validateFindAllRequest falied as Request couldn't be validated");
            }
            UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
            log.info("Fetching Ticket by Ticket id : {}", uuid);
            Optional<Ticket> ticket = repository.findById(uuid);
           if(ticket.isPresent()) {
               CurrentAgentGrpc currentAgentGrpc = CurrentAgentGrpc.newBuilder()
                       .setUserId(ticket.get().getTicket().getCurrentAgent().getUserId())
                       .setFirstName(ticket.get().getTicket().getCurrentAgent().getFirstName())
                       .setLastName(ticket.get().getTicket().getCurrentAgent().getLastName())
                       .setGravatar(ticket.get().getTicket().getCurrentAgent().getGravatar())
                       .build();

               CategoryGrpc categoryGrpc = CategoryGrpc.newBuilder()
                       .setName(ticket.get().getTicket().getCategory().getName())
                       .setDescription(ticket.get().getTicket().getCategory().getDescription())
                       .build();

               DeviceGrpc deviceGrpc = DeviceGrpc.newBuilder()
                       .setDeviceId(ticket.get().getTicket().getDevice().getDeviceId())
                       .setHostname(ticket.get().getTicket().getDevice().getHostname())
                       .setState(ticket.get().getTicket().getDevice().getState())
                       .setOs(ticket.get().getTicket().getDevice().getOs())
                       .build();


               MetaInfoGrpc metaInfoGrpc = MetaInfoGrpc.newBuilder()
                       .setCreatedDate(StringUtils.isNotBlank(ticket.get().getMetaInfo().getCreatedDate()) ? ticket.get().getMetaInfo().getCreatedDate() : " ")
                       .setUpdatedDate(StringUtils.isNotBlank(ticket.get().getMetaInfo().getUpdatedDate()) ? ticket.get().getMetaInfo().getUpdatedDate() : " ")
                       .setDeletedDate(StringUtils.isNotBlank(ticket.get().getMetaInfo().getDeletedDate()) ? ticket.get().getMetaInfo().getDeletedDate() : " ")
                       .setVersion(StringUtils.isNotBlank(ticket.get().getMetaInfo().getVersion()) ? ticket.get().getMetaInfo().getVersion() : " ")
                       .build();

               TicketContentGrpc ticketResponseGrpc = TicketContentGrpc.newBuilder()
                       .setId(ticket.get().getTicket().getId())
                       .setCurrentAgent(currentAgentGrpc)
                       .setCategory(categoryGrpc)
                       .setDevice(deviceGrpc)
                       .setIssueOpened(StringUtils.isNotBlank(ticket.get().getTicket().getIssueOpened()) ? ticket.get().getTicket().getIssueOpened() : " ")
                       .setIssueClosed(StringUtils.isNotBlank(ticket.get().getTicket().getIssueClosed()) ? ticket.get().getTicket().getIssueClosed() : " ")
                       .setState(ticket.get().getTicket().getState())
                       .setDescription(ticket.get().getTicket().getDescription())
                       .setMetaInfo(metaInfoGrpc)
                       .setSupportTicketId(ticket.get().getSupportTicketId())
                       .setOpenTraceId(StringUtils.isNotBlank(ticket.get().getOpenTraceId()) ? ticket.get().getOpenTraceId() : " ")
                       .setSpanId(StringUtils.isNotBlank(ticket.get().getSpanId()) ? ticket.get().getSpanId() : " ")
                       .build();

               GetTicketByIdResponse getTicketResponse = GetTicketByIdResponse.newBuilder()
                       .setTicket(ticketResponseGrpc)
                       .setId(ticket.get().getId().toString()).build();
               responseObserver.onNext(getTicketResponse);
               responseObserver.onCompleted();
               log.info("Retrieved Ticket id : {}", uuid);
           }
           else{
               throw new RecordNotFoundException("Object is not Present");
           }
        }
        catch (ValidationException e) {
            responseObserver.onError(Status.NOT_FOUND
                    // Here is our custom exception information
                    .augmentDescription(new Date().toString())
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        }
        catch (RecordNotFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    // Here is our custom exception information
                    .augmentDescription(new Date().toString())
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        }
        catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .augmentDescription(new Date().toString())
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        }
    }

    @Override
    @Timed(value = "addTicket",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"}
    )
    public void addTicket(AddTicketRequest request, StreamObserver<AddTicketResponse> responseObserver) {

        try {
            log.info("Creating a Support Ticket resource {}", request.getDeviceId());
            Ticket ticket = new Ticket();
            String ticketId = CommonUtil.uniqueUuid().toString();
            ticket.setId(StringUtils.isNotBlank(ticketId) ? UUID.fromString(ticketId) : null);
            ticket.setSupportTicketId(CommonUtil.generateIncrementalNumber());


            //validations
            TicketServiceValidator.validateAddRequest(request);
            TicketServiceValidator.validateTicketIds(ticket);

            //create metadata
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.setVersion("v1");
            metaInfo.setCreatedDate(CommonUtil.generateSystemDate());
            metaInfo.setUpdatedDate(null);
            metaInfo.setDeletedDate(null);
            ticket.setMetaInfo(metaInfo);

            //service to fetch Current Agent
            CurrentAgent currentAgent = currentAgentService.getCurrentAgent(request);

            //service to fetch Device Agent
            Device device = deviceService.getDevice(request);

            Category category = new Category();
            category.setDescription(request.getDescription());
            category.setName(request.getCategory());

            TicketContent ticketContent = new TicketContent();
            ticketContent.setId(ticketId); //generated ticket id
            ticketContent.setCurrentAgent(currentAgent);
            ticketContent.setCategory(category);
            ticketContent.setDevice(device);
            ticketContent.setIssueOpened(CommonUtil.generateSystemDate());
            ticketContent.setIssueClosed(null);
            ticketContent.setState("Active");
            ticketContent.setDescription("Ticket Support is being worked");
            ticket.setOpenTraceId(null);
            ticket.setSpanId(null);

            ticket.setTicket(ticketContent);
            repository.save(ticket);
            AddTicketResponse addTicketReponse = AddTicketResponse.newBuilder().setResponseId(201).build();
            responseObserver.onNext(addTicketReponse);
            responseObserver.onCompleted();
            log.info("Successfully added a Support Ticket resource {}", request.getDeviceId());

        } catch (Exception e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    // Here is our custom exception information
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        }
    }

    @Override
    @Timed
    public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {
        try {
            //validations
            if (!TicketServiceValidator.validateDeleteRequest(request)) {
                Status status = Status.FAILED_PRECONDITION.withDescription("Delete Service failed");
                responseObserver.onError(status.asRuntimeException());
                return;
            }
            UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
            log.info("Deleting Ticket by Ticket id : {}", uuid);
            repository.deleteById(uuid);
            DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder().setResponse("Ticket deleted with id : " + uuid)
                    .build();
            responseObserver.onNext(deleteTicketResponse);
            responseObserver.onCompleted();
            log.info("Deleted Ticket id : {}", uuid);
        } catch (Exception e) {
            Status status = Status.fromThrowable(e);
            log.error("Delete Ticket Exception occurred for" + status.getCode() + " : " + status.getDescription());
            responseObserver.onError(Status.INVALID_ARGUMENT
                    // Here is our custom exception information
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }

}

