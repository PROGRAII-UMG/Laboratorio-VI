package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;
import org.realiquez.lab_VI.Ejercicio4a6.exception.CodigoDuplicadoException;
import org.realiquez.lab_VI.Ejercicio4a6.exception.CursoNoEncontradoException;
import org.realiquez.lab_VI.Ejercicio4a6.exception.DatosInvalidosException;
import org.realiquez.lab_VI.Ejercicio4a6.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso crearCurso(Curso curso){
        validarDatos(curso);
        if(cursoRepository.findByCodigo(curso.getCodigo()).isPresent()){
            throw new CodigoDuplicadoException(
                "Ya existe un curso con el codigo " + curso.getCodigo()
            );
        }

        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> obtenerCursos(String codigo){
        if(codigo != null && !codigo.isBlank()){
            return cursoRepository.findByCodigo(codigo)
                .map(List::of)
                .orElseThrow(
                    () -> new CursoNoEncontradoException("No existe un curso con el codigo " + codigo)
                );
        }
        return cursoRepository.findAll();
    }

    @Override
    public Curso actualizarCurso(Long id, Curso cursoNuevo){
        validarDatos(cursoNuevo);
        Curso actualizado = cursoRepository.update(id, cursoNuevo);
        if(actualizado == null){
            throw new CursoNoEncontradoException("No existe un curso con el id "+ id);
        }
        return actualizado;
    }

    @Override
    public void eliminarCurso(Long id){
        boolean eliminado = cursoRepository.deleteById(id);
        if(!eliminado){
            throw new CursoNoEncontradoException("No existe un curso con el id " + id);
        }
    }

    private void validarDatos(Curso curso){
        if(
            curso.getNombre() == null || curso.getNombre().isBlank() ||
            curso.getCodigo() == null || curso.getCodigo().isBlank()
        ){
            throw new DatosInvalidosException("Nombre y codigo son obligatorios.");
        }

        if(
            curso.getCreditos() != null && curso.getCreditos() < 0
        ){
            throw new DatosInvalidosException("Los creditos no pueden ser negativos.");
        }
    }
}
