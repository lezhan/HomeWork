package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("d:/1z.txt", null);
            OutputStream outputStream = new FileOutputStream("d:/1z.txt");
            InputStream inputStream = new FileInputStream("d:/1z.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            if (ivanov.equals(somePerson)) System.out.println("=====>>>>>     True");
            else  System.out.println("------->>>>>      False");
            System.out.println(ivanov.name + ivanov.assets.size() + ivanov.assets.get(1).getName());
            System.out.println(somePerson.name + somePerson.assets.size() + somePerson.assets.get(1).getName());

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {}

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream)  {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasName = name != null ? "Yes" : "No";
            printWriter.println(hasName);
            if("Yes".equals(hasName))
                printWriter.println(this.name);
            if(assets.size() > 0){
                for (Asset temp : assets){
                    printWriter.println(temp.getName());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = bufferedReader.readLine();
            if("yes".equals(hasName)){
                name = bufferedReader.readLine();
                while (bufferedReader.ready()){
                    String s = bufferedReader.readLine();
                    assets.add(new Asset(s));
                    System.out.println(s);
                }

            }

        }
    }
}



//    public void save(OutputStream outputStream) throws Exception {
//        PrintWriter printWriter = new PrintWriter(outputStream);
//        String hasName = (name != null)? "yes" : "no";
//        printWriter.println(hasName);
//        if("yes".equals(hasName)){
//            printWriter.println(this.name);
//            if (assets.size()>0){
//                for (Asset temp : assets){
//                    printWriter.println(temp.getName());
//                }
//            }
//        }
//        printWriter.flush();
//        printWriter.close();
//    }
//
//    public void load(InputStream inputStream) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String hasName = reader.readLine();
//        if ("yes".equals(hasName)){
//            name = reader.readLine();
//            while (reader.ready()){
//                String s = reader.readLine();
//                assets.add(new Asset(s));
//                System.out.println(s);
//            }
//        }
//        reader.close();
//    }