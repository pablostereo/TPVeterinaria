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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isCastrado() {
        return this.castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String toString() {
        return "Animal [name=" + this.name + ", type=" + this.type + ", raza=" + this.raza + ", castrado=" + this.castrado + ", color=" + this.color + ", age=" + this.age + ", genero=" + this.genero + "]";
    }
}
