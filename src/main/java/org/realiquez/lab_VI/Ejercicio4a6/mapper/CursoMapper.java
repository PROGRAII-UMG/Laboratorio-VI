package org.realiquez.lab_VI.Ejercicio4a6.mapper;

import org.realiquez.lab_VI.Ejercicio4a6.dto.CursoRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.CursoResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    
    public Curso toEntity(CursoRequestDTO dto){
        Curso curso = new Curso();
        curso.setNombre(dto.nombre());
        curso.setCodigo(dto.codigo());
        curso.setCreditos(dto.creditos());
        curso.setEstado(dto.estado());
        return curso;
    }

    public CursoResponseDTO toResponseDTO(Curso curso){
        return new CursoResponseDTO(
            curso.getId(),
            curso.getNombre(),
            curso.getCodigo(),
            curso.getCreditos(),
            curso.isEstado()
        );
    }
}
