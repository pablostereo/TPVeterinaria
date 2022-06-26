package com.company.model;

import java.time.LocalDate;
import java.util.Date;

public class Turno {
    private Animal mascota;
    private Medico medico;
    private Cliente cliente;
    private String informe;
    private LocalDate fecha;

    public Turno(Animal mascota, Medico medico, Cliente cliente, String informe, LocalDate fecha) {
        this.mascota = mascota;
        this.medico = medico;
        this.cliente = cliente;
        this.informe = informe;
        this.fecha = fecha;
    }

    public Animal getMascota() {
        return mascota;
    }

    public Medico getMedico() {
        return medico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getInforme() {
        return informe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "mascota=" + mascota +
                ", medico=" + medico +
                ", cliente=" + cliente +
                ", informe='" + informe + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
