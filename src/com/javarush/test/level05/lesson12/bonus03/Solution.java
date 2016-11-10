package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int N = Integer.parseInt(reader.readLine());
        int m = 0;
        m = Integer.parseInt(reader.readLine());
        maximum = m;
        for (int i = 2; i <= N; i++)
            {
                m = Integer.parseInt(reader.readLine());
                if (m > maximum){
                maximum = m;
                }
            }
        System.out.println(maximum);
    }
}
