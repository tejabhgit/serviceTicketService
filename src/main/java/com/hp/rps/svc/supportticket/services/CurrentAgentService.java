package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.hp.rps.svc.supportticket.model.CurrentAgent;
import com.hp.rps.svc.supportticket.util.CommonUtil;
import org.springframework.stereotype.Service;

@Service
public class CurrentAgentService {

    public CurrentAgent getCurrentAgent(AddTicketRequest request) {

        //service call to agent, needs happen to fetch the current agent info: TODO
        CurrentAgent currentAgent = CurrentAgent.builder()
                .userId(CommonUtil.nullCheckUuid("d4db0a66-c1f9-4005-99d4-83d79a17fe9f"))
                .gravatar("https://gravatar/links_HARDCODED")
                .firstName("John_HARDCODED")
                .lastName("Smith_HARDCODED")
                .build();
        return currentAgent;
    }

}
