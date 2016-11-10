package com.javarush.test.level22.lesson05.task02;

/* Между    табуляциями     iuyiuy
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null || string.isEmpty()){
            throw new TooShortStringException();
        }
        int countTab = 0;
        char[] chars = string.toCharArray();
        for (char ch : chars){
            if (ch == '\t') countTab++;
        }
        if (countTab < 2) throw new TooShortStringException();
        int firstTab = string.indexOf("\t") + 1;
        int secondTab = string.indexOf("\t", firstTab);


        return string.substring(firstTab, secondTab);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("Ksdjfh\t12345\t1\t2\t4\t6\t"));
    }
}
