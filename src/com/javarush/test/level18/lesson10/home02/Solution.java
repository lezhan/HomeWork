package com.javarush.test.level18.lesson10.home02;

import java.io.FileReader;
import java.io.IOException;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = "d:/1.txt";
        FileReader fileReader =new FileReader(fileName);
        int allCount = 0;
        int spaceCount = 0;
        while (fileReader.ready()){
            int ascii = fileReader.read();
            allCount++;
            if(ascii == 32) spaceCount++;
        }
        System.out.println("allCount = " + allCount + "         spaceCount = " + spaceCount);
        double spaceFrequency = (double)spaceCount / allCount * 100;
        System.out.println(spaceFrequency);
        System.out.printf("spaceFrequency = %.2f", spaceFrequency);
    }
}



//
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        InputStream fileInputStream = new FileInputStream(args[0]);
//        int count = 0;
//        int countSpase = 0;
//        int ch = 0;
//        while (fileInputStream.available() > 0){
//            ch = fileInputStream.read();
//            count++;
//            if (ch == 32) countSpase++;
//        }
//        double spaceFrequency = (double)countSpase /count * 100;
//        System.out.println(round(spaceFrequency, 2));
//    }
//    public static double round(double value, int places) {
//        if (places < 0) throw new IllegalArgumentException();
//
//        long factor = (long) Math.pow(10, places);
//        value = value * factor;
//        long tmp = Math.round(value);
//        return (double) tmp / factor;
//    }
//}
