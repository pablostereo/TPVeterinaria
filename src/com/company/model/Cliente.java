package com.company.model;

import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private ArrayList<Animal> mascotas = new ArrayList<>();

    public Cliente(int id, String nombre, String dni, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
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


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
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
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mascotas=" + mascotas.toString() +
                "}"; //TODO muestra elemntos de animal y no de clases hijas, usar equals
    }
}
