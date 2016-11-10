package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    public FileConsoleWriter(String fileName) throws IOException    {
        super(fileName);
    }
    @Override
    public void write(int c) throws IOException{
        System.out.println((char)c);
        super.write(c);
    }
    @Override
    public void write(char[] cbuf) throws IOException{
        super.write(cbuf);
    }
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException{
        System.out.println(String.valueOf(cbuf, off, len));
        super.write(cbuf, off, len);
    }
    @Override
    public void write(String str) throws IOException{
        super.write(str);
    }
    @Override
    public void write(String str, int off, int len) throws IOException{
        System.out.println(new String(str.toCharArray(), off, len));
        super.write(str, off, len);
    }

    public static void main(String[] args) throws IOException{
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("d:/1.txt");
        fileConsoleWriter.write(100);
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'd'};
        fileConsoleWriter.write(chars);
        fileConsoleWriter.write(chars, 1, 3);
        fileConsoleWriter.write("abrakadabra");
        fileConsoleWriter.write("abrakadabra", 1, 4);
    }
}
