package com.javarush.test.level22.lesson13.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть,
    то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {

        return ((telNumber.matches("^\\+[\\(\\-]?(\\d[\\(\\)\\-]?){11}\\d$") || telNumber.matches("^\\(?(\\d[\\-\\(\\)]?){9}\\d$"))
                && telNumber.matches("[\\+]?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d*\\-?\\d*\\d$"));

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =  new BufferedReader(new FileReader("C:\\Users\\Russidze\\Desktop\\aa.txt"));
        while (reader.ready()){
            String tel = reader.readLine();
            System.out.println(tel +" "+ checkTelNumber(tel));
        }
    }
}

//38xx501A34567     |false  |
//        |3805012345        |true   |
//        |+380501234567     |true   |
//        |++380501234567    |false  |
//        |+38(0501234567    |false  |
//        |+38)050(1234567   |false  |
//        |+38(050)1234567   |true   |
//        |+38(05)1234567    |false  |
//        |(3)80501234567    |false  |
//        |(380)501234567    |false  |
//        |380-50123-45      |true   |
//        |(380)501-234567   |false  |
//        |(38-0)501234567   |false  |
//        |380-(501)234567   |false  |
//        |380(50-1)234567   |false  |
//        |380(501)(23)4567  |false  |
//        |+38050123(456)7   |true   |
//        |+38050123(456)76  |false  |
//        |+380501234(567)   |false  |
//        |3-805-0123-45     |false  |
//        |-3805-012345      |false  |
//        |3805-012345-      |false  |
//        |+380501234567     |true   |
//        |+38(050)1234567   |true   |
//        |+38(05)01234567   |false  |
//        |+38(0501)234567   |false  |
//        |+38050123-45-67   |true   |
//        |050123-4567       |true   |
//        |+38)050(1234567   |false  |
//        |+38(050)1-23-45-6-7|false |
//        |050ххх4567        |false  |
//        |050123456         |false  |
//        |+38-(050)1234567  |false  |
//        |+38((050)1234567  |false  |
//        |+5(0--5)1234567   |false  |
//        |7-4-4123689-5     |false  |
//        |1-23456789-0      |true   |
//        |+38051202(345)7   |true   |
//        |+38051202(345)-7  |false  |
//        |+-313450531202    |false  |
//        |+313450--531202   |false  |