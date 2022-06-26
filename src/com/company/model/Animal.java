package com.company.model;

public abstract class Animal {

    private String name;
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