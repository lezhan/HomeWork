package com.javarush.test.level14.lesson08.home09;

public class Hrivna extends Money
{
    private String grivna = "HRN";
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public double getAmount()
    {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName()
    {
        return grivna;
    }
}
