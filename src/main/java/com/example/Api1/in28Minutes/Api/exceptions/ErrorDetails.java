package com.example.Api1.in28Minutes.Api.exceptions;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate timeStamp;
    private String message;
    private String details;

    //Constructor
    public ErrorDetails(LocalDate date, String message, String details) {
        this.timeStamp = date;
        this.message = message;
        this.details = details;
    }

    //Getters and Setters
    public LocalDate getDate() {
        return timeStamp;
    }

    public void setDate(LocalDate date) {
        this.timeStamp = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    //ToString
    @Override
    public String toString() {
        return "ErrorDetails{" +
                "date=" + timeStamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
