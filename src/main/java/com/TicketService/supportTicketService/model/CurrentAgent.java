package com.TicketService.supportTicketService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentAgent {

	private String userId;
	private String firstName;
	private String lastName;
	private String gravatar;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGravatar() {
		return gravatar;
	}
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
	@Override
	public String toString() {
		return "CurrentAgent [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gravatar="
				+ gravatar + "]";
	}
	
	
	
}
