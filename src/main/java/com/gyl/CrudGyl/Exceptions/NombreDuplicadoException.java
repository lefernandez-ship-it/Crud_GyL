package com.gyl.CrudGyl.Exceptions;

public class NombreDuplicadoException extends  RuntimeException {
    public NombreDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
