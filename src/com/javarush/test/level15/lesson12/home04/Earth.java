package com.javarush.test.level15.lesson12.home04;

public class Earth implements Planet{
    private Earth(){}
    private static Earth instance;
    public static synchronized Earth getInstance(){
        if(instance == null)
            instance = new Earth();
        return instance;
    }
}

