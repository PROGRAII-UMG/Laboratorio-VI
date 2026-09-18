package org.realiquez.lab_VI.Ejercicio4a6.dto;

public record CursoRequestDTO(
    String nombre,
    String codigo,
    Integer creditos,
    Boolean estado
) {}
