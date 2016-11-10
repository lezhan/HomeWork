package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) return;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1])))
        {
            while (bufferedReader.ready()){
                String[] line = bufferedReader.readLine().split(" ");
                for (String word : line){
                    if (word.matches(".*\\d.*")) {
                        bufferedWriter.write(word + " ");
                    }
                }
            }
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
    }
}
