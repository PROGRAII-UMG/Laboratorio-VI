package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> obtenerReservas();
    Reserva obtenerReservaPorId(Long id);
    Reserva actualizarReserva(Long id, Reserva reserva);
    Reserva cancelarReserva(Long id);
}
