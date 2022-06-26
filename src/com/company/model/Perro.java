package com.company.model;

public class Perro extends Animal{

    private String raza;
    private boolean castrado;


    public Perro(String name, int age, String coment, String raza, boolean castrado) {
        super(name, age, coment);
        this.raza = raza;
        this.castrado = castrado;
    }

    @Override
    public String toString() {
        return "Perro {" +super.toString()+
                ", raza='" + raza + '\'' +
                ", castrado=" + castrado +
                '}';
    }
}
