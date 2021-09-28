package com.hp.rps.svc.supportticket.errorhandling.custom;

public class SVCRPSSupportTicketBusinessException extends Exception {
	public SVCRPSSupportTicketBusinessException() {
	}

	public SVCRPSSupportTicketBusinessException(String message) {
		super(message);
	}

	public SVCRPSSupportTicketBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public SVCRPSSupportTicketBusinessException(Throwable cause) {
		super(cause);
	}

	public SVCRPSSupportTicketBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

