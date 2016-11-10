package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currCode = ConsoleHelper.askCurrencyCode();
//        System.out.println("currCode" + currCode);
        String[] nomAndBanknotes = ConsoleHelper.getValidTwoDigits(currCode);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
        manipulator.addAmount(Integer.parseInt(nomAndBanknotes[0]), Integer.parseInt(nomAndBanknotes[1]));
//        System.out.println("Total Amount = " + manipulator.getTotalAmount());
    }
}
