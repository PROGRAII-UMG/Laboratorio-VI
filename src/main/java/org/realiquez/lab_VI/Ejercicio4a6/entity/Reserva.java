package org.realiquez.lab_VI.Ejercicio4a6.entity;

import java.time.LocalDate;

public class Reserva {
    private Long id;
    private String nombreCliente;
    private String habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Integer estado;

    public Reserva() {}

    public Reserva(String nombreCliente, String habitacion, LocalDate fechaEntrada, LocalDate fechaSalida, Integer estado) {
        this.nombreCliente = nombreCliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCliente() { return this.nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getHabitacion() { return this.habitacion; }
    public void setHabitacion(String habitacion) { this.habitacion = habitacion; }

    public LocalDate getFechaEntrada() { return this.fechaEntrada; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public LocalDate getFechaSalida() { return this.fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public Integer getEstado() { return this.estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}
