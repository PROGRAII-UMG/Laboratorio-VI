package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;

public interface ReservaRepository {
    Reserva save(Reserva reserva);
    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva update(Long id, Reserva reserva);
}
