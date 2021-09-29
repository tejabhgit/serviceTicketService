package com.hp.rps.svc.supportticket.errorhandling.custom;

import com.example.grpc.error.EchoRequest;
import com.example.grpc.error.EchoResponse;
import com.example.grpc.error.ErrorServiceGrpc;
import com.hp.rps.svc.supportticket.errorhandling.CustomException;
import com.hp.rps.svc.supportticket.errorhandling.ErrorServiceImpl;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {




    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PagedResultNotFoundException.class)
    public ResponseEntity<ErrorResponse> pagedResultNotFoundException(PagedResultNotFoundException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validationException(ValidationException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),System.currentTimeMillis());

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