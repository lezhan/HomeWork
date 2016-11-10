package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("CA", "Canada");
        countries.put("RU", "Russia");
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData){
            this.incomeData = incomeData;
        }
        @Override
        public String getName() {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber(){
            String strPhoneNum = String.valueOf(incomeData.getPhoneNumber());
            while (strPhoneNum.length() < 10){
                    strPhoneNum = "0" + strPhoneNum;
            }
            return "+" + incomeData.getCountryPhoneCode() + "(" + strPhoneNum.substring(0, 3) + ")"
                    + strPhoneNum.substring(3,6) + "-" + strPhoneNum.substring(6,8) + "-"
                    + strPhoneNum.substring(8,10);
        }

        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName(){
            return countries.get(incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 050 123 45 67
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}