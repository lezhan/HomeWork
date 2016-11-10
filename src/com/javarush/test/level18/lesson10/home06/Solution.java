package com.javarush.test.level18.lesson10.home06;
/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки      Пример вывода:
, 19
- 7
f 361*/
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>();
        FileReader fileReader = new FileReader("d:/1.txt");
        while (fileReader.ready()){
            char ch = (char) fileReader.read();
            if(characterIntegerMap.containsKey(ch))
                characterIntegerMap.put(ch, characterIntegerMap.get(ch) + 1);
            else characterIntegerMap.put(ch, 1);
        }
        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(characterIntegerMap);
        for (Map.Entry pair : sortedMap.entrySet())
            System.out.println(pair.getKey() + "     " + pair.getValue());
    }
}

















//public class Solution {
//    public static void main(String[] args) throws IOException    {
//        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(args[0]));
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        while (inputStreamReader.ready()){
//            int data = inputStreamReader.read();
//            if (map.containsKey((char)data)) map.put((char)data, map.get((char)data) + 1);
//            else map.put((char) data, 1);
//        }
//        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(map);
//        for (Map.Entry pair : sortedMap.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//    }
//}
