package com.company.model;

import com.company.enums.AnimalType;

import java.io.Serializable;

public class Animal implements Serializable {

    private String name;
    private AnimalType type;
    private String raza;
    private boolean castrado;
    private String color;
    private int age;
    private String genero;


    public Animal(String name, AnimalType type, String raza, boolean castrado, String color, int age, String genero) {
        this.name = name;
        this.type = type;
        this.raza = raza;
        this.castrado = castrado;
        this.color = color;
        this.age = age;
        this.genero = genero;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }
    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isCastrado() {
        return castrado;
    }
    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Animal [name=" + name + ", type=" + type + ", raza=" + raza + ", castrado=" + castrado + ", color="
                + color + ", age=" + age + ", genero=" + genero + "]";
    }

}