package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] month = {"January", "February", "March", "April","May","June","July","August","September","October","November",
                "December"};

        String s = reader.readLine();
        for (int i=0; i<month.length; i++){
            if (month[i].equals(s))
                System.out.println(month[i] + " is " + (i+1) + " month");
        }
    }

}
