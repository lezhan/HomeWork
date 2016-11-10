package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] a = s.toCharArray();
        if (Character.isLetter(a[0]))
            a[0] = Character.toUpperCase(a[0]);
            else a[1] = Character.toUpperCase(a[1]);
        for(int i=a.length-1; i>0; i--) {
            if (!(Character.isLetter(a[i])) && Character.isLetter(a[i+1]))
                    a[i+1] = Character.toUpperCase(a[i+1]);
                else continue;
        }
        for (char ch : a)
            System.out.print(ch);
    }
}
