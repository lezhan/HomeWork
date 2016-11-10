package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException    {
        String fileName = args[1];
        String fileOutputName = args[2];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutputName)));
        String fileEncodeing = new InputStreamReader(new FileInputStream(fileName)).getEncoding();
        if (args[0].equals("-e")){
            while (bufferedReader.ready()){
                bufferedWriter.write(bufferedReader.read() + 1);
            }
        } else if (args[0].equals("-d")){
            while (bufferedReader.ready()){
                bufferedWriter.write(bufferedReader.read() - 1);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
