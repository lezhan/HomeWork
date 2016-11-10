package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    public static final long serialVersionUID = 170501993;
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        out.flush();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        fileName = (String) in.readObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

// Для тех, кто пока не решил:
//    1) Надо создать поле fileName и как полагается считать и записать его в соответствующих методах readObject () и writeObject () (ну про
//       конструктор уж молчу).
//    2) Наше поле stream должно же как-то инициализироваться после десериализации, а посему после считывания fileName инициализируем stream.
//    3) Когда инициализируем stream, ооооочень внимательно смотрим на параметры конструктора (должен передать 2 параметра)
//    4) stream не сериализуется, добавляем соответствущий модификатор.
//    5) Упорство никто не отменял.
//            …
//    6)Профит!
//
// public static void main(String[] args) throws Exception
//    {
//        Solution solution = new Solution("d:/1");
//        solution.writeObject("CRAKA");
//        solution.close();
//        //  Save
//        FileOutputStream fileOutputStream = new FileOutputStream("d:/2.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        solution.writeObject(objectOutputStream);
//        objectOutputStream.flush();
//        objectOutputStream.close();
//        //  Load
//        FileInputStream fileInputStream = new FileInputStream("d:/2.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Solution solution_2 = (Solution) objectInputStream.readObject();
//        objectInputStream.close();
//        solution_2.writeObject("HiMHo");
//
//        solution_2.close();
//
//    }
}
///*package com.javarush.test.level20.lesson10.home07;
//
//        import java.io.*;
//
///* Переопределение сериализации в потоке
//Сериализация/десериализация Solution не работает.
//Исправьте ошибки не меняя сигнатуры методов и класса.
//Метод main не участвует в тестировании.
//*/
//public class Solution implements Serializable, AutoCloseable {
//    private FileOutputStream stream;
//
//    public Solution(String fileName) throws FileNotFoundException {
//        this.stream = new FileOutputStream(fileName);
//    }
//
//    public void writeObject(String string) throws IOException {
//        stream.write(string.getBytes());
//        stream.write("\n".getBytes());
//        stream.flush();
//    }
//
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        out.close();
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        in.close();
//    }
//
//    @Override
//    public void close() throws Exception {
//        System.out.println("Closing everything!");
//        stream.close();
//    }
//
//    public static void main(String[] args) throws IOException
//    {
//        Solution solution = new Solution("d:/1");
//        solution.writeObject("CRAKA");
//        //  Save
//        FileOutputStream fileOutputStream = new FileOutputStream("d:/1");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        solution.writeObject(objectOutputStream);
//        //  Load
//
//    }
//}
