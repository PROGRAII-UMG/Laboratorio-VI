package org.realiquez.lab_VI.Ejercicio4a6.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;
import org.springframework.stereotype.Repository;

@Repository
public class LibroRepositoryImpl implements LibroRepository {

    private final List<Libro> libros = new ArrayList<>();
    private Long siguienteId = 1L;

    @Override
    public Libro save(Libro libro) {
        libro.setId(siguienteId++);
        libros.add(libro);
        return libro;
    }

    @Override
    public List<Libro> findAll() {
        return libros;
    }

    @Override
    public Optional<Libro> findByTitulo(String titulo) {
        return libros.stream()
            .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
            .findFirst();
    }

    @Override
    public Optional<Libro> findByIsbn(String isbn) {
        return libros.stream()
            .filter(l -> l.getISBN().equalsIgnoreCase(isbn))
            .findFirst();
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return libros.stream()
            .filter(l -> l.getId().equals(id))
            .findFirst();
    }

    @Override
    public Libro update(Long id, Libro libroActualizado) {
        Optional<Libro> existe = findById(id);
        if (existe.isEmpty()) {
            return null;
        }

        Libro libro = existe.get();
        libro.setTitulo(libroActualizado.getTitulo());
        libro.setAutor(libroActualizado.getAutor());
        libro.setISBN(libroActualizado.getISBN());
        libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
        libro.setEstado(libroActualizado.getEstado());
        return libro;
    }

    @Override
    public boolean deleteById(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }
}
