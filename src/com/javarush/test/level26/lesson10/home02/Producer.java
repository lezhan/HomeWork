package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    protected ConcurrentHashMap<String, String> map;
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        try {
            int i = 1;
            while (true){
                System.out.println("Some text for " + i);
                i++;
                Thread.sleep(500);
//                Collections.sort();
            }
        } catch (InterruptedException e){
            System.out.println("[" + currentThread + "]" + " thread was terminated");
        }
    }
}
