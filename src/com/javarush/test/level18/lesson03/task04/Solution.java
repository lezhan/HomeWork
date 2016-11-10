package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//Ввести с консоли имя файла
//        Найти байт или байты с минимальным количеством повторов
//        Вывести их на экран через пробел
//        Закрыть поток ввода-вывода
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (map.containsKey(data))
                map.put(data, map.get(data) + 1);
                else map.put(data, 1);
        }
        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> pair = iterator.next();
            if (pair.getValue() < min) min = pair.getValue();
        }
        System.out.println("min = " + min);
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue().equals(min))
            System.out.print(m.getKey() + " ");
        }
    }
}
