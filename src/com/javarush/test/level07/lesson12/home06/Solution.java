package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int),
отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось:
 Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет
использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather1 = new Human("Stepan", true, 55);
        Human grandFather2 = new Human("Ivan", true, 75);
        Human grandMother1 = new Human("Ivanna", false, 52);
        Human grandMother2 = new Human("Natala", false, 51);
        Human father = new Human("Oleg", true, 29, grandFather1, grandMother1);
        Human mother = new Human("Marjana", false, 25, grandFather2, grandMother2);
        Human son = new Human("Nazar", true, 3, father, mother);
        Human son2 = new Human("Max", true, 2, father, mother);
        Human doather = new Human("Marry", false, 1, father, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son.toString());
        System.out.println(son2.toString());
        System.out.println(doather.toString());

    }

    public static class Human    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
            }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
