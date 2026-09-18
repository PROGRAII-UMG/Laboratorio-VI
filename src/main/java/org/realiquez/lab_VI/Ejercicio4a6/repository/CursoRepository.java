package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;

public interface CursoRepository {
    Curso save(Curso curso);
    List<Curso> findAll();
    Optional<Curso> findByCodigo(String codigo);
    Optional<Curso> findById(Long id);
    Curso update(Long id, Curso curso);
    boolean deleteById(Long id);
}
