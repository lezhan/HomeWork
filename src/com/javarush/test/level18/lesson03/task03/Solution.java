package com.javarush.test.level18.lesson03.task03;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/
//My Version
// public class Solution {
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        FileInputStream fileReader = new FileInputStream(scanner.nextLine());
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        while (fileReader.available() > 0){
//            int data = fileReader.read();
//            if(map.containsKey(data))
//                map.put(data, map.get(data) + 1);
//            else map.put(data, 1);
//        }
//        int maxValue = 0;
//        for (Integer m : map.values())
//            if(m > maxValue) maxValue = m;
//        System.out.println("maxValue = " + maxValue);
//        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
//            if(pair.getValue() == maxValue)
//            System.out.println("Often bites " +  pair.getKey() + "      binary = " + Integer.toBinaryString(pair.getKey()));
//        }
//
//    }
//}


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bfr.readLine());
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        while (fis.available() > 0){
            int data = fis.read();
            if(!map.containsKey(data))
                map.put(data,1);
            else map.put(data, map.get(data) + 1);
        }
        int max = 0;

        Iterator<Map.Entry<Integer,Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer,Integer> pair = itr.next();
            if (max < pair.getValue()){
                max = pair.getValue();
            }
        }

        itr = map.entrySet().iterator();
        //Выводим все самые встерчающиеся байты
        while (itr.hasNext()){
            Map.Entry<Integer,Integer> pair = itr.next();
            if(pair.getValue().equals(max)){
                System.out.print(pair.getKey() + " ");
            }
        }
        bfr.close();
        fis.close();
    }
}