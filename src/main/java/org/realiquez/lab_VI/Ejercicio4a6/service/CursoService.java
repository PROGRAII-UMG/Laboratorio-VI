package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;

public interface CursoService {
    Curso crearCurso(Curso curso);
    List<Curso> obtenerCursos(String codigo);
    Curso actualizarCurso(Long id, Curso curso);
    void eliminarCurso(Long id);
}
