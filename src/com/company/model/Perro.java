package com.company.model;

public class Perro extends Animal{

    private String raza;
    private boolean castrado;


    public Perro(String name, int age, String coment, Cliente client, String raza, boolean castrado) {
        super(name, age, coment, client);
        this.raza = raza;
        this.castrado = castrado;
    }
}
