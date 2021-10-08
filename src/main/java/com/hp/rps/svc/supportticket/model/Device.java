package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class Device {

	private UUID deviceId;
	private String hostname;
	private String state;
	private String os;
}
