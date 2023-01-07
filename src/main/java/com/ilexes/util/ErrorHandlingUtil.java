package com.ilexes.util;

import com.ilexes.exception.ExceptionMessages;
import com.ilexes.exception.InvalidEntityDataException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHandlingUtil {
    public static void handleValidationErrors(Errors errors) {
        if(errors.hasErrors()) {
            List<String> fieldErrorMessages = errors.getFieldErrors()
                    .stream()
                    .map(e -> String.format(ExceptionMessages.FIELD_ERROR_MESSAGE, e.getDefaultMessage(), e.getField(), e.getRejectedValue()))
                    .toList();
            List<String> globalErrorMessages = errors.getGlobalErrors()
                    .stream()
                    .map(e -> String.format(ExceptionMessages.GLOBAL_ERROR_MESSAGE, e.getDefaultMessage()))
                    .toList();
            List<String> allErrorMessages = new ArrayList<>(fieldErrorMessages);
            allErrorMessages.addAll(globalErrorMessages);

            throw new InvalidEntityDataException(allErrorMessages, ExceptionMessages.INVALID_DATA_PROVIDED);
        }
    }
}
