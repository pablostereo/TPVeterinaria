package com.company.excepciones;

public class ClienteNoEncontrado extends Exception {
    private String miMensaje;
    private int id;

    public ClienteNoEncontrado(String miMensaje, int id) {
        super(miMensaje);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " El cliente con ID " + getId() + " no existe.";
    }
}