package com.javarush.test.level06.lesson08.task05;

import java.util.Arrays;

public class StringHelper
{
    public static void main(String[] args) throws Exception
    {
        int []mas = new int[10];
        int min=0;
        for(int i=0; i<mas.length; i++){
        mas[i] = (int)Math.round(Math.random()*100);
        System.out.print(mas[i] + " ");
        }

        System.out.println(Arrays.toString(mas));

        int mas2[][] = new int[10][];
        for(int i=0; i<mas2.length; i++){
            for (int j=0; j<mas2[i].length; j++){
                mas2[i][j] = (int)Math.round(Math.random()*100);
            System.out.println(mas2[i][j]);
            }
        }

    }
}