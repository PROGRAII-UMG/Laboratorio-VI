package org.realiquez.lab_VI.Ejercicio4a6.mapper;

import org.realiquez.lab_VI.Ejercicio4a6.dto.LibroRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.LibroResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public Libro toEntity(LibroRequestDTO dto) {
        Libro libro = new Libro();
        libro.setTitulo(dto.titulo());
        libro.setAutor(dto.autor());
        libro.setISBN(dto.isbn());
        libro.setAnioPublicacion(dto.anioPublicacion());
        libro.setEstado(dto.estado());
        return libro;
    }

    public LibroResponseDTO toResponseDTO(Libro libro) {
        return new LibroResponseDTO(
            libro.getId(),
            libro.getTitulo(),
            libro.getAutor(),
            libro.getISBN(),
            libro.getAnioPublicacion(),
            libro.getEstado()
        );
    }
}
