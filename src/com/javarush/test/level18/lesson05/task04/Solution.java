package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis1 = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fos2 = new FileOutputStream(bufferedReader.readLine());
        byte[] buffer = new byte[fis1.available()];
        fis1.read(buffer);
        for (int i = buffer.length - 1; i >= 0 ; i--){
            fos2.write(buffer[i]);
        }
        fis1.close();
        fos2.close();
        bufferedReader.close();
    }
}
