package com.company.model;

import java.util.Date;

public class Turno {
    private Animal mascota;
    private Medico medico;
    private Cliente cliente;
    private String informe;
    private Date fecha;

    public Turno(Animal mascota, Medico medico, Cliente cliente, String informe, Date fecha) {
        this.mascota = mascota;
        this.medico = medico;
        this.cliente = cliente;
        this.informe = informe;
        this.fecha = fecha;
    }

    public Turno(Animal mascota, Medico medico, Cliente cliente, Date fecha) {
        this.mascota = mascota;
        this.medico = medico;
        this.cliente = cliente;
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

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Turno{mascota=" + this.mascota + ", medico=" + this.medico + ", cliente=" + this.cliente + ", informe='" + this.informe + ", fecha=" + this.fecha + '}';

    }
}
