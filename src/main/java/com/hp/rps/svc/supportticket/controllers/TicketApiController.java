package com.hp.rps.svc.supportticket.controllers;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.AddTicketResponse;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketResponse;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsResponse;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdResponse;
import com.example.grpc.server.grpcserver.TicketContentGrpc;
import com.example.grpc.server.grpcserver.TicketServiceGrpc;
import com.example.grpc.server.grpcserver.UpdateOneTicketByIDRequest;
import com.example.grpc.server.grpcserver.UpdateOneTicketByIDResponse;
import com.hp.rps.svc.supportticket.errorhandling.custom.RecordNotFoundException;
import com.hp.rps.svc.supportticket.errorhandling.custom.ValidationFailedException;
import com.hp.rps.svc.supportticket.services.TicketListResponse;
import com.hp.rps.svc.supportticket.services.TicketService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class TicketApiController extends TicketServiceGrpc.TicketServiceImplBase {

    private static final String INSTRUMENTATION_LIBRARY = "io.opentelemetry.example.JaegerExample";

    private final TicketService ticketService;

    //private final Mapper mapper;

    @Override
    public void addTicket(AddTicketRequest request, StreamObserver<AddTicketResponse> responseObserver) {
        try {
            log.info("In addTicket");
            ticketService.addTicket(request);
            AddTicketResponse addTicketResponse = AddTicketResponse.newBuilder().setResponseId(201).build();
            responseObserver.onNext(addTicketResponse);
            responseObserver.onCompleted();
            //static Mapper<String, String> mapper = (x) -> x.get();
        } catch (IllegalArgumentException | ValidationFailedException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateOneTicketByID(UpdateOneTicketByIDRequest request, StreamObserver<UpdateOneTicketByIDResponse> responseObserver) {
        try {
            ticketService.updateTicket(request);
            UpdateOneTicketByIDResponse updateOneTicketByIDResponse = UpdateOneTicketByIDResponse.newBuilder().setResponseId(201).build();
            responseObserver.onNext(updateOneTicketByIDResponse);
            responseObserver.onCompleted();
        } catch (IllegalArgumentException | ValidationFailedException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }

    @Override
    public void getTicketById(GetTicketByIdRequest request, StreamObserver<GetTicketByIdResponse> responseObserver) {
        try {
            TicketContentGrpc.Builder ticketContentGrpc = ticketService.getTicketById(request);
            GetTicketByIdResponse getTicketResponse = GetTicketByIdResponse.newBuilder()
                    .setTicket(ticketContentGrpc)
                    .build();
            responseObserver.onNext(getTicketResponse);
            responseObserver.onCompleted();
            log.info("Retrieved Ticket with id :{} ", request.getId());
        } catch (ValidationFailedException | IllegalArgumentException | RecordNotFoundException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }

    @Override
    public void findAllTickets(FindAllTicketsRequest request, StreamObserver<FindAllTicketsResponse> responseObserver) {
        try {
            TicketListResponse ticketListResponse = ticketService.getPagedTicketResponse(request);

            FindAllTicketsResponse findAllTicketsResponse = FindAllTicketsResponse.newBuilder().setPageableGrpc(ticketListResponse.getPageableGrpc()).build();
            responseObserver.onNext(findAllTicketsResponse);
            ticketListResponse.getTicketContentList().stream().filter(listTicketRes -> listTicketRes.getDeviceId() != null)
                    .forEach(listTicketRes -> {
                        responseObserver.onNext(FindAllTicketsResponse
                                .newBuilder().setTicket(listTicketRes).build());
                    });
            responseObserver.onCompleted();
            log.info("Found all tickets of size: {}", ticketListResponse.getTicketContentList().size());
        } catch (ValidationFailedException | RecordNotFoundException | IllegalArgumentException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteTicket(DeleteTicketRequest request, StreamObserver<DeleteTicketResponse> responseObserver) {
        try {
            ticketService.deleteTicket(request);
            DeleteTicketResponse deleteTicketResponse = DeleteTicketResponse.newBuilder().setResponse("Ticket deleted with id : " + request.getId())
                    .build();
            log.info("Deleted Ticket id : {}", request.getId());
            responseObserver.onNext(deleteTicketResponse);
            responseObserver.onCompleted();
        } catch (ValidationFailedException | IllegalArgumentException e) {
            responseObserver.onError(Status.FAILED_PRECONDITION
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());

            log.error(e.getMessage());
        }
    }
}