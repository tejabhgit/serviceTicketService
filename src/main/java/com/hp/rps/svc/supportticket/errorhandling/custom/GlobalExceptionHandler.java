package com.hp.rps.svc.supportticket.errorhandling.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validationException(ValidationException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){

        ErrorResponse error = new ErrorResponse(exp.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }
}