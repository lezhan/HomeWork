package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так,
чтобы он возвращал true, если количество дней
с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        String date = "MAY 1 2014";

        System.out.println(isDateOdd(date));
    }

    public static boolean isDateOdd(String date)  {
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy");
        Date yearBegin = new Date(117, 0, 1);
        Date dateNow = new Date();

        long difference = dateNow.getTime() - yearBegin.getTime();
        long days = difference/(24*60*60*1000);

        System.out.println(format.format(yearBegin));
        System.out.println(format.format(dateNow));
        System.out.println(days);
        if (days%2!=0)
        return true;
        else return false;
    }
}
