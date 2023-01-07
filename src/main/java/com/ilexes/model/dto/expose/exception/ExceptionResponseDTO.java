package com.ilexes.model.dto.expose.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    @NonNull
    private Integer status;
    @NonNull
    private String message;
    private List<String> violations = List.of();
}
