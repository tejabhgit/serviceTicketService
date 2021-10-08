package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.hp.rps.svc.supportticket.model.Ticket;
import org.apache.commons.lang3.StringUtils;

public class TicketServiceValidator {

    public static boolean validateAddRequest(AddTicketRequest request){
        return StringUtils.isBlank(request.getDeviceId());
    }

    public static boolean validateTicketIds(Ticket ticket){
        return StringUtils.isBlank(ticket.getId().toString()) && StringUtils.isBlank(ticket.getSupportTicketId());
    }

    public static boolean validateGetRequest(GetTicketByIdRequest request){
        return (StringUtils.isNotBlank(request.getId()) || StringUtils.isNotBlank(request.getSupportTicketId()));
    }

    public static boolean validateFindAllRequest(FindAllTicketsRequest request){
        return StringUtils.isNotBlank(request.getSortBy());
    }

    public static boolean validateDeleteRequest(DeleteTicketRequest request){
        return StringUtils.isNotBlank(request.getId());
    }
}
