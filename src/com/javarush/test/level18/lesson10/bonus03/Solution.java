package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> stringArrayList = new ArrayList<String>();
        scanner.close();
        String argsId = spaceCorection(args[1], 8);
        String line = "";
        if (args.length < 2) return;
        if (argsId.length() < 8) return;
        if (args[0].equals("-u")){
            while (bufferedReader.ready()){
                line = bufferedReader.readLine();
                if (line == null) break;
                if (line.contains(argsId)) {
                    line = line.substring(0, 8) + spaceCorection(args[2], 30)  + spaceCorection(args[3], 8) + spaceCorection(args[4], 4);
                }
                stringArrayList.add(line);
            }
        } else if (args[0].equals("-d")){
            while (bufferedReader.ready()){
                line = bufferedReader.readLine();
                if (line == null) break;
                if (!line.contains(argsId)){
                    stringArrayList.add(line);
                }
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (String str : stringArrayList){
            bufferedWriter.write(str + System.getProperty("line.separator"));
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
    public static String spaceCorection(String target, int spaces){
        if (target.length() < spaces) {
            for (int i = target.length(); i < spaces; i++){
                target = target + " ";
            }
        } else if (target.length() > spaces){
            target = target.substring(0, spaces);
        }
        return target;
    }
}
