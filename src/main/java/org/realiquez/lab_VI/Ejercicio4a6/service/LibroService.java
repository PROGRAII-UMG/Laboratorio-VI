package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;

public interface LibroService {
    Libro crearLibro(Libro libro);
    List<Libro> obtenerLibros(String titulo);
    Libro actualizarLibro(Long id, Libro libro);
    void eliminarLibro(Long id);
}
