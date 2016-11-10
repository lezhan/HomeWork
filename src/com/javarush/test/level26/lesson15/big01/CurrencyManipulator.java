package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount(){
        int rez = 0;
        for (Map.Entry<Integer, Integer> m : denominations.entrySet()){
            rez += (m.getKey() * m.getValue());
        }
        return rez;
    }

    public boolean hasMoney(){
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return hasMoney() && expectedAmount < getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return result;
    }








//    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
//        Map<Integer, Integer> copyDenomination = new TreeMap<>(Collections.reverseOrder());
//        Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
//        copyDenomination.putAll(denominations);
//
//        for (Map.Entry<Integer, Integer> pair : copyDenomination.entrySet()) {
//            if (expectedAmount >= pair.getKey()){
//
//                int countBanknot = expectedAmount / pair.getKey();
//                if (pair.getValue() >= countBanknot ) {
//                    result.put(pair.getKey(), countBanknot);
//                    expectedAmount = expectedAmount - countBanknot * pair.getKey();
//                    pair.setValue(pair.getValue() - countBanknot);
//
//                    denominations.put(pair.getKey(), denominations.get(pair.getKey()) - countBanknot);
//                }
//            }
//        }
//        if (expectedAmount > 0) throw new NotEnoughMoneyException();
//
//        return result;
//    }

//    public static void main(String[] args) {
//        CurrencyManipulator currencyManipulator = new CurrencyManipulator("Test");
//        currencyManipulator.denominations.put(500, 2);
//        currencyManipulator.denominations.put(200, 3);
//        currencyManipulator.denominations.put(100, 1);
//        currencyManipulator.denominations.put(50, 12);
//        System.out.println(currencyManipulator.currencyCode + " " + currencyManipulator.denominations.size());
//
//        Map<Integer, Integer> rez = new TreeMap<>(Collections.<Integer>reverseOrder());
////        System.out.println("rez size before put = " + rez.size());
//        try {
//            rez.putAll(currencyManipulator.withdrawAmount(630));
//        } catch (NotEnoughMoneyException e){
////            System.out.println("NotEnoughMoneyException");
//        }
//
//        System.out.println("rez size after put = " + rez.size() + "/" + rez.toString());
//
//
//    }
}














