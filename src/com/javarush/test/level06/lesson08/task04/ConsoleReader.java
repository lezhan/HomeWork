package com.javarush.test.level06.lesson08.task04;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String sFirst = r.readLine();
        return sFirst;
    }

    public static int readInt() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int sInt = Integer.parseInt(r.readLine());
        return sInt;
    }

    public static double readDouble() throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        double sDouble;
        sDouble = Double.parseDouble(r.readLine());
        return sDouble;

    }

    public static void readLn() throws Exception
    {
        if (readString().equals("\n")){
            System.out.println("Нажали Enter");
        }
    }
}
