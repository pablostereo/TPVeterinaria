package com.company.excepciones;

public class ContraseñaIncorrecta extends Exception {
    private String miMensaje;

    public ContraseñaIncorrecta(String miMnesaje) {
        super(miMnesaje);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}