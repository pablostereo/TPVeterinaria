package com.company.model;

public abstract class Animal {

    private String name;
    private int age;
    private String coment;
    private Cliente client;

    public Animal(String name, int age, String coment, Cliente client) {
        this.name = name;
        this.age = age;
        this.coment = coment;
        this.client = client;
    }
}