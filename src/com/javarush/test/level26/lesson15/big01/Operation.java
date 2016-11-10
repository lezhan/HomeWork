package com.javarush.test.level26.lesson15.big01;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
        Operation operation ;
        if (i == 1) operation = INFO;
        else if (i == 2) operation = DEPOSIT;
        else if (i == 3) operation = WITHDRAW;
        else if (i == 4) operation = EXIT;
        else throw new IllegalArgumentException();
        return operation;
    }
}
