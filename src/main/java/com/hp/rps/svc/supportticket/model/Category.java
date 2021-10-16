package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Getter
public class Category {

	@Field("NAME")
	private String name;

	@Field("DESCRIPTION")
	private String description;
}
