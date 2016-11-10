package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

class WithdrawCommand implements Command
{

    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            ConsoleHelper.writeMessage("Please input amount to withdraw...");
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("specify.amount");
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage("specify.not.empty.amount");
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage("not.enough.money");
                continue;
            }
            try
            {
                currencyManipulator.withdrawAmount(sum);
                break;
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("exact.amount.not.available");
                continue;
            }


        }
    }
}
//class WithdrawCommand implements  Command {
//    @Override
//    public void execute() throws InterruptOperationException {
//        Map<Integer, Integer> resultWithdrowed = new TreeMap<>(Collections.<Integer>reverseOrder());
//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        while (true) {
//            ConsoleHelper.writeMessage("Please input amount to withdraw...");
//            try {
//                int amountToWithdraw = Integer.parseInt(ConsoleHelper.readString());
//                if (currencyManipulator.isAmountAvailable(amountToWithdraw)){
//                    resultWithdrowed = currencyManipulator.withdrawAmount(amountToWithdraw);
//                    for (Map.Entry pair : resultWithdrowed.entrySet()){
//
//                    }
//                }
//
//            } catch (NumberFormatException e){
//                ConsoleHelper.writeMessage("Not correct data, please try again...");
//            }
//            catch (NotEnoughMoneyException e) {
//                ConsoleHelper.writeMessage("Not Enough Money");
//            }
//        }
//    }
//}
