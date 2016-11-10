package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileDouble = "d:/1.txt";
        String fileInt = "d:/2.txt";
        BufferedReader bufferedDouble = new BufferedReader(new FileReader(fileDouble));
        BufferedWriter bufferedInt = new BufferedWriter(new FileWriter(fileInt));
        String[] buff = new String[40];
        while (bufferedDouble.ready()){
            buff = bufferedDouble.readLine().split(" ");
            System.out.println(Arrays.toString(buff));
            for (String s : buff){
                int intData = (int) Math.round(Double.parseDouble(s));
                bufferedInt.write(String.valueOf(intData) + " ");
            }
        }
        bufferedDouble.close();
        bufferedInt.close();

    }
}












//
//public class Solution {
//    public static void main(String[] args) throws IOException{
//        Scanner scanner = new Scanner(System.in);
//        String fileD = scanner.nextLine();
//        String fileInt = scanner.nextLine();
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileD));
//        BufferedWriter dataWriter = new BufferedWriter(new FileWriter(fileInt));
//        while (bufferedReader.ready()){
//            String[] strD = bufferedReader.readLine().split(" ");
//            System.out.println(Arrays.toString(strD));
//            for (String s : strD){
//                int tmpInt =(int) Math.round(Double.parseDouble(s));
//                dataWriter.write(String.valueOf(tmpInt) + " ");
//            }
//        }
//        scanner.close();
//        dataWriter.close();
//        bufferedReader.close();
//    }
//}
