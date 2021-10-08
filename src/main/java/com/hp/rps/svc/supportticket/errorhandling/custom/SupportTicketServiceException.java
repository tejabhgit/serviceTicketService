package com.hp.rps.svc.supportticket.errorhandling.custom;

public class SupportTicketServiceException extends Exception {
	public SupportTicketServiceException() {
	}

	public SupportTicketServiceException(String message) {
		super(message);
	}

	public SupportTicketServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SupportTicketServiceException(Throwable cause) {
		super(cause);
	}

	public SupportTicketServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

