package com.company.model;

import com.company.enums.AnimalType;
import com.company.json.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Veterinaria {
    private String nombre;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Turno> turnos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Veterinaria(String nombre) {
        this.nombre = nombre;
    }



///////////////////Clientes//////////////////////////
    public void addCliente(String nombre, String dni, String email, String pass, String direccion, String telefono){
        int aux = clientes.size()+1;
        Cliente cli = new Cliente(aux, nombre, dni,email, pass, direccion, telefono);
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
    public void agregarAnimal(Cliente cli, String nom, AnimalType type, String raza, boolean castrado, String color, int age, String genero){
        Animal ani = new Animal(nom, type, raza, castrado, color, age, genero);
        cli.addAnimal(ani);
    }

   //////////////////////////////////////////////////////
    //////////////////////Medicos///////////////////
    public void addMedico(String nom,String dni, String mat, String esp){
        int aux = medicos.size()+1;
        Medico med = new Medico(aux,nom,dni,mat,esp);
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
    /*public void generarTurno(Animal mascota, Medico medico, Cliente cliente, String informe){
        Turno t = new Turno(mascota,medico, cliente, informe, LocalDate.now());
        turnos.add(t);
        ////TODO guardar en json
    }*/

    public void mostrarTurnos(){
        for (int i = 0; i<turnos.size();i++){
            System.out.println(turnos.get(i));
        }
    }
    public void jsonTurno() {
        JSONArray jsonTurArr = new JSONArray();
        for (int i = 0; i < turnos.size(); i++) {
            try {
                JsonUtiles.pasarTurno(jsonTurArr, turnos.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
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

    ///////////////////////////////pruebas/////////////
    public Animal selecionarAnimal(){
        Animal a1;
        int aux;
        clientes.get(0).listaMascotas();
        if(clientes.get(0).getMascotas().size()>1) {
            System.out.println("Que mascota desea seleccionar?");
            aux=scanner.nextInt()-1;
            a1=clientes.get(0).getMascotas().get(aux);
        }//TODO agregar excepcion si no existe mascota, al no existir se rompe
        else{a1=clientes.get(0).getMascotas().get(0);}
        return a1;
    }
    public Medico seleccionarMedico(){
        Medico m;
        int aux;
        mostrarMedicos();
        System.out.println("Por que veterinario desea ser atendido? Seleccione por numero de id: ");
        //scanner.skip("\n");
        aux= scanner.nextInt()-1;
        m=getMedicList().get(aux);
        return m;
    }
    public void sacarTurno() {
        Animal a = selecionarAnimal();
        Medico m = seleccionarMedico();
        System.out.println("Para que fecha desea el turno?");
        String f = scanner.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formato.parse("23/07/2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Cliente cliente = clientes.get(0);
        Turno t = new Turno(a, m, cliente, fecha);
        turnos.add(t);
        jsonTurno();
    }
}

