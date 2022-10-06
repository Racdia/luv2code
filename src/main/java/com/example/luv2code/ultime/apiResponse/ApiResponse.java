package com.example.luv2code.ultime.apiResponse;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private T data;
    private Integer status;
    private String message;
    private LocalDateTime localDate;

    public ApiResponse(T data, Integer status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.localDate = LocalDateTime.now();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }
}
