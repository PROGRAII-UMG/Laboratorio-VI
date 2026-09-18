package org.realiquez.lab_VI.Ejercicio4a6.dto;

import java.time.LocalDate;

public record ReservaRequestDTO(
    String nombreCliente,
    String habitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer estado
) {}
