package com.company.model;

public abstract class Persona {
    private int id;
    private String nombre;
    private String dni;


    public Persona(int id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona() {
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'';
    }
}
