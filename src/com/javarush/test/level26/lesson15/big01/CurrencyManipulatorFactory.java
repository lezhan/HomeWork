package com.javarush.test.level26.lesson15.big01;

import java.util.*;

public final class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<>();
    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator currentCurrencyManipulator;
        if (currencyManipulators.containsKey(currencyCode))
            return currencyManipulators.get(currencyCode);
        else {
            currentCurrencyManipulator = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, currentCurrencyManipulator);
            return currentCurrencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
//        System.out.println("currencyManipulators size =" + currencyManipulators.size());
//        System.out.println("getAllCurrencyManipulators()");
        return currencyManipulators.values();
    }
}
