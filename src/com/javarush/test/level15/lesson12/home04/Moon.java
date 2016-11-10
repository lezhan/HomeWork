package com.javarush.test.level15.lesson12.home04;

public class Moon implements Planet
{
    private Moon(){}
    private static Moon instance;
    public static synchronized Moon getInstance(){
        if(instance == null)
            instance = new Moon();
        return instance;
    }
}

