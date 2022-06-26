package com.company.model;

import java.util.ArrayList;

public class Cliente extends Persona{

    private String direccion;
    private String telefono;
    private ArrayList<Animal> mascotas = new ArrayList<>();

    public Cliente(int id, String nombre, String dni, String direccion, String telefono) {
        super(id, nombre, dni);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void addAnimal(Animal a){
        mascotas.add(a);
    }

    public void listaMascotas(){
        for(int i=0; i<mascotas.size(); i++){
            System.out.println(i);
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Animal> getMascotas() {
        return mascotas;
    }

    @Override
    public String toString() {
        return "Cliente{" +super.toString()+
                "direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }
}
