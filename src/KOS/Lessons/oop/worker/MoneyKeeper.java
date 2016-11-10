package KOS.Lessons.oop.worker;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyKeeper {
    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new PermanentEmployee("Valyl",  800));
        workers.add(new PermanentEmployee("Jar", 4500));
        workers.add(new PermanentEmployee("Kola", 1600));
        workers.add(new PermanentEmployee("Kmet", 150000));
        workers.add(new HourEmployee("Semen", 10));
        workers.add(new HourEmployee("Calo", 15));
        workers.add(new HourEmployee("Verse", 21));
        workers.add(new HourEmployee("Ayiqe", 21));

        for (Employee e : workers){
            System.out.println(e);
        }

        //descending sort
        Collections.sort(workers);
        System.out.println("------------");
        for (Employee e : workers){
            System.out.println(e);
        }

        // first 5
        System.out.println("First 5");
        for(int i = 0; i<5; i++){
            System.out.println(workers.get(i));
        }

        //last 3 id
        System.out.println("Last 3");
        for(int i=workers.size()-1; i>=workers.size()-3; i--){
            System.out.println(workers.get(i).getId());
        }

        try {
            //writing into file
            FileOutputStream fileOutputStream = new FileOutputStream("d:/1.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(workers);

            System.out.println("_Size before write = " + workers.size());
            System.out.println("\n    Write OK");
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //reading object from file
        try {
            FileInputStream fileInputStream = new FileInputStream("d:/1.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Employee> worckersFromFile = new ArrayList<Employee>();

            worckersFromFile = (ArrayList<Employee>) objectInputStream.readObject();

            objectInputStream.close();
            System.out.println("\n _Size after read = " + worckersFromFile.size() + "\n");

            for (Employee employee : worckersFromFile){
                System.out.println( employee);
            }
        } // handling incorrect format of incoming file
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}
