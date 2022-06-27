package com.company.model;

import java.util.ArrayList;

public class Cliente extends Persona {
    private String direccion;
    private String telefono;
    private ArrayList<Animal> mascotas = new ArrayList();
    private int contraseña;

    public Cliente(int id, String nombre, String dni, String direccion, String telefono, int contraseña) {
        super(id, nombre, dni);
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public void addAnimal(Animal a) {
        this.mascotas.add(a);
    }

    public void listaMascotas() {
        for(int i = 0; i < this.mascotas.size(); ++i) {
            System.out.println(i);
        }

    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public ArrayList<Animal> getMascotas() {
        return this.mascotas;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public int getContraseña() {
        return this.contraseña;
    }

    public String toString() {
        return "Cliente{" + super.toString() + "direccion='" + this.direccion + '\'' + ", telefono='" + this.telefono + '\'' + ", mascotas=" + this.mascotas + '\'' + ", contraseña=" + this.contraseña + '}';
    }
}
