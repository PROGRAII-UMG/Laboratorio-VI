package org.realiquez.lab_VI.Ejercicio4a6.service;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;
import org.realiquez.lab_VI.Ejercicio4a6.exception.CodigoDuplicadoException;
import org.realiquez.lab_VI.Ejercicio4a6.exception.CursoNoEncontradoException;
import org.realiquez.lab_VI.Ejercicio4a6.exception.DatosInvalidosException;
import org.realiquez.lab_VI.Ejercicio4a6.repository.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro crearLibro(Libro libro) {
        validarDatos(libro);
        if (libroRepository.findByIsbn(libro.getISBN()).isPresent()) {
            throw new CodigoDuplicadoException("Ya existe un libro con el isbn " + libro.getISBN());
        }

        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> obtenerLibros(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            return libroRepository.findByTitulo(titulo)
                .map(List::of)
                .orElseThrow(() -> new CursoNoEncontradoException("No existe un libro con el titulo " + titulo));
        }
        return libroRepository.findAll();
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libroNuevo) {
        validarDatos(libroNuevo);
        Libro actualizado = libroRepository.update(id, libroNuevo);
        if (actualizado == null) {
            throw new CursoNoEncontradoException("No existe un libro con el id " + id);
        }
        return actualizado;
    }

    @Override
    public void eliminarLibro(Long id) {
        boolean eliminado = libroRepository.deleteById(id);
        if (!eliminado) {
            throw new CursoNoEncontradoException("No existe un libro con el id " + id);
        }
    }

    private void validarDatos(Libro libro) {
        if (
            libro.getTitulo() == null || libro.getTitulo().isBlank() ||
            libro.getAutor() == null || libro.getAutor().isBlank() ||
            libro.getISBN() == null || libro.getISBN().isBlank()
        ) {
            throw new DatosInvalidosException("Titulo, autor e isbn son obligatorios.");
        }

        if (libro.getAnioPublicacion() != null && libro.getAnioPublicacion() < 0) {
            throw new DatosInvalidosException("El anio de publicacion no puede ser negativo.");
        }
    }
}
