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

    public void addAnimal(Animal a){ /// TODO distinguir que tipo de animal agregar
        mascotas.add(a);
    }

    public void listaMascotas(){
        for(int i=0; i<mascotas.size(); i++){
            System.out.println(i);
        }
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
                "}";
    }
}
