package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла: 44 83 44     Пример вывода: 44 83*/
public class Solution{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        Set<Integer> integerSet = new HashSet<Integer>();
        while (fis.available() > 0){
            integerSet.add(fis.read());
        }
        for (Integer s : integerSet)
            System.out.print(s + " ");
        ArrayList<Integer> arrayList = new ArrayList<Integer>(integerSet);
        System.out.println();
        System.out.println("test list = ");
        System.out.println(Arrays.toString(arrayList.toArray()));
        System.out.println("Sorted___________");
        Collections.sort(arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}


//public class Solution {
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
//        int data = 0;
//        Set<Integer> set = new HashSet<Integer>();
//        while (fileInputStream.available() > 0){
//            data = fileInputStream.read();
//            set.add(data);
//        }
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.addAll(set);
//        Collections.sort(list);
//
//        for (Integer l : list)
//            System.out.println(l);
//        scanner.close();
//        fileInputStream.close();
//    }
//}
