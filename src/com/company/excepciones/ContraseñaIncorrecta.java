package com.company.excepciones;

public class Contrase├▒aIncorrecta extends Exception {
    private String miMensaje;

    public Contrase├▒aIncorrecta(String miMnesaje) {
        super(miMnesaje);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
