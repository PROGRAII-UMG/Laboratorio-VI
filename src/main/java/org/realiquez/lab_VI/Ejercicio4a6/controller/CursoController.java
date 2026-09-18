package org.realiquez.lab_VI.Ejercicio4a6.controller;

import java.util.List;

import org.realiquez.lab_VI.Ejercicio4a6.dto.CursoRequestDTO;
import org.realiquez.lab_VI.Ejercicio4a6.dto.CursoResponseDTO;
import org.realiquez.lab_VI.Ejercicio4a6.entity.Curso;
import org.realiquez.lab_VI.Ejercicio4a6.mapper.CursoMapper;
import org.realiquez.lab_VI.Ejercicio4a6.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    private final CursoService cursoService;
    private final CursoMapper cursoMapper;

    public CursoController(CursoService cursoService, CursoMapper cursoMapper){
        this.cursoService = cursoService;
        this.cursoMapper = cursoMapper;
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> crearCurso(@RequestBody CursoRequestDTO requestDTO){
        Curso curso = cursoMapper.toEntity(requestDTO);
        curso = cursoService.crearCurso(curso);
        CursoResponseDTO responseDTO = cursoMapper.toResponseDTO(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> obtenerCursos(
        @RequestParam(required = false) String codigo
    ){
        List<Curso> cursos = cursoService.obtenerCursos(codigo);
        List<CursoResponseDTO> responseDTOs = cursos.stream().map(
            cursoMapper::toResponseDTO
        ).toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> actualizarCurso(
        @PathVariable Long id, 
        @RequestBody CursoRequestDTO requestDTO) {
        Curso curso = cursoMapper.toEntity(requestDTO);
        curso = cursoService.actualizarCurso(id, curso);
        CursoResponseDTO responseDTO = cursoMapper.toResponseDTO(curso);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
