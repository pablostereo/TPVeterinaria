package com.company.model;

public class Medico extends Persona {
    private String matricula;
    private String especializacion;

    public Medico(int id, String nombre, String matricula, String especilizacion) {
        super(id, nombre);
        this.matricula = matricula;
        this.especializacion = this.especializacion;
    }

    public Medico(int id, String nombre, String dni, String matricula, String especializacion) {
        super(id, nombre, dni);
        this.matricula = matricula;
        this.especializacion = especializacion;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getEspecializacion() {
        return this.especializacion;
    }

    public String toString() {
        return "Medico{" + super.toString() + "matricula='" + this.matricula + '\'' + ", especializacion='" + this.especializacion + '\'' + '}';
    }
}
