package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A() {}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream stream) throws IOException{
           stream.defaultWriteObject();
           stream.writeObject(name);
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
           stream.defaultReadObject();
           name = (String) stream.readObject();
        }
    }
    public static void main(String[] args){
        B b = new Solution().new B("BBB");
        System.out.println(b.name);
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
            objectOutputStream.writeObject(b);
            objectOutputStream.flush();
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/1.txt"));
            B deserB = (B) objectInputStream.readObject();
            System.out.println("deserB.name = "+ deserB.name + "  ///" + deserB.getClass());
            objectInputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
