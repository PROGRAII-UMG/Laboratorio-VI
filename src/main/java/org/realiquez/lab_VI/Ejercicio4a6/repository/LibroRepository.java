package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;

public interface LibroRepository {
    Libro save(Libro libro);
    List<Libro> findAll();
    Optional<Libro> findByTitulo(String titulo);
    Optional<Libro> findByIsbn(String isbn);
    Optional<Libro> findById(Long id);
    Libro update(Long id, Libro libro);
    boolean deleteById(Long id);
}
