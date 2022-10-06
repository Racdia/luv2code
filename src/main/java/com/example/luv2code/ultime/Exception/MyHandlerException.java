package com.example.luv2code.ultime.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@ControllerAdvice
public class MyHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerExcep.class)
    public ResponseEntity<ErrorResponse> MyException(InternalServerExcep myExceptionHandler, HttpServletRequest httpServletRequest){
        return ResponseEntity.internalServerError().body(new ErrorResponse(LocalDateTime.now().toString(),500,myExceptionHandler.getMessage(),httpServletRequest.getRequestURI()));
    }
}
