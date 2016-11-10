package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();
        while(bufferedReader.ready()){
            String[] line = bufferedReader.readLine().split(" ");
            if (treeMap.containsKey(line[0]) && line.length != 0){
                Double lastValue = treeMap.get(line[0]) + Double.valueOf(line[1]);
                treeMap.put(line[0], lastValue);
            } else treeMap.put(line[0], Double.valueOf(line[1]));
        }
        for (Map.Entry<String, Double> pair : treeMap.entrySet())
        System.out.println(pair.getKey() + " " + pair.getValue());
        bufferedReader.close();
    }
}
