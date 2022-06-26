package com.company;

import com.company.model.Animal;
import com.company.model.Cliente;
import com.company.model.Medico;
import com.company.model.Turno;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veterinaria {
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Turno> turnos;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
    }

    public void addCliente(Cliente cli){
        clientes.add(cli);
    }

    public void addMedico(Medico med){
        medicos.add(med);
    }

    public void generarTurno(Animal mascota, Medico medico, Cliente cliente, String informe){
        Turno t = new Turno(mascota,medico, cliente, informe, LocalDate.now());
        turnos.add(t);
        ////TODO guardar en json
    }

    public void mostrarTurnos(){
        for (int i = 0; i<turnos.size();i++){
            System.out.println(i);
        }
    }


}

