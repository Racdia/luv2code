package com.example.luv2code.ultime.Exception;


import java.time.LocalDateTime;
import java.util.Date;



public class ErrorResponse {

    private String timestanp;
    private Integer status;
    private String message;
    private String path;

    public ErrorResponse() {
    }

    public ErrorResponse(String timestanp, Integer status, String message, String path) {
        this.timestanp = timestanp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ErrorResponse(String message) {
        this.message=message;
    }

    public String getTimestanp() {
        return timestanp;
    }

    public void setTimestanp(String timestanp) {
        this.timestanp = timestanp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
