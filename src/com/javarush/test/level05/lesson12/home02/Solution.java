package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{

    private static String name;
    private static int age;
    private static String address;

    public static void main(String[] args)
    {
        Man men1 = new Man(name, age, address);
        System.out.println(name + " " + age + " " + address);
        Man men2 = new Man(name, age, address);
        System.out.println(name + " " + age + " " + address);
        Man women1 = new Man(name, age, address);
        System.out.println(name + " " + age + " " + address);
        Man women2 = new Man(name, age, address);
        System.out.println(name + " " + age + " " + address);

        // Выведи их на экран тут
    }

    public static class Man{
        private int age;
        private String name;
        private String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman{
        private int age;
        private String name;
        private String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
