package com.company.model;

import java.util.ArrayList;

public class Cliente extends Persona{

    private String email;
    private String password;
    private String direccion;
    private String telefono;
    private ArrayList<Animal> mascotas = new ArrayList<>();

    public Cliente(int id, String nombre, String dni,String email, String pass, String direccion, String telefono) {
        super(id, nombre, dni);
        this.email=email;
        this.password=pass;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente(int id, String nombre, String dni, String direccion, String telefono, int contraseña) {
    }

    public void addAnimal(Animal a){
        mascotas.add(a);
    }

    public void listaMascotas(){
        for(int i=0; i<mascotas.size(); i++){
            System.out.println(i);
        }
    }
   /* public boolean browsClient(String mail) {
        Cliente clientBrows;
        Archivos archivo = new Archivos();
        List<Cliente> all = archivo.devolverClientes(mail);
        if (all==null) {
            return true;
        }
        for (Cliente client :
                all) {
            if (client.getEmail().equalsIgnoreCase(userName)) {
                clientBrows = client;
                return false;
            }
        }
        return true;
    }*/

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
