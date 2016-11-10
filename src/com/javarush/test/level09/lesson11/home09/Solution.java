package com.javarush.test.level09.lesson11.home09;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/
public class Solution{
    public static void main(String[] args)
    {   Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Mur", new Cat("Mur1"));
        map.put("Qqq", new Cat("Mur2"));
        map.put("Wwwur", new Cat("Mur3"));
        map.put("Eeeur", new Cat("Mur4"));
        map.put("Rrrur", new Cat("Mur5"));
        map.put("RTvfvur", new Cat("Mur6"));
        map.put("Xdur", new Cat("Mur7"));
        map.put("VGyy", new Cat("Mur8"));
        map.put("Mytuur", new Cat("Mur9"));
        map.put("Ovhnur", new Cat("Mur10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new  HashSet<>();
        for (Map.Entry<String, Cat> m : map.entrySet())
        set.add(m.getValue());
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
