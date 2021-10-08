package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Category {

	private String name;
	private String description;
}
