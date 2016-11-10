package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);
        int fileByteCount = fileReader.available()/2;
        while (fileReader.available() > fileByteCount){
            fileOutputStream2.write(fileReader.read());
        }
        while (fileReader.available() > 0){
            fileOutputStream3.write(fileReader.read());
        }
        fileOutputStream2.close();
        fileOutputStream3.close();
        fileReader.close();
        reader.close();
    }
}

