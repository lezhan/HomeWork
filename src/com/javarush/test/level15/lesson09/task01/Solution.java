package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(12.2, "sfgadf");
        labels.put(14.2, "sfgвапdf");
        labels.put(134.2, "sfвапdf");
        labels.put(1.2, "sfgвірпаdf");
        labels.put(2.2, "sfварdf");

    }

    public static void main(String[] args) {


        System.out.println(labels);
    }
}
