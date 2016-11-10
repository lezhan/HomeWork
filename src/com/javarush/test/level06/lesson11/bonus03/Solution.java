package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их
 в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int mas[] = new int[5];
        for (int i=0; i<mas.length;i++ ){
        mas[i] = Integer.parseInt(reader.readLine());
        }

        for(int i=1; i<mas.length; i++){
            for (int j=mas.length-1; j>=i; j--){
                if(mas[j-1]>mas[j]){
                    int temp = mas[j-1];
                    mas[j-1] = mas[j];
                    mas[j] = temp;
                }
            }
        }
        for(int i = 0; i<mas.length; i++)
            System.out.println(mas[i]);
    }
}
