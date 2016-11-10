package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while (bufferedReader.ready()){
            stringArrayList.add(bufferedReader.readLine());
        }
        for (String s : stringArrayList){
            if (s.contains(args[0] + " ")) System.out.println(s);
        }
    }
}



//public class Solution {
//    public static void main(String[] args) throws IOException    {
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.nextLine();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//        ArrayList<String> stringArrayList = new ArrayList<String>();
//        while (bufferedReader.ready()){
//            stringArrayList.add(bufferedReader.readLine());
//        }
//        for (String s : stringArrayList){
//            if (s.contains(args[0] + " ")) System.out.println(s);
//        }
//    }
//}
