package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        FileInputStream fileInputStream = null;
        while (true){
            fileName = scanner.nextLine();
            try {
                fileInputStream = new FileInputStream(fileName);
                int data = fileInputStream.read();
            }
            catch (FileNotFoundException e){
                System.out.println("fileName = " + fileName);
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }
}



//public class Solution {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        FileInputStream fileInputStream = null;
//        String fileName = null;
//        while (true){
//            fileName = scanner.nextLine();
//            try {
//                fileInputStream = new FileInputStream(fileName);
//                int data = fileInputStream.read();
//            }
//            catch (FileNotFoundException e){
//                System.out.println(fileName);
//                break;
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//            finally{
//                if (fileInputStream != null)
//                    try {
//                        fileInputStream.close();
//                    }
//                    catch (IOException e)
//                    {
//                        e.printStackTrace();
//                    }
//            }
//        }
//    }
//}
