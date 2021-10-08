package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.CategoryGrpc;
import com.example.grpc.server.grpcserver.CurrentAgentGrpc;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeviceGrpc;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.MetaInfoGrpc;
import com.example.grpc.server.grpcserver.PageableGrpc;
import com.example.grpc.server.grpcserver.TicketContentGrpc;
import com.example.grpc.server.grpcserver.UpdateOneTicketByIDRequest;
import com.hp.rps.svc.supportticket.datalayer.TicketDataService;
import com.hp.rps.svc.supportticket.errorhandling.custom.RecordNotFoundException;
import com.hp.rps.svc.supportticket.errorhandling.custom.ValidationException;
import com.hp.rps.svc.supportticket.model.Category;
import com.hp.rps.svc.supportticket.model.CurrentAgent;
import com.hp.rps.svc.supportticket.model.Device;
import com.hp.rps.svc.supportticket.model.MetaInfo;
import com.hp.rps.svc.supportticket.model.Ticket;
import com.hp.rps.svc.supportticket.util.CommonUtil;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketService {

    private TicketDataService ticketDataService;
    private CurrentAgentService currentAgentService;
    private DeviceService deviceService;

    @Autowired
    public void TicketService(TicketDataService ticketDataService,
                              CurrentAgentService currentAgentService,
                              DeviceService deviceService) {
        this.currentAgentService = currentAgentService;
        this.deviceService = deviceService;
        this.ticketDataService = ticketDataService;
    }


    public TicketListResponse getPagedTicketResponse(FindAllTicketsRequest request) {
        Page<Ticket> pagedResult = null;
        //validations
        if (!TicketServiceValidator.validateFindAllRequest(request)) {
            throw new ValidationException("validation exception sortBy parm cannot be null");
        }
        pagedResult = ticketDataService.findAllPagedResponse(request, pagedResult);
        if (pagedResult.isEmpty()) {
            throw new RecordNotFoundException("No Records Found");
        }
        PageableGrpc pageableGrpc = PageableGrpc.newBuilder()
                .setLast(pagedResult.isLast())
                .setTotalElements(pagedResult.getTotalElements())
                .setTotalPages(pagedResult.getTotalPages())
                .setNumberOfElements(pagedResult.getNumberOfElements())
                .setFirst(pagedResult.isFirst())
                .setNumber(pagedResult.getNumber())
                .setEmpty(pagedResult.isEmpty()).build();

        List<TicketContentGrpc.Builder> listTicketResponse = new ArrayList<TicketContentGrpc.Builder>();
        List<Ticket> listTicketPage = pagedResult.getContent();
        listTicketPage.stream().filter(Objects::nonNull)
                .forEach(ticketPage -> {
                    TicketContentGrpc.Builder ticketContentGrpc = buildTicketResponse(ticketPage);
                    listTicketResponse.add(ticketContentGrpc);
                });
        TicketListResponse ticketListResponse = TicketListResponse.builder()
                .pageableGrpc(pageableGrpc)
                .TicketContentList(listTicketResponse)
                .build();
        return ticketListResponse;
    }

    public TicketContentGrpc.Builder getTicketById(GetTicketByIdRequest request) {
        log.info("Fetching Ticket by Ticket id : {} or support Ticket id: {}", request.getId(), request.getSupportTicketId());
        Ticket ticket = ticketDataService.findByRequest(CommonUtil.nullCheckUuid(request.getId()), request.getSupportTicketId()).orElseThrow(RecordNotFoundException::new);
        TicketContentGrpc.Builder ticketContentGrpc = buildTicketResponse(ticket);
        return ticketContentGrpc;
    }

    public void addTicket(AddTicketRequest request) {
        log.info("Creating a Support Ticket resource {}", request.getDeviceId());
        Ticket ticket = buildTicketEntity(request);
        ticketDataService.insert(ticket);
        log.info("Successfully added a Support Ticket resource {}", ticket.getId().toString());
    }

    @Timed
    public void deleteTicket(DeleteTicketRequest request) {
        log.info("Deleting Ticket by Ticket id : {}", request.getId());
        ticketDataService.deleteTicket(CommonUtil.nullCheckUuid(request.getId()));
    }

    public TicketContentGrpc.Builder buildTicketResponse(Ticket ticket) {
        CurrentAgentGrpc.Builder currentAgentGrpc = CurrentAgentGrpc.newBuilder();
        CategoryGrpc.Builder categoryGrpc = CategoryGrpc.newBuilder();
        DeviceGrpc.Builder deviceGrpc = DeviceGrpc.newBuilder();
        MetaInfoGrpc.Builder metaInfoGrpc = MetaInfoGrpc.newBuilder();

        if (Objects.nonNull(ticket.getCurrentAgent())) {
            Optional.ofNullable(ticket.getCurrentAgent().getUserId().toString()).ifPresent(currentAgentGrpc::setUserId);
            Optional.ofNullable(ticket.getCurrentAgent().getFirstName()).ifPresent(currentAgentGrpc::setFirstName);
            Optional.ofNullable(ticket.getCurrentAgent().getLastName()).ifPresent(currentAgentGrpc::setLastName);
            Optional.ofNullable(ticket.getCurrentAgent().getGravatar()).ifPresent(currentAgentGrpc::setGravatar);
            currentAgentGrpc.build();
        }
        if (Objects.nonNull(ticket.getCategory())) {
            Optional.ofNullable(ticket.getCategory().getName()).ifPresent(categoryGrpc::setName);
            Optional.ofNullable(ticket.getCategory().getDescription()).ifPresent(categoryGrpc::setDescription);
            categoryGrpc.build();
        }
        if (Objects.nonNull(ticket.getDevice())) {
            Optional.ofNullable(ticket.getDevice().getDeviceId().toString()).ifPresent(deviceGrpc::setDeviceId);
            Optional.ofNullable(ticket.getDevice().getHostname()).ifPresent(deviceGrpc::setHostname);
            Optional.ofNullable(ticket.getDevice().getState()).ifPresent(deviceGrpc::setState);
            Optional.ofNullable(ticket.getDevice().getOs()).ifPresent(deviceGrpc::setOs);
            deviceGrpc.build();
        }
        if (Objects.nonNull(ticket.getMetaInfo())) {
            Optional.ofNullable(ticket.getMetaInfo().getCreatedDate()).ifPresent(createDt -> metaInfoGrpc.setCreatedDate(createDt.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getLastModifiedDate()).ifPresent(lstMdDt -> metaInfoGrpc.setLastModifiedDate(lstMdDt.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getDeletedDate()).ifPresent(delDte -> metaInfoGrpc.setDeletedDate(delDte.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getCreatedBy()).ifPresent(crtBy -> metaInfoGrpc.setCreatedBy(crtBy.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getLastModifiedBy()).ifPresent(lstModBy -> metaInfoGrpc.setLastModifiedBy(lstModBy.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getDeletedBy()).ifPresent(delBy -> metaInfoGrpc.setDeletedBy(delBy.toString()));
            Optional.ofNullable(ticket.getMetaInfo().getVersion()).ifPresent(metaInfoGrpc::setVersion);
            currentAgentGrpc.build();
        }
        TicketContentGrpc.Builder ticketResponseGrpc = TicketContentGrpc.newBuilder();

        Optional.ofNullable(ticket.getId().toString()).ifPresent(ticketResponseGrpc::setId);
        if (Objects.nonNull(ticket.getCurrentAgent())) {
            ticketResponseGrpc.setCurrentAgent(currentAgentGrpc);
        }
        if (Objects.nonNull(ticket.getDevice())) {
            ticketResponseGrpc.setDevice(deviceGrpc);
        }
        if (Objects.nonNull(ticket.getCategory())) {
            ticketResponseGrpc.setCategory(categoryGrpc);
        }
        if (Objects.nonNull(ticket.getMetaInfo())) {
            ticketResponseGrpc.setMetaInfo(metaInfoGrpc);
        }
        Optional.ofNullable(ticket.getIssueClosed()).ifPresent(ticketResponseGrpc::setIssueClosed);
        Optional.ofNullable(ticket.getIssueOpened()).ifPresent(ticketResponseGrpc::setIssueOpened);
        Optional.ofNullable(ticket.getState()).ifPresent(ticketResponseGrpc::setState);
        Optional.ofNullable(ticket.getState()).ifPresent(ticketResponseGrpc::setDescription);
        Optional.ofNullable(ticket.getDescription()).ifPresent(ticketResponseGrpc::setSupportTicketId);
        ticketResponseGrpc.build();
        return ticketResponseGrpc;
    }

    private Ticket buildTicketEntity(AddTicketRequest request) {
        String ticketId = CommonUtil.uniqueUuid().toString();
        MetaInfo metaInfo = MetaInfo.builder()
                .version("1")
                .createdBy(CommonUtil.nullCheckUuid("d4db0a66-c1f9-4005-99d4-83d79a17fe9f"))
                .build();

        Category category = Category.builder()
                .description(request.getDescription())
                .name(request.getCategory()).build();
        //service to fetch Current Agent and Device
        CurrentAgent currentAgent = currentAgentService.getCurrentAgent(request);
        Device device = deviceService.getDevice(request);
        Ticket ticket = Ticket.builder()
                .id(CommonUtil.nullCheckUuid(ticketId))
                .supportTicketId(CommonUtil.generateIncrementalNumber())
                .description("Ticket Support is being worked_HARDCODED")
                .state("Active_HARDCODED")
                .metaInfo(metaInfo)
                .currentAgent(currentAgent)
                .device(device)
                .category(category)
                .issueOpened(CommonUtil.generateSystemDate())
                .build();
        return ticket;
    }

    public void updateTicket(UpdateOneTicketByIDRequest request) {
            log.info("Fetching Ticket by Ticket id : {} or support Ticket id: {}", request.getTicket().getId(), request.getTicket().getSupportTicketId());
            Ticket ticketDtoResponse = ticketDataService.findByRequest(CommonUtil.nullCheckUuid(request.getTicket().getId()), request.getTicket().getSupportTicketId()).orElseThrow(RecordNotFoundException::new);
            mapRequestToResponseAndUpdateTicket(request, ticketDtoResponse);
    }

    private void mapRequestToResponseAndUpdateTicket(UpdateOneTicketByIDRequest request, Ticket ticketDtoResponse) {
        Ticket.TicketBuilder ticket = Ticket.builder();
        CurrentAgent.CurrentAgentBuilder currentAgentBuilder = CurrentAgent.builder();

        if (Objects.equals(CommonUtil.nullCheckUuid(request.getTicket().getId()), ticketDtoResponse.getId())){
            Optional.of(request.getTicket().getSupportTicketId()).ifPresent(ticket::supportTicketId);
            Optional.of(request.getTicket().getDescription()).ifPresent(ticket::description);
            Optional.of(request.getTicket().getState()).ifPresent(ticket::state);
            Optional.of(request.getTicket().getIssueOpened()).ifPresent(ticket::issueOpened);
            Optional.of(request.getTicket().getIssueClosed()).ifPresent(ticket::issueClosed);
            Optional.of(request.getTicket().getCurrentAgent().getUserId()).ifPresent(x -> currentAgentBuilder.userId(UUID.fromString(x)));
            Optional.of(request.getTicket().getCurrentAgent().getFirstName()).ifPresent(currentAgentBuilder::firstName);

    }
}
}