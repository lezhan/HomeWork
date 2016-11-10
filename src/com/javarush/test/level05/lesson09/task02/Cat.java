package com.javarush.test.level05.lesson09.task02;


public class Cat
{
    private String name;
    private int age;
    private String address;
    private String color;
    private int weight;

    public Cat(String name) {
        this.name = name;
        this.age = 2;
        this.weight = 3;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 3;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 2;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 2;
    }
}