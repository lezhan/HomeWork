package com.javarush.test.level10.lesson11.home06;
/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор
должен иметь смысл.*/
public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private boolean sex;
        private int age;
        private int height;
        private String country;
        private String city;
        private String car;

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(int age)
        {
            this.age = age;
        }

        public Human(boolean sex, int age)
        {
            this.sex = sex;
            this.age = age;
        }

        public Human(int age, int height)
        {
            this.age = age;
            this.height = height;
        }

        public Human(String country, String city)
        {
            this.country = country;
            this.city = city;
        }

        public Human(String city)
        {
            this.city = city;
        }

        public Human(boolean sex, String car)
        {
            this.sex = sex;
            this.car = car;
        }

        public Human(int age, String city)
        {
            this.age = age;
            this.city = city;
        }

        public Human(boolean sex, int age, String car)
        {
            this.sex = sex;
            this.age = age;
            this.car = car;
        }

        public Human(int age, String country, String city)
        {
            this.age = age;
            this.country = country;
            this.city = city;
        }
    }

}
