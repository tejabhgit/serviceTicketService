package com.hp.rps.svc.supportticket.controllers;

import com.example.grpc.server.grpcserver.CreateOneSessionRequest;
import com.example.grpc.server.grpcserver.CreateOneSessionResponse;
import com.example.grpc.server.grpcserver.SessionServiceGrpc;
import com.hp.rps.svc.supportticket.services.SessionService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class SessionApiController extends SessionServiceGrpc.SessionServiceImplBase {
    private final SessionService sessionService;

    //@Override
    public void addSession(CreateOneSessionRequest request, StreamObserver<CreateOneSessionResponse> responseObserver) {
        try {
            log.info("Creating Session");
            sessionService.addSession(request);
            CreateOneSessionResponse createOneSessionResponse = CreateOneSessionResponse.newBuilder().setResponse("201").build();
            responseObserver.onNext(createOneSessionResponse);
            responseObserver.onCompleted();
            //static Mapper<String, String> mapper = (x) -> x.get();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription(e.getMessage())
                    .withCause(e)
                    .asRuntimeException());
            log.error(e.getMessage());
        }
    }
}