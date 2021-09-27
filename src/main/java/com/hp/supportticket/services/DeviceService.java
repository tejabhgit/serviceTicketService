package com.hp.supportticket.services;

import com.hp.supportticket.model.Device;
import com.example.grpc.server.grpcserver.AddTicketRequest;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public Device getDevice(AddTicketRequest request){

        //service call to device, needs happen to fetch the device info: TODO
        Device device = new Device();
        device.setDeviceId(request.getDeviceId());
        device.setHostname("Host-name-rps-id");
        device.setOs("Linux-64x");
        device.setState("Active");
        return device;
    }



}
