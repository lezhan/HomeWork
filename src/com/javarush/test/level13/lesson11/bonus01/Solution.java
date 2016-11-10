//* Сортировка четных чисел из файла///1. Ввести имя файла с консоли.
//        2. Прочитать из него набор чисел.
//        3. Вывести на консоль только четные, отсортированные по возрастанию.
//        Пример ввода: 5
//        8
//        11
//        3
//        2
//        10
//        Пример вывода:2
//        8
//        10*/
package com.javarush.test.level13.lesson11.bonus01;
        import java.io.*;
        import java.util.ArrayList;
        import java.util.Collections;

public class Solution
{
    private static int data;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<Integer> list = new ArrayList<Integer>();
        String sdata = bufferedReader.readLine();
        while (sdata != null){
            data = Integer.parseInt(sdata);
            if(data % 2 == 0)
            list.add(data);
            sdata = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();
        Collections.sort(list);
        for (int l : list)
            System.out.println(l);
    }
}
