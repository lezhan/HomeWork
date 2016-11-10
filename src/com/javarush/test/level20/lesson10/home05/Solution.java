package com.javarush.test.level20.lesson10.home05;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static class Person implements Serializable{
        private static final long serialVersionUID = 1L;
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }
    enum Sex {
        MALE,
        FEMALE
    }
}

//-----------------------------
//package com.javarush.test.level20.lesson10.home05;
//
//        import java.io.PrintStream;
//        import java.util.logging.Logger;
//
///* Сериализуйте Person
//Сериализуйте класс Person.
//*/
//public class Solution {
//
//    public static class Person {
//        String firstName;
//        String lastName;
//        String fullName;
//        final String greetingString;
//        String country;
//        Sex sex;
//        PrintStream outputStream;
//        Logger logger;
//
//        Person(String firstName, String lastName, String country, Sex sex) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.fullName = String.format("%s, %s", lastName, firstName);
//            this.greetingString = "Hello, ";
//            this.country = country;
//            this.sex = sex;
//            this.outputStream = System.out;
//            this.logger = Logger.getLogger(String.valueOf(Person.class));
//        }
//    }
//
//    enum Sex {
//        MALE,
//        FEMALE
//    }
//}
