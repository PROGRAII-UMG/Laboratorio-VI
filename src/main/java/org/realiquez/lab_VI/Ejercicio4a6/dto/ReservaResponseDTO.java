package org.realiquez.lab_VI.Ejercicio4a6.dto;

import java.time.LocalDate;

public record ReservaResponseDTO(
    Long id,
    String nombreCliente,
    String habitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer estado
) {}
