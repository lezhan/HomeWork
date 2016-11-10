package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list_A = new ArrayList();
        ArrayList<Integer> list_B = new ArrayList();
        ArrayList<Integer> list_NSD = new ArrayList();

        for (int i = 1; i <= a; i++)
        {
            if (a % i == 0) list_A.add(a / i);
        }
        for (int j = 1; j <= b; j++)
        {
            if (b % j == 0) list_B.add(b / j);
        }

        for (int k = 0; k < list_A.size(); k++)
        {
            for (int z = 0; z < list_B.size(); z++)
            {
                if (list_A.get(k) == list_B.get(z)) {
                    list_NSD.add(list_A.get(k));
                }
            }
        }
        System.out.println(list_NSD.get(0));
    }
}
