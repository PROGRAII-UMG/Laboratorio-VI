package org.realiquez.lab_VI.Ejercicio4a6.exception;
//para el 400: datos invalidos en general
public class DatosInvalidosException extends RuntimeException{
    public DatosInvalidosException(String mensaje){
        super(mensaje);
    }
}
