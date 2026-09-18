package org.realiquez.lab_VI.Ejercicio4a6.mapper;

import org.realiquez.lab_VI.Ejercicio4a6.dto.ReservaRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.ReservaResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaRequestDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setNombreCliente(dto.nombreCliente());
        reserva.setHabitacion(dto.habitacion());
        reserva.setFechaEntrada(dto.fechaEntrada());
        reserva.setFechaSalida(dto.fechaSalida());
        reserva.setEstado(dto.estado());
        return reserva;
    }

    public ReservaResponseDTO toResponseDTO(Reserva reserva) {
        return new ReservaResponseDTO(
            reserva.getId(),
            reserva.getNombreCliente(),
            reserva.getHabitacion(),
            reserva.getFechaEntrada(),
            reserva.getFechaSalida(),
            reserva.getEstado()
        );
    }
}
