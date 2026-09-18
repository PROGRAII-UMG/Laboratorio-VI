package org.realiquez.lab_VI.Ejercicio4a6.dto;

public record LibroRequestDTO(
    String titulo,
    String autor,
    String isbn,
    Integer anioPublicacion,
    String estado
) {}
