package com.TicketService.supportTicketService.vo;

public class SupportTicket {

	private String id;
	private CurrentAgent current_agent;
	private Category category;
	private String deviceId;
	private String issue_opened;
	private String issue_closed;
	private String state;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CurrentAgent getCurrent_agent() {
		return current_agent;
	}
	public void setCurrent_agent(CurrentAgent current_agent) {
		this.current_agent = current_agent;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getIssue_opened() {
		return issue_opened;
	}
	public void setIssue_opened(String issue_opened) {
		this.issue_opened = issue_opened;
	}
	public String getIssue_closed() {
		return issue_closed;
	}
	public void setIssue_closed(String issue_closed) {
		this.issue_closed = issue_closed;
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
	@Override
	public String toString() {
		return "SupportTicket [id=" + id + ", current_agent=" + current_agent + ", category=" + category + ", deviceId="
				+ deviceId + ", issue_opened=" + issue_opened + ", issue_closed=" + issue_closed + ", state=" + state
				+ ", description=" + description + "]";
	}
	
	
	
}
