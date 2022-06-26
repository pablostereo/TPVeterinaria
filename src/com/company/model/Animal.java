package com.company.model;

import com.company.enums.AnimalType;

public class Animal {

    private String name;
    private AnimalType type;
    private String raza;
    private boolean castrado;
    private int age;
    private String coment;


    public Animal(String name, int age, String coment) {

        this.name = name;
        this.age = age;
        this.coment = coment;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getComent() {
        return coment;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", coment='" + coment + '\'';
    }
}