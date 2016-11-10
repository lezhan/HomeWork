package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static ArrayList<String> param = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        list = urlObjects(url, list);
        for ( String s : list) System.out.print(s + " ");
        System.out.println();
        for ( String s : param) {
            try            {
                alert(Double.valueOf(s));
            } catch (NumberFormatException e)  {
                alert(s);
            }
        }
    }


    public static ArrayList<String> urlObjects(String url, ArrayList <String> list)
    {
        String[] array = url.split("\\?");
        String params = array[1];
        array = params.split("\\&");
        String[] arr;

        for (String s : array)
        {
            arr = s.split("\\=");
            if (arr[0].equals("obj")) param.add(arr[1]);
            list.add(arr[0]);
        }
        return list;
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
