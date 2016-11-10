package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException    {
        String fileName = "d:/1.txt";
        FileReader fileReader = new FileReader(fileName);
        int count = 0;
        while (fileReader.ready()){
            int ascii = fileReader.read();
            if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) count ++;
        }
        System.out.println(count);
        fileReader.close();
    }
}


//
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        String fileName = args[0];
//        FileReader reader = new FileReader(fileName);
//        int count = 0;
//        while (reader.ready()){
//            int ascii = reader.read();
//            if (ascii >= 65 & ascii <= 90) count++;
//            if (ascii >= 97 & ascii <= 122) count++;
//        }
//        System.out.println(count);
//        reader.close();
//    }
//}
