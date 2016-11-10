package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private Singleton(){}
    private static final Singleton instance = new Singleton();


    static Singleton getInstance(){
        return instance;
    }
}
