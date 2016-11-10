package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws FileNotFoundException {
        Scanner scanner =new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());

    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        if(properties != null && properties.size() != 0) {
            for (Map.Entry pair : properties.entrySet()){
                writer.println(pair.getKey() + ":" + pair.getValue());
            }
        }

    }

    public void load(InputStream inputStream) throws Exception
    {

    }

    public static void main(String[] args){

    }
}



//public class Solution {
//    public static Map<String, String> properties = new HashMap<>();
//
//    public void fillInPropertiesMap() {
//        Scanner scanner = new Scanner(System.in);
//        Properties prop = new Properties();
//        try
//        {
//            prop.load(new FileInputStream(scanner.nextLine()));
//            Set propKeys = prop.keySet();
//            for (Object prKey : propKeys){
//                properties.put((String)prKey, prop.getProperty((String)prKey));
//            }
//            for (Map.Entry pair : properties.entrySet()){
//                System.out.println(pair.getKey() + "  =   " + pair.getValue());
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void save(OutputStream outputStream) throws Exception {
//        Properties prop = new Properties();
//        prop.putAll(properties);
//        prop.store(outputStream, "saving");
//    }
//
//    public void load(InputStream inputStream) throws Exception
//    {
//        Properties prop = new Properties();
//        prop.load(inputStream);
//        Set propKeys = prop.keySet();
//        for (Object prKey : propKeys){
//            properties.put((String)prKey, prop.getProperty((String)prKey));
//        }
//        for (Map.Entry pair : properties.entrySet()){
//            System.out.println(pair.getKey() + "  =   " + pair.getValue());
//        }
//    }
//
//    public static void main(String[] args){
//        new Solution().fillInPropertiesMap();
//    }
//}
