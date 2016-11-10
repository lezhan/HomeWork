package com.javarush.test.level18.lesson10.home10;
        /* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов d:/Lion.avi.part1*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException    {
        String fileName = "";

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fileNamesList = new ArrayList<String>();

        while (!(fileName = scanner.nextLine()).equals("end")){
            fileNamesList.add(fileName);
        }

        File newFile = new File(fileNamesList.get(0).split(".part")[0] );
        Collections.sort(fileNamesList);
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(newFile));

        for (int i = 0; i < fileNamesList.size(); i++){
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileNamesList.get(i));
                while (fileInputStream.available() > 0){
                    fileOutputStream.write(fileInputStream.read());
                }
                fileInputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        fileOutputStream.close();
    }
}



//public class Solution {
//    public static void main(String[] args) throws IOException    {
//        String fileName = "";
//
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> fileNamesList = new ArrayList<String>();
//
//        while (!(fileName = scanner.nextLine()).equals("end")){
//            fileNamesList.add(fileName);
//        }
//
//        File newFile = new File(fileNamesList.get(0).split(".part")[0] );
//        Collections.sort(fileNamesList);
//        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(newFile));
//
//        for (int i = 0; i < fileNamesList.size(); i++){
//            try
//            {
//                FileInputStream fileInputStream = new FileInputStream(fileNamesList.get(i));
//                while (fileInputStream.available() > 0){
//                    fileOutputStream.write(fileInputStream.read());
//                }
//                fileInputStream.close();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        fileOutputStream.close();
//    }
//}