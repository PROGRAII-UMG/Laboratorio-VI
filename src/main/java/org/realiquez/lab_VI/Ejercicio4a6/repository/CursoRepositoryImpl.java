package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;
import org.springframework.stereotype.Repository;

@Repository
public class CursoRepositoryImpl implements CursoRepository{
    
    private final List<Curso> cursos = new ArrayList<>(); 
    private Long siguienteId = 1L;

    @Override
    public Curso save(Curso curso){
        curso.setId(siguienteId++);
        cursos.add(curso);
        return curso;
    }

    @Override
    public List<Curso> findAll(){
        return cursos;
    }

    @Override
    public Optional<Curso> findByCodigo(String codigo){
        return cursos.stream().filter(
            c-> c.getCodigo().equals(codigo)
        ).findFirst();
    }

    @Override
    public Optional<Curso> findById(Long id){
        return cursos.stream().filter(
            c -> c.getId().equals(id)
        ).findFirst();
    }

    @Override
    public Curso update(Long id, Curso cursoActualizado){
        //validar si existe
        Optional<Curso> existe = findById(id);
        if(existe.isEmpty()){
            return null;
        }

        Curso curso = existe.get();
        curso.setNombre(cursoActualizado.getNombre());
        curso.setCodigo(cursoActualizado.getCodigo());
        curso.setCreditos(cursoActualizado.getCreditos());
        curso.setEstado(cursoActualizado.isEstado());
        return curso;
    }

    @Override
    public boolean deleteById(Long id){
        return cursos.removeIf(
            c-> c.getId().equals(id)
        );
    }

}
