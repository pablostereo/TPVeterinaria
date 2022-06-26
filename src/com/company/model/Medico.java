package com.company.model;

public class Medico {
    private int id;
    private String nombre;
    private String matricula;
    private String especializacion;

    public Medico(int id, String nombre, String matricula, String especializacion) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.especializacion = especializacion;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
