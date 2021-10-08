package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CurrentAgent {

	private UUID userId;
	private String firstName;
	private String lastName;
	private String gravatar;

}
