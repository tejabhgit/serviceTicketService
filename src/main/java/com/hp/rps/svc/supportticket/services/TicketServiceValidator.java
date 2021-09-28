package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import com.hp.rps.svc.supportticket.model.Ticket;
import org.apache.commons.lang3.StringUtils;

public class TicketServiceValidator {

    public static void validateAddRequest(AddTicketRequest request){
        if (!StringUtils.isNotBlank(request.getDeviceId())){
            return;
        }
    }

    public static void validateTicketIds(Ticket ticket){
        if (!StringUtils.isNotBlank(ticket.getId().toString()) || StringUtils.isNotBlank(ticket.getSupportTicketId())){
            return;
        }
    }

    public static boolean validateGetRequest(GetTicketByIdRequest request){
        return StringUtils.isNotBlank(request.getId());
    }

    public static boolean validateFindAllRequest(FindAllTicketsRequest request){
        return StringUtils.isNotBlank(request.getSortBy());
    }

    public static boolean validateDeleteRequest(DeleteTicketRequest request){
        return StringUtils.isNotBlank(request.getId());
    }
}
