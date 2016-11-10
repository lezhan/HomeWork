package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()))
            ;)
        {
            String line = "";
            int count = 0;
            while (bufferedReader.ready()){
                count = 0;
                line = bufferedReader.readLine();
                for (String word : words){
                    if (line.contains(word)) count++;
                    System.out.println(line + "         " + count);
                }
                if (count == 2) System.out.println("====>>>>>>" + line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
