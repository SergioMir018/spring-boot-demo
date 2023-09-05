package com.example.demo.api;

public class BlankFieldException extends RuntimeException {
    public BlankFieldException(String fieldName) {
        super("The field '" + fieldName + "' cannot be blank");
    }
}

