package com.javarush.test.level12.lesson02.task05;

/* Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
Написать метод, который определяет, объект какого класса ему передали, и возвращает результат –
одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное».
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o)
    {
        if (o.getClass().equals(Cow.class)) return  "Корова";
        else if (o.getClass().equals(Dog.class)) return  "Собака";
        else if (o.getClass().equals(Whale.class)) return  "Кит";
        else
        return "Неизвестное животное";
    }

    public static class Cow
    {
    }

    public static class Dog
    {
    }

    public static class Whale
    {
    }

    public static class Pig
    {
    }
}
