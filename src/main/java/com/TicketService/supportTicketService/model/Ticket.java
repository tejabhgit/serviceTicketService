package com.TicketService.supportTicketService.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Ticket")
public class Ticket {

	@Id
	private int id;
	private boolean last;
	private int totalElements;
	private int totalPages;
	private int numberOfElements;
	private boolean first;
	private int number;
	private boolean empty;	
	private List<Content> content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", last=" + last + ", totalElements=" + totalElements + ", totalPages=" + totalPages
				+ ", numberOfElements=" + numberOfElements + ", first=" + first + ", number=" + number + ", empty="
				+ empty + ", content=" + content + "]";
	}
	
	

	
	
}
