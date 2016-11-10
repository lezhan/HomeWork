package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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

        Double[] doubleArr = new Double[treeMap.size()];

        int i = 0;
        for (Map.Entry<String, Double> pair : treeMap.entrySet()){
            doubleArr[i] = pair.getValue();
            i++;
        }
        Arrays.sort(doubleArr);
        Double max = doubleArr[doubleArr.length - 1];

        for (Map.Entry<String, Double> pair : treeMap.entrySet()){
            if (pair.getValue() == max) System.out.println(pair.getKey());
        }

        bufferedReader.close();
    }
}