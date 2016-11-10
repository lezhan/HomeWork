package com.javarush.test.level18.lesson10.home03;
/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "d:/1.txt";
        String file2 = "d:/2.txt";
        String file3 = "d:/3.txt";
        FileReader fileReader1 = new FileReader(file2);
        FileReader fileReader2 = new FileReader(file3);
        FileWriter fileWriter = new FileWriter(file1);
        while (fileReader1.ready()){
            int data = fileReader1.read();
            fileWriter.write(data);
        }
        while (fileReader2.ready()){
            int data = fileReader2.read();
            fileWriter.write(data);
        }
        fileReader1.close();
        fileReader2.close();
        fileWriter.close();
    }
}








//public class Solution {
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String file1 = scanner.nextLine();
//        String file2 = scanner.nextLine();
//        String file3 = scanner.nextLine();
//
//        FileInputStream fisFrom2 = new FileInputStream(file2);
//        FileOutputStream fosTo1 = new FileOutputStream(file1);
//        byte[] data = new byte[20];
//        int count = 0;
//        while ((count = fisFrom2.read(data)) != -1){
//            fosTo1.write(data, 0, count);
//        }
//        FileInputStream fisFrom3 = new FileInputStream(file3);
//        FileOutputStream fosTo1from3 = new FileOutputStream(file1, true);
//        byte[] data2 = new byte[20];
//        int count2 = 0;
//        while ((count2 = fisFrom3.read(data2)) != -1){
//            fosTo1from3.write(data2, 0, count2);
//        }
//        fisFrom2.close();
//        fisFrom3.close();
//        fosTo1.close();
//        fosTo1from3.close();
//    }
//}