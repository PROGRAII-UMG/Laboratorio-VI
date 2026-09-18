package org.realiquez.lab_VI.Ejercicio4a6.controller;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.dto.LibroRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.LibroResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Libro;
import org.realiquez.lab_VI.Ejercicio4a6.mapper.LibroMapper;
import org.realiquez.lab_VI.Ejercicio4a6.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    private final LibroService libroService;
    private final LibroMapper libroMapper;

    public LibroController(LibroService libroService, LibroMapper libroMapper) {
        this.libroService = libroService;
        this.libroMapper = libroMapper;
    }

    @PostMapping
    public ResponseEntity<LibroResponseDTO> crearLibro(@RequestBody LibroRequestDTO requestDTO) {
        Libro libro = libroMapper.toEntity(requestDTO);
        libro = libroService.crearLibro(libro);
        LibroResponseDTO responseDTO = libroMapper.toResponseDTO(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> obtenerLibros(
        @RequestParam(required = false) String titulo
    ) {
        List<Libro> libros = libroService.obtenerLibros(titulo);
        List<LibroResponseDTO> responseDTOs = libros.stream()
            .map(libroMapper::toResponseDTO)
            .toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> actualizarLibro(
        @PathVariable Long id,
        @RequestBody LibroRequestDTO requestDTO
    ) {
        Libro libro = libroMapper.toEntity(requestDTO);
        libro = libroService.actualizarLibro(id, libro);
        LibroResponseDTO responseDTO = libroMapper.toResponseDTO(libro);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
