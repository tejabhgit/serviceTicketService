package com.TicketService.supportTicketService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TicketService.supportTicketService.vo.Category;
import com.TicketService.supportTicketService.vo.CurrentAgent;
import com.TicketService.supportTicketService.vo.SupportTicket;



@RestController
public class TicketServiceController {

	@GetMapping("/greeting")
	public SupportTicket greeting() throws IOException, InterruptedException {
		
		SupportTicket supportTicket = createSupportTicket();
		
		return supportTicket;
	}
	
	
	public static SupportTicket createSupportTicket() {
		SupportTicket supportTicket = new SupportTicket(); 
		CurrentAgent currentAgent = new CurrentAgent();
		Category category =new Category();
		currentAgent.setUserId("6981bcc5-5787-4bee-baa5-ada6ce6c800c");
		currentAgent.setFirstName("Jeroen");
		currentAgent.setLastName("Nouws");
		currentAgent.setGravatar("https://gravatar.link/jeroen.nouws");
		
		category.setName("SOFTWARE");
		category.setDescription("Everything software related");
		
		supportTicket.setId("6981bcc5-5787-4bee-baa5-ada6ce6c800c");
		supportTicket.setCurrent_agent(currentAgent);
		supportTicket.setCategory(category);
		supportTicket.setDeviceId("6981bcc5-5787-4bee-baa5-ada6ce6c800c");
		supportTicket.setIssue_opened("1628250944");
		supportTicket.setIssue_closed(null);
		supportTicket.setState("NEED_MORE_INFO");
		supportTicket.setDescription("bacon ipsum...");
		
		
		return  supportTicket;
		
	}

}
