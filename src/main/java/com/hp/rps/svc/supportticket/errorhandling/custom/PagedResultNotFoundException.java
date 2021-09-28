package com.hp.rps.svc.supportticket.errorhandling.custom;


public class PagedResultNotFoundException extends  RuntimeException{

	    public PagedResultNotFoundException(String message) {
	        super(message);
	    }
	}

