package com.javarush.test.level15.lesson12.home04;

public class Sun implements Planet{
    private Sun(){}
    private static Sun instance;
    public static synchronized Sun getInstance(){
        if(instance == null)
            instance = new Sun();
        return instance;
    }
}

