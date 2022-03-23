package com.example.marsamaroc.exception;

public class GrueNotFoundException extends RuntimeException{
    public GrueNotFoundException(Long id) {
        super("Grue not find employee " + id);

    }
}
