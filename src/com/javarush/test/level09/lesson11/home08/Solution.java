package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять
объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] mas1 = {4,5,24,1,6};
        int[] mas2 = {24,2};
        int[] mas3 = {14,2,9,3};
        int[] mas4 = {4,5,248,3,89,64,12};
        int[] mas5 = {};
        list.add(mas1);
        list.add(mas2);
        list.add(mas3);
        list.add(mas4);
        list.add(mas5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
