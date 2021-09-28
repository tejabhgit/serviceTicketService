package com.hp.supportticket.services;

import com.hp.supportticket.errors.server.PagedResultNotFoundException;
import com.hp.supportticket.errors.server.RecordNotFoundException;
import com.hp.supportticket.errors.server.SVCRPSSupportTicketBuisnessException;
import com.hp.supportticket.errors.server.ValidationException;
import com.hp.supportticket.model.Category;
import com.hp.supportticket.model.CurrentAgent;
import com.hp.supportticket.model.Device;
import com.hp.supportticket.model.MetaInfo;
import com.hp.supportticket.model.Ticket;
import com.hp.supportticket.model.TicketContent;
import com.hp.supportticket.repository.TicketRepository;
import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsResponse;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdResponse;
import com.example.grpc.server.grpcserver.PageableGrpc;
import io.grpc.Status;
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
import com.example.grpc.server.grpcserver.AddTicketResponse;
import com.example.grpc.server.grpcserver.CategoryGrpc;
import com.example.grpc.server.grpcserver.CurrentAgentGrpc;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketResponse;
import com.example.grpc.server.grpcserver.DeviceGrpc;
import com.example.grpc.server.grpcserver.TicketServiceGrpc;
import com.example.grpc.server.grpcserver.TicketContentGrpc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import util.CommonUtil;

@Slf4j
@GrpcService
public class TicketService extends TicketServiceGrpc.TicketServiceImplBase {

	private TicketRepository repository;
	private CurrentAgentService currentAgentService;
	private DeviceService deviceService;

	@Autowired
	public void TicketService(TicketRepository repository, CurrentAgentService currentAgentService,
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
			// validations
			if (!TicketServiceValidator.validateFindAllRequest(request)) {
				throw new ValidationException("validateFindAllRequest falied as Request couldn't be validated");
			}

			Pageable paging = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getSortBy()));

			pagedResult = Objects.nonNull(paging) ? repository.findAll(paging) : repository.findAll(Pageable.unpaged());

			PageableGrpc pageableGrpc = PageableGrpc.newBuilder().setLast(pagedResult.isLast())
					.setTotalElements(pagedResult.getTotalElements()).setTotalPages(pagedResult.getTotalPages())
					.setNumberOfElements(pagedResult.getNumberOfElements()).setFirst(pagedResult.isFirst())
					.setNumber(pagedResult.getNumber()).setEmpty(pagedResult.isEmpty()).build();
			FindAllTicketsResponse findAllTicketsResponse = FindAllTicketsResponse.newBuilder()
					.setPageableGrpc(pageableGrpc).build();
			responseObserver.onNext(findAllTicketsResponse);

			List<TicketContentGrpc> listTicketResponse = new ArrayList<TicketContentGrpc>();

			if (pagedResult.hasContent()) {
				List<Ticket> listTicketPage = pagedResult.getContent();

				listTicketPage.stream().filter(Objects::nonNull)
						.filter(ticketPage -> ticketPage.getTicketContents() != null).forEach(ticketPage -> {

							CurrentAgentGrpc currentAgentGrpc = CurrentAgentGrpc.newBuilder()
									.setUserId(ticketPage.getTicketContents().get(0).getCurrentAgent().getUserId())
									.setFirstName(
											ticketPage.getTicketContents().get(0).getCurrentAgent().getFirstName())
									.setLastName(ticketPage.getTicketContents().get(0).getCurrentAgent().getLastName())
									.setGravatar(ticketPage.getTicketContents().get(0).getCurrentAgent().getGravatar())
									.build();

							CategoryGrpc categoryGrpc = CategoryGrpc.newBuilder()
									.setName(ticketPage.getTicketContents().get(0).getCategory().getName())
									.setDescription(
											ticketPage.getTicketContents().get(0).getCategory().getDescription())
									.build();

							DeviceGrpc deviceGrpc = DeviceGrpc.newBuilder()
									.setDeviceId(ticketPage.getTicketContents().get(0).getDevice().getDeviceId())
									.setHostname(ticketPage.getTicketContents().get(0).getDevice().getHostname())
									.setState(ticketPage.getTicketContents().get(0).getDevice().getState())
									.setOs(ticketPage.getTicketContents().get(0).getDevice().getOs()).build();

							TicketContentGrpc ticketResponseGrpc = TicketContentGrpc.newBuilder()
									.setId(ticketPage.getTicketContents().get(0).getId())
									.setCurrentAgent(currentAgentGrpc).setCategory(categoryGrpc).setDevice(deviceGrpc)
									.setIssueOpened(ticketPage.getTicketContents().get(0).getIssueOpened())
									.setIssueClosed(ticketPage.getTicketContents().get(0).getIssueClosed())
									.setState(ticketPage.getTicketContents().get(0).getState())
									.setDescription(ticketPage.getTicketContents().get(0).getDescription()).build();
							listTicketResponse.add(ticketResponseGrpc);
						});
			} else {
				throw new PagedResultNotFoundException("PagedResult Not Found for");
			}
			listTicketResponse.stream().filter(listTicketRes -> listTicketRes.hasDevice()).forEach(listTicketRes -> {
				responseObserver
						.onNext(FindAllTicketsResponse.newBuilder().setTicketContentGrpc(listTicketRes).build());
			});
			responseObserver.onCompleted();
		} catch (Exception e) {
			throw new SVCRPSSupportTicketBuisnessException("603", "Something went Wrong " + e.getMessage());
		}
	}

	@Override
	@Timed
	public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {

		try {
			// validations
			if (!TicketServiceValidator.validateGetRequest(request)) {
				throw new ValidationException("validateFindAllRequest falied as Request couldn't be validated");
			}
			;

			UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
			// log.info("Fetching Ticket by Ticket id : {}", uuid);
			Optional<Ticket> ticket = repository.findById(uuid);
			if (ticket.isPresent()) {
				CurrentAgentGrpc currentAgentGrpc = CurrentAgentGrpc.newBuilder()
						.setUserId(ticket.get().getTicketContents().get(0).getCurrentAgent().getUserId())
						.setFirstName(ticket.get().getTicketContents().get(0).getCurrentAgent().getFirstName())
						.setLastName(ticket.get().getTicketContents().get(0).getCurrentAgent().getLastName())
						.setGravatar(ticket.get().getTicketContents().get(0).getCurrentAgent().getGravatar()).build();

				CategoryGrpc categoryGrpc = CategoryGrpc.newBuilder()
						.setName(ticket.get().getTicketContents().get(0).getCategory().getName())
						.setDescription(ticket.get().getTicketContents().get(0).getCategory().getDescription()).build();

				DeviceGrpc deviceGrpc = DeviceGrpc.newBuilder()
						.setDeviceId(ticket.get().getTicketContents().get(0).getDevice().getDeviceId())
						.setHostname(ticket.get().getTicketContents().get(0).getDevice().getHostname())
						.setState(ticket.get().getTicketContents().get(0).getDevice().getState())
						.setOs(ticket.get().getTicketContents().get(0).getDevice().getOs()).build();

				TicketContentGrpc ticketResponseGrpc = TicketContentGrpc.newBuilder()
						.setId(ticket.get().getTicketContents().get(0).getId()).setCurrentAgent(currentAgentGrpc)
						.setCategory(categoryGrpc).setDevice(deviceGrpc)
						.setIssueOpened(ticket.get().getTicketContents().get(0).getIssueOpened())
						.setIssueClosed(ticket.get().getTicketContents().get(0).getIssueClosed())
						.setState(ticket.get().getTicketContents().get(0).getState())
						.setDescription(ticket.get().getTicketContents().get(0).getDescription()).build();

				GetTicketByIdResponse getTicketResponse = GetTicketByIdResponse.newBuilder()
						.setTicketContentGrpc(ticketResponseGrpc).build();
				responseObserver.onNext(getTicketResponse);
				responseObserver.onCompleted();
				// log.info("Retrieved Ticket id : {}", uuid);
			} else {
				throw new RecordNotFoundException("Record Not Found Exception for the Request");
			}
		} catch (Exception e) {
			throw new SVCRPSSupportTicketBuisnessException("603", "Something went Wrong " + e.getMessage());
		}
	}

	@Override
	@Timed(value = "addTicket", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version", "1.0" })
	public void addTicket(AddTicketRequest request, StreamObserver<AddTicketResponse> responseObserver) {

		try {
			// log.info("Creating a Support Ticket resource {}", request.getDeviceId());
			Ticket ticket = new Ticket();
			String ticketId = CommonUtil.uniqueString();
			ticket.setId(StringUtils.isNotBlank(ticketId) ? UUID.fromString(CommonUtil.uniqueString()) : null);
			ticket.setSupportTicketId(CommonUtil.generateIncrementalNumber());

			// validations
			TicketServiceValidator.validateAddRequest(request);
			TicketServiceValidator.validateTicketIds(ticket);

			MetaInfo metaInfo = new MetaInfo();
			metaInfo.setVersion("v1");
			metaInfo.setCreatedDate(CommonUtil.generateSystemDate());
			metaInfo.setUpdatedDate(null);
			metaInfo.setDeletedDate(null);
			ticket.setMetaInfo(metaInfo);

			// service to fetch Current Agent
			CurrentAgent currentAgent = currentAgentService.getCurrentAgent(request);

			// service to fetch Device Agent
			Device device = deviceService.getDevice(request);

			Category category = new Category();
			category.setDescription(request.getDescription());
			category.setName(request.getCategory());

			TicketContent ticketContent = new TicketContent();
			ticketContent.setId(ticketId); // generated ticket id
			ticketContent.setCurrentAgent(currentAgent);
			ticketContent.setCategory(category);
			ticketContent.setDevice(device);
			ticketContent.setIssueOpened(CommonUtil.generateSystemDate());
			ticketContent.setIssueClosed(null);
			ticketContent.setState("Active");
			ticketContent.setDescription("Ticket Support is being worked");

			// create metadata

			List<TicketContent> ticketResponseList = new ArrayList<>();
			ticketResponseList.add(ticketContent);
			ticket.setTicketContents(ticketResponseList);
			repository.save(ticket);
			AddTicketResponse addTicketReponse = AddTicketResponse.newBuilder().setResponseId(201).build();
			responseObserver.onNext(addTicketReponse);
			responseObserver.onCompleted();

		} catch (IllegalArgumentException e) {
			throw new SVCRPSSupportTicketBuisnessException("602", "Given Ticket is Null " + e.getMessage());
		} catch (Exception e) {
			throw new SVCRPSSupportTicketBuisnessException("603", "Something went Wrong " + e.getMessage());
		}
	}

	@Override
	@Timed
	public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {
		try {
			// validations
			if (!TicketServiceValidator.validateDeleteRequest(request)) {
				// Status status = Status.FAILED_PRECONDITION.withDescription("Delete Service
				// failed");
				// responseObserver.onError(status.asRuntimeException());
				// return;
				throw new ValidationException("validateFindAllRequest falied as Request couldn't be validated");
			}
			UUID uuid = StringUtils.isNotBlank(request.getId()) ? UUID.fromString(request.getId()) : null;
			// log.info("Deleting Ticket by Ticket id : {}", uuid);
			if (request.getId() != null) {
				repository.deleteById(uuid);
				DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder()
						.setResponse("Ticket deleted with id : " + uuid).build();
				responseObserver.onNext(deleteTicketResponse);
				responseObserver.onCompleted();
			} else {
				throw new RecordNotFoundException("Record Not Found Exception for the Request");
			}
			// log.info("Deleted Ticket id : {}", uuid);
		} catch (Exception e) {
			Status status = Status.fromThrowable(e);
			throw new SVCRPSSupportTicketBuisnessException("603", "Something went Wrong " + e.getMessage());
		}
	}

}
