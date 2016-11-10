package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 50;
    }

    String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA +". Я несу "+ getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
