package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;
import org.realiquez.lab_VI.Ejercicio4a6.exception.CursoNoEncontradoException;
import org.realiquez.lab_VI.Ejercicio4a6.exception.DatosInvalidosException;
import org.realiquez.lab_VI.Ejercicio4a6.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        validarDatos(reserva);
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id)
            .orElseThrow(() -> new CursoNoEncontradoException("No existe una reserva con el id " + id));
    }

    @Override
    public Reserva actualizarReserva(Long id, Reserva reservaNuevo) {
        validarDatos(reservaNuevo);
        Reserva reservaActualizada = reservaRepository.update(id, reservaNuevo);
        if (reservaActualizada == null) {
            throw new CursoNoEncontradoException("No existe una reserva con el id " + id);
        }
        return reservaActualizada;
    }

    @Override
    public Reserva cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new CursoNoEncontradoException("No existe una reserva con el id " + id));

        if (reserva.getEstado() == 0) {
            throw new DatosInvalidosException("La reserva ya estaba cancelada.");
        }

        reserva.setEstado(0);
        return reservaRepository.update(id, reserva);
    }

    private void validarDatos(Reserva reserva) {
        if (
            reserva.getNombreCliente() == null || reserva.getNombreCliente().isBlank() ||
            reserva.getHabitacion() == null || reserva.getHabitacion().isBlank() ||
            reserva.getFechaEntrada() == null || reserva.getFechaSalida() == null
        ) {
            throw new DatosInvalidosException("Nombre, habitacion y fechas son obligatorios.");
        }

        if (reserva.getFechaSalida().isBefore(reserva.getFechaEntrada())) {
            throw new DatosInvalidosException("La fecha de salida no puede ser anterior a la de entrada.");
        }
    }
}
