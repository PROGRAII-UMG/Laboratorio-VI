package org.realiquez.lab_VI.Ejercicio4a6.exception;

import org.realiquez.lab_VI.Ejercicio4a6.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarNoEncontrado(CursoNoEncontradoException ex){
        ErrorResponseDTO error = new ErrorResponseDTO(404, "Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CodigoDuplicadoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarPublicado(CodigoDuplicadoException ex){
        ErrorResponseDTO error = new ErrorResponseDTO(409, "Conflict", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<ErrorResponseDTO> manejarDatosInvalidos(DatosInvalidosException ex){
        ErrorResponseDTO error = new ErrorResponseDTO(400, "Bad Request", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
