package KOS.Lessons.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Прочитати з файла, який містить кілька рядків, дані, і записати їх у ArrayList  кожен рядок у новий елемент
public class ReadWriteData {
    static String file = "d:/1.txt";

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string = null;

        while ((string = bufferedReader.readLine()) != null ){
            System.out.println(string);
            list.add(string);
        }
        bufferedReader.close();
        System.out.println("_________________");

        System.out.println(list);

    }

}

