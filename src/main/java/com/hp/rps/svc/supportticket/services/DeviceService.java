package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.AddTicketRequest;
import com.hp.rps.svc.supportticket.model.Device;
import com.hp.rps.svc.supportticket.util.CommonUtil;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public Device getDevice(AddTicketRequest request) {

        //service call to device, needs happen to fetch the device info: TODO

        Device device = Device.builder()
                .deviceId(CommonUtil.nullCheckUuid(request.getDeviceId()))
                .hostname("HOST_HARDCODED")
                .os("Linux-64x_HARDCODED")
                .state("Active_HARDCODED").build();
        return device;
    }
}
