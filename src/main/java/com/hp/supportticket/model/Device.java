package com.hp.supportticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Device")
public class Device {

	private String deviceId;
	private String hostname;
	private String state;
	private String os;
}
