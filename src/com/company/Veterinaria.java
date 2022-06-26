package com.company;

import com.company.model.Animal;
import com.company.model.Cliente;
import com.company.model.Medico;
import com.company.model.Turno;
import org.json.JSONArray;
import org.json.JSONException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veterinaria {
    private String nombre;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Turno> turnos = new ArrayList<>();

    public Veterinaria(String nombre) {
        this.nombre = nombre;
    }
///////////////////Clientes//////////////////////////
    public void addCliente(String nombre, String dni, String direccion, String telefono){
        int aux = clientes.size()+1;
        Cliente cli = new Cliente(aux, nombre, dni, direccion, telefono);
        clientes.add(cli);
        jsonCliente();
    }
    public void jsonCliente() {
        JSONArray jsonCliArr = new JSONArray();
        for (int i = 0; i < clientes.size(); i++) {
            try {
                JsonUtiles.pasarCliente(jsonCliArr, clientes.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void agrCliente(Cliente cli){
        clientes.add(cli);
    } //TODO chequear id que coincida con addCliente
   //////////////////////////////////////////////////////
    //////////////////////Medicos///////////////////
    public void addMedico(String nom, String mat, String esp){
        int aux = medicos.size()+1;
        Medico med = new Medico(aux, nom, mat, esp);
        medicos.add(med);
        jsonMedico();
    }

    public void jsonMedico() {
        JSONArray jsonMedArr = new JSONArray();
        for (int i = 0; i < medicos.size(); i++) {
            try {
                JsonUtiles.pasarMedico(jsonMedArr, medicos.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostrarMedicos(){
        for (int i = 0; i<medicos.size();i++){
            System.out.println(medicos.get(i));
        }
    }
//////////////////////////////////////////////////
/////////////////////////Turnos//////////////////
    public void generarTurno(Animal mascota, Medico medico, Cliente cliente, String informe){
        Turno t = new Turno(mascota,medico, cliente, informe, LocalDate.now());
        turnos.add(t);
        ////TODO guardar en json
    }

    public void mostrarTurnos(){
        for (int i = 0; i<turnos.size();i++){
            System.out.println(turnos.get(i));
        }
    }

    public void mostrarClientes(){
        for (int i = 0; i<clientes.size();i++){
            System.out.println(clientes.get(i));
        }
    }

    public ArrayList<Cliente> getClientList(){
        return clientes;
    }

    public ArrayList<Medico> getMedicList(){
        return medicos;
    }


}

