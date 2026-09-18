package org.realiquez.lab_VI.Ejercicio4a6.dto;

public record ErrorResponseDTO(
    int status,
    String error,
    String message
) {}
