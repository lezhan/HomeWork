package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream objectOutputStream) throws NotSerializableException
        {
            throw new NotSerializableException("SubSolution not serializable");
        }
        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException
        {
            throw new NotSerializableException("SubSolution not serializable");
        }
    }
}


//package com.javarush.test.level20.lesson10.home06;
//
//        import java.io.*;
//
///* Запрет сериализации
//Запретите сериализацию класса SubSolution используя NotSerializableException.
//Сигнатуры классов менять нельзя
//*/
//public class Solution implements Serializable {
//    public static class SubSolution extends Solution {
//    }
//}
