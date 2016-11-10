package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 100;
    }

    String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE +". Я несу "+ getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
