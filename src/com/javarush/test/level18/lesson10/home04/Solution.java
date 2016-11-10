package com.javarush.test.level18.lesson10.home04;

import java.io.IOException;
import java.io.RandomAccessFile;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов*/
public class Solution {
    public static void main(String[] args) throws IOException{
        String file1 = "d:/1.txt";
        String file2 = "d:/2.txt";
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(file1, "rw");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");

        byte[] buffer1 = new byte[(int)randomAccessFile1.length()];
        byte[] buffer2 = new byte[(int)randomAccessFile2.length()];
        randomAccessFile1.read(buffer1);
        randomAccessFile2.read(buffer2);
        randomAccessFile1.seek(0);
        randomAccessFile1.write(buffer2);
        randomAccessFile1.write(buffer1);
        randomAccessFile1.close();
        randomAccessFile2.close();
}
}


//
//public class Solution {
//    public static void main(String[] args) throws IOException{
//        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//        String a = r.readLine();
//        String b = r.readLine();
//        RandomAccessFile file1 = new RandomAccessFile(a, "rw");
//        RandomAccessFile file2 = new RandomAccessFile(b, "r");
//
//        byte[] buffer1 = new byte[(int) file2.length()];
//        byte[] buffer2 = new byte[(int) file1.length()];
//        file2.read(buffer1);
//        file1.read(buffer2);
//        file1.seek(0);
//        file1.write(buffer1);
//        file1.write(buffer2);
//        file1.close();
//        file2.close();
//        r.close();
//    }
//}
