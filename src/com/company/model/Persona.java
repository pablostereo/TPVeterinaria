package com.company.model;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    private int id;
    private String nombre;
    private String dni;

    public Persona(int id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        return "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", dni='" + this.dni + '\'';
    }

    public boolean equals(Object obj) {
        boolean iguales = false;
        if (obj != null && obj instanceof Persona) {
            Persona aux = (Persona)obj;
            if (aux.getId() == this.getId()) {
                iguales = true;
            }
        }

        return iguales;
    }
}
