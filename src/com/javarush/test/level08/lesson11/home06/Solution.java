package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Oleg", true, 29, new ArrayList<Human>());
        Human child2 = new Human("Misha", true, 22, new ArrayList<Human>());
        Human child3 = new Human("Galja", false, 32, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human father = new Human("Stepan", true, 55, children);
        ArrayList<Human> fatherList = new ArrayList<Human>();
        fatherList.add(father);
        Human mother = new Human("Ivanna", false, 52, children);
        ArrayList<Human> motherList = new ArrayList<Human>();
        motherList.add(mother);

        Human gf1 = new Human("Oleksa", true, 75, motherList);
        Human gm1 = new Human("Ganna", false, 72, motherList);
        Human gf2 = new Human("Muhailo", true, 78, fatherList);
        Human gm2 = new Human("Helena", false, 79, fatherList);

        System.out.println("Gf1= " + gf1);
        System.out.println("Gm1= " + gm1);
        System.out.println("Gf2= " + gf2);
        System.out.println("Gm2= " + gm2);
        System.out.println("Father= " + father);
        System.out.println("Mother= " + mother);
        for (Human child : children)
            System.out.println(child);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
