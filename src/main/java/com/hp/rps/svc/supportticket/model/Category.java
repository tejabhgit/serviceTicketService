package com.hp.rps.svc.supportticket.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
public class Category {

	@Field("NAME")
	@NotNull(message = "Please provide a NAME")
	@NotBlank(message = "Please provide a NAME")
	private String name;

	@Field("DESCRIPTION")
	@NotNull(message = "Please provide a DESCRIPTION")
	@NotBlank(message = "Please provide a DESCRIPTION")
	private String description;


}
