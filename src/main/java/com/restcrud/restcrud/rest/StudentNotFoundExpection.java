package com.restcrud.restcrud.rest;

public class StudentNotFoundExpection extends RuntimeException{
    public StudentNotFoundExpection(String message) {
        super(message);
    }

    public StudentNotFoundExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExpection(Throwable cause) {
        super(cause);
    }
}
