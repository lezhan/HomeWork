package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
            Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234  19846   Путін дохлий хуй           159.00  12
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws  IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        int idInt = getId(fileName) + 1;
        String id = spaceCorection(String.valueOf(idInt), 8);

        String productName = "";
        for (int i = 1; i < args.length - 2; i++){
            productName = productName + args[i] + " ";
        }
        productName = spaceCorection(productName, 30);
        String price = spaceCorection(args[args.length - 2], 8);
        String quantity = spaceCorection(args[args.length - 1], 4);
        if(id.equals("1"))bufferedWriter.write(id + productName + price + quantity);
        else bufferedWriter.write(id + productName + price + quantity + "\n");

        bufferedWriter.close();
        scanner.close();
    }

    public static int getId(String fileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int id = 0;
        String line = "";
            ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
            while (bufferedReader.ready() && !(line = bufferedReader.readLine()).equals(""))
            {
                if (line.length() > 8)
                integerArrayList.add(Integer.valueOf(line.substring(0, 8).trim()));
                else continue;
            }
            Collections.sort(integerArrayList);
            bufferedReader.close();
        if (integerArrayList.size() != 0)
            id = integerArrayList.get(integerArrayList.size() - 1);
        return id;
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
