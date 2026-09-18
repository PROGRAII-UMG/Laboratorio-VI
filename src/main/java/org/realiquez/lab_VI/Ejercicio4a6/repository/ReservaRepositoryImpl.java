package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();
    private Long siguienteId = 1L;

    @Override
    public Reserva save(Reserva reserva) {
        reserva.setId(siguienteId++);
        reservas.add(reserva);
        return reserva;
    }

    @Override
    public List<Reserva> findAll() {
        return reservas;
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservas.stream()
            .filter(r -> r.getId().equals(id))
            .findFirst();
    }

    @Override
    public Reserva update(Long id, Reserva reservaActualizada) {
        Optional<Reserva> existe = findById(id);
        if (existe.isEmpty()) {
            return null;
        }

        Reserva reserva = existe.get();
        reserva.setNombreCliente(reservaActualizada.getNombreCliente());
        reserva.setHabitacion(reservaActualizada.getHabitacion());
        reserva.setFechaEntrada(reservaActualizada.getFechaEntrada());
        reserva.setFechaSalida(reservaActualizada.getFechaSalida());
        reserva.setEstado(reservaActualizada.getEstado());
        return reserva;
    }
}
