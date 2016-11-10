package com.javarush.test.level20.lesson04.task01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset ... asset){
            this.name = name;
            if(assets != null){
                assets.addAll(Arrays.asList(asset));
            }
        }
    }
}
