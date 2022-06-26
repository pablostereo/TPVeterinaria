package com.company.model;

public class Medico extends Persona{

    private String matricula;
    private String especializacion;

    public Medico(int id, String nombre, String dni, String matricula, String especializacion) {
        super(id, nombre, dni);
        this.matricula = matricula;
        this.especializacion = especializacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    @Override
    public String toString() {
        return "Medico{" +super.toString()+
                "matricula='" + matricula + '\'' +
                ", especializacion='" + especializacion + '\'' +
                '}';
    }
}
