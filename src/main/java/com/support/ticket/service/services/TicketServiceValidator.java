package com.support.ticket.service.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.example.grpc.server.grpcserver.DeleteTicketRequest;
import com.example.grpc.server.grpcserver.FindAllTicketsRequest;
import com.example.grpc.server.grpcserver.GetTicketByIdRequest;
import org.apache.commons.lang3.StringUtils;

public class TicketServiceValidator {

    public static boolean validateAddRequest(AddTicketRequest request){
        return StringUtils.isNotBlank(request.getDeviceId());
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
