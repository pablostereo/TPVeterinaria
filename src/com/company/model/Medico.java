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



    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
