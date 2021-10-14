package com.hp.rps.svc.supportticket.errorhandling.custom;


public class ValidationFailedException extends  RuntimeException{

	    public ValidationFailedException(String message) {
	        super(message);
	    }
	}

