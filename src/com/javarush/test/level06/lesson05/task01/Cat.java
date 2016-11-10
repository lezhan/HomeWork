package com.javarush.test.level06.lesson05.task01;

/* Метод finalize класса Cat
В классе Cat создать метод protected void finalize() throws Throwable
*/

public class Cat
{

    private Object name;

    protected void finalize() throws Throwable
    {
        System.out.println(name + "Destroyed");
    }

}

