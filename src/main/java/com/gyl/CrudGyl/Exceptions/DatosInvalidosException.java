package com.gyl.CrudGyl.Exceptions;

public class DatosInvalidosException extends RuntimeException{
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
