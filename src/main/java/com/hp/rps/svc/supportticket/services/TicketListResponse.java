package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.PageableGrpc;
import com.example.grpc.server.grpcserver.TicketContentGrpc;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class TicketListResponse {

    private PageableGrpc pageableGrpc;
    private List<TicketContentGrpc.Builder> TicketContentList;
}
