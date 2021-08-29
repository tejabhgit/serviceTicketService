package com.TicketService.supportTicketService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Content {
    
	int id;
	CurrentAgent currentAgent;
	Category category;
	Device device;
	private int issueOpened	;
	private int issueClosed;
	private String state;
	private String description;
	public CurrentAgent getCurrentAgent() {
		return currentAgent;
	}
	public void setCurrentAgent(CurrentAgent currentAgent) {
		this.currentAgent = currentAgent;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIssueOpened() {
		return issueOpened;
	}
	public void setIssueOpened(int issueOpened) {
		this.issueOpened = issueOpened;
	}
	public int getIssueClosed() {
		return issueClosed;
	}
	public void setIssueClosed(int issueClosed) {
		this.issueClosed = issueClosed;
	}
	
	
	
	
	
	
}
