package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/1.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/2.txt"));
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String[] line;
        while (bufferedReader.ready()){
            line = bufferedReader.readLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                if(line[i].length() > 6)
                    stringArrayList.add(line[i]);
            }
        }
        String lineToWrite = "";
        for (int i = 0; i < stringArrayList.size() - 1; i++) {
            System.out.println(lineToWrite);
            lineToWrite += stringArrayList.get(i) + ",";
        }
        lineToWrite += stringArrayList.get(stringArrayList.size() - 1);
        System.out.println("Rezult = " + lineToWrite);
        bufferedWriter.write(lineToWrite);
        bufferedReader.close();
        bufferedWriter.close();
    }
}




//public class Solution {
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
//        ArrayList<String> list = new ArrayList<String>();
//        while (reader.ready())
//        {
//            String[] str = reader.readLine().split(" ");
//            for (String g : str)
//                if (g.length()>6) list.add(g);
//        }
//        String x = "";
//        for (int i = 0; i < list.size()-1; i++)
//            x += list.get(i)+",";
//        x += list.get(list.size()-1);
//        writer.write(x);
//        reader.close();
//        writer.close();
//    }
//}