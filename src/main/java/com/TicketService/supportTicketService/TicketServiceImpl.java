package com.TicketService.supportTicketService;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.example.grpc.server.grpcserver.*;

@GrpcService
public class TicketServiceImpl extends TicketServiceGrpc.TicketServiceImplBase {

	@Override
	public void getTicketService(TicketRequest request, StreamObserver<TicketResponse> responseObserver) {

		//currentAgent
		
		CurrentAgent currentAgent = CurrentAgent.newBuilder().
				setUserId("6981bcc5-5787-4bee-baa5-ada6ce6c800c").setFirstName("Jeroen").
				setLastName("Nouws").setGravatar("https://gravatar.link/jeroen.nouws").build();
		
		Category category = Category.newBuilder().setName("SOFTWARE").
				setDescription("example category description").build();
		
		Device device = Device.newBuilder().
				setDeviceId("6981bcc5-5787-4bee-baa5-ada6ce6c800c").
				setHostname("Pipm3ister's rig").
				setState("AWAITING_SUPPORT").setOs("win10").build();
		
		Content content = Content.newBuilder().setId("6981bcc5-5787-4bee-baa5-aajbshg").
				setCurrentAgent(currentAgent).setCategory(category).setDevice(device).setIssueOpened("1628250944000").
				setIssueClosed("1628250944000").setState("NEED_MORE_INFO").
				setDescription("foo bar description").build();
		
		
		
		TicketResponse ticketResponse = TicketResponse.newBuilder().setLast("last").setTotalElements("123").setTotalPages("13").
				setNumberOfElements("10").setFirst("false").setNumber("2").setEmpty("false").setContent(content).build();
		responseObserver.onNext(ticketResponse);
        responseObserver.onCompleted();
		
	}
}
