package com.ilexes.exception;

public class NonExistingEntityException extends RuntimeException{


    public NonExistingEntityException() {
    }

    public NonExistingEntityException(String message) {
        super(message);
    }

    public NonExistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistingEntityException(Throwable cause) {
        super(cause);
    }

}
