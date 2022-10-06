package com.example.luv2code.ultime.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> MyException(NotFoundException exception, HttpServletRequest httpServletRequest){

     //  ErrorResponse errorResponse=new ErrorResponse();

      // errorResponse.setMessage(exception.getMessage());
     //  errorResponse.setPath(httpServletRequest.getRequestURI());
      // errorResponse.setTimestanp(LocalDateTime.now().toString());
     //  errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(LocalDateTime.now().toString(),404,exception.getMessage(),httpServletRequest.getRequestURI()));


        // return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
     }




}
