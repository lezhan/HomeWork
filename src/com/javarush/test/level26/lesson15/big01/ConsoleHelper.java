package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";
        try {
            line = bufferedReader.readLine();
            if (line.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
        }
        catch (IOException e) {}

        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String currencyCode = "";
        ConsoleHelper.writeMessage("Input currency code ...");

        while (true) {
            currencyCode = readString();
            if (currencyCode.length() != 3)
                System.out.println("try again");
            else break;
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String data;
        while (true) {
            try {
                ConsoleHelper.writeMessage("Input 2 digits");
                data = readString();
                String[] dataArr = data.split(" ");
                int nominal = Integer.parseInt(dataArr[0]);
                int amount = Integer.parseInt(dataArr[1]);
                if (dataArr.length == 2 && nominal > 0 && amount > 0)
                    return dataArr;
                else ConsoleHelper.writeMessage("Not correct data, try again ");

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException  e){
                ConsoleHelper.writeMessage("Not correct data, try again ");
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        String s = "";
        Operation operation = null;
        try {
            ConsoleHelper.writeMessage("1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            ConsoleHelper.writeMessage("Input operation ...");
            s = ConsoleHelper.readString();

            operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(s));
        }

        catch (IllegalArgumentException e){
            ConsoleHelper.askOperation();
        }
        return operation;
    }
}
