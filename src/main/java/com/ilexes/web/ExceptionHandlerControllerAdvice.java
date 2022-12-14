package com.ilexes.web;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.InvalidEntityDataException;
import com.ilexes.exception.NonExistingEntityException;
import com.ilexes.model.dto.expose.exception.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleNonExistingEntityException(NonExistingEntityException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponseDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleInvalidEntityDataException(InvalidEntityDataException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), ExceptionMessages.INVALID_DATA_PROVIDED, exception.getConstraintViolations()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> fieldErrorMessages = exception.getFieldErrors()
                .stream()
                .map(e -> String.format(ExceptionMessages.FIELD_ERROR_MESSAGE, e.getDefaultMessage(), e.getField(), e.getRejectedValue()))
                .toList();
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), ExceptionMessages.INVALID_DATA_PROVIDED, fieldErrorMessages));
    }
}
