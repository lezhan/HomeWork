package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            Person person = null;
            if (scanner.hasNext())
            {
                String first = scanner.next();
                String second = scanner.next();
                String third = scanner.next();
                int date = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                Calendar calendar = new GregorianCalendar(year, --month, date);
                person = new Person(second, third, first, calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
