package com.company.model;

import com.company.json.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Veterinaria {
    private String nombre;
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Medico> medicos = new ArrayList();
    private ArrayList<Turno> turnos = new ArrayList();
    Scanner scanner;

    public Veterinaria(String nombre) {
        this.scanner = new Scanner(System.in);
        this.nombre = nombre;
    }

    public void addMedico(String nom, String dni, String mat, String esp) {
        int aux = this.medicos.size() + 1;
        Medico med = new Medico(aux, nom, dni, mat, esp);
        this.medicos.add(med);
        this.jsonMedico();
    }

    public void jsonMedico() {
        JSONArray jsonMedArr = new JSONArray();

        for(int i = 0; i < this.medicos.size(); ++i) {
            try {
                JsonUtiles.pasarMedico(jsonMedArr, (Medico)this.medicos.get(i));
            } catch (JSONException var4) {
                var4.printStackTrace();
            }
        }

    }

    public void mostrarMedicos() {
        for(int i = 0; i < this.medicos.size(); ++i) {
            System.out.println(this.medicos.get(i));
        }

    }

    public void mostrarTurnos() {
        for(int i = 0; i < this.turnos.size(); ++i) {
            System.out.println(this.turnos.get(i));
        }

    }

    public void jsonTurno() {
        JSONArray jsonTurArr = new JSONArray();

        for(int i = 0; i < this.turnos.size(); ++i) {
            try {
                JsonUtiles.pasarTurno(jsonTurArr, (Turno)this.turnos.get(i));
            } catch (JSONException var4) {
                var4.printStackTrace();
            }
        }

    }

    public void mostrarClientes() {
        for(int i = 0; i < this.clientes.size(); ++i) {
            System.out.println(this.clientes.get(i));
        }

    }

    public ArrayList<Cliente> getClientList() {
        return this.clientes;
    }

    public ArrayList<Medico> getMedicList() {
        return this.medicos;
    }

    public Animal selecionarAnimal(Cliente cliente, String nombre) {
        Animal animal = null;
        new ArrayList();
        ArrayList<Animal> animales = cliente.getMascotas();

        for(int i = 0; i < animales.size(); ++i) {
            if (nombre == ((Animal)animales.get(i)).getName()) {
                animal = (Animal)animales.get(i);
            }
        }

        return animal;
    }

    public Medico seleccionarMedico() {
        this.mostrarMedicos();
        System.out.println("Por que veterinario desea ser atendido? Seleccione por numero de id: ");
        int aux = this.scanner.nextInt() - 1;
        Medico m = this.devolverPorID("medicos.json", aux);
        return m;
    }

    public void sacarTurno(Cliente cliente, String nombre) {
        Animal a = this.selecionarAnimal(cliente, nombre);
        Medico m = this.seleccionarMedico();
        System.out.println("Para que fecha desea el turno?");
        String f = this.scanner.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = formato.parse("23/07/2022");
        } catch (ParseException var10) {
            var10.printStackTrace();
        }

        Cliente aux = (Cliente)this.clientes.get(0);
        Turno t = new Turno(a, m, cliente, fecha);
        this.turnos.add(t);
        this.jsonTurno();
    }

    public Medico devolverPorID(String archivo, int id) {
        Medico medico = null;
        new JsonUtiles();

        try {
            JSONArray array = new JSONArray(archivo);
            new JSONObject();

            for(int i = 0; i < array.length(); ++i) {
                JSONObject object = array.getJSONObject(i);
                if (object.getInt("id") == id) {
                    medico = new Medico(object.getInt("id"), object.getString("nombre"), object.getString("matricula"), object.getString("especializacion"));
                }
            }
        } catch (JSONException var8) {
            var8.printStackTrace();
        }

        return medico;
    }
}
