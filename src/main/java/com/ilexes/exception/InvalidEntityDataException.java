package com.ilexes.exception;
import java.util.List;

public class InvalidEntityDataException extends RuntimeException{
    private List<String> constraintViolations = List.of();

    public InvalidEntityDataException() {
    }

    public InvalidEntityDataException(String message) {
        super(message);
    }

    public InvalidEntityDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityDataException(Throwable cause) {
        super(cause);
    }

    public InvalidEntityDataException(List<String> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    public InvalidEntityDataException(List<String> constraintViolations, String message) {
        super(message);
        this.constraintViolations = constraintViolations;
    }

    public List<String> getConstraintViolations() {
        return constraintViolations;
    }
}
