package org.realiquez.lab_VI.Ejercicio4a6.controller;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.dto.ReservaRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.ReservaResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Reserva;
import org.realiquez.lab_VI.Ejercicio4a6.mapper.ReservaMapper;
import org.realiquez.lab_VI.Ejercicio4a6.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final ReservaMapper reservaMapper;

    public ReservaController(ReservaService reservaService, ReservaMapper reservaMapper) {
        this.reservaService = reservaService;
        this.reservaMapper = reservaMapper;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@RequestBody ReservaRequestDTO requestDTO) {
        Reserva reserva = reservaMapper.toEntity(requestDTO);
        reserva = reservaService.crearReserva(reserva);
        ReservaResponseDTO responseDTO = reservaMapper.toResponseDTO(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservas() {
        List<Reserva> reservas = reservaService.obtenerReservas();
        List<ReservaResponseDTO> responseDTOs = reservas.stream()
            .map(reservaMapper::toResponseDTO)
            .toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        ReservaResponseDTO responseDTO = reservaMapper.toResponseDTO(reserva);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizarReserva(
        @PathVariable Long id,
        @RequestBody ReservaRequestDTO requestDTO
    ) {
        Reserva reserva = reservaMapper.toEntity(requestDTO);
        reserva = reservaService.actualizarReserva(id, reserva);
        ReservaResponseDTO responseDTO = reservaMapper.toResponseDTO(reserva);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<ReservaResponseDTO> cancelarReserva(@PathVariable Long id) {
        Reserva reserva = reservaService.cancelarReserva(id);
        ReservaResponseDTO responseDTO = reservaMapper.toResponseDTO(reserva);
        return ResponseEntity.ok(responseDTO);
    }
}
