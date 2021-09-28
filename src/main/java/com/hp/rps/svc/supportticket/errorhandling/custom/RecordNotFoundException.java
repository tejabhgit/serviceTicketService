package com.hp.rps.svc.supportticket.errorhandling.custom;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String message) {
        super(message);
    }
}