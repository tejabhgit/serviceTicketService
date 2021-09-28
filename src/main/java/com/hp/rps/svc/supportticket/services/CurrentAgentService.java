package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.hp.rps.svc.supportticket.model.CurrentAgent;
import org.springframework.stereotype.Service;

@Service
public class CurrentAgentService {

    public CurrentAgent getCurrentAgent(AddTicketRequest request){

        //service call to agent, needs happen to fetch the current agent info: TODO
        CurrentAgent currentAgent = new  CurrentAgent();
        currentAgent.setUserId("e90368332");
        currentAgent.setGravatar("https://gravatar/links");
        currentAgent.setFirstName("John");
        currentAgent.setLastName("Smith");
        return currentAgent;
    }



}
