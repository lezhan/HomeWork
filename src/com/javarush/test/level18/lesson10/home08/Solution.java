package com.javarush.test.level18.lesson10.home08;
/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static Map<String, Integer> result = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = "";
            while (!(fileName = reader.readLine()).equals("exit")){
                new ReadThread(fileName).start();
            }
            reader.close();
            System.out.println(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                while (fileInputStream.available() > 0){
                    int intByte = fileInputStream.read();
                    if(map.containsKey(intByte))
                        map.put(intByte, map.get(intByte) + 1);
                    else map.put(intByte, 1);
                }
                TreeSet<Integer> treeMap = new TreeSet<Integer>(map.values());
                int max = treeMap.last();

                for (Map.Entry<Integer, Integer> pair : map.entrySet()){
                    if(pair.getValue() == max) max = pair.getValue();
                }
                synchronized (this){
                    result.put(fileName, max);
                }
                fileInputStream.close();
//                System.out.println(result);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

















//public class Solution {
//    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
//
//    public static void main(String[] args) {
//
//    }
//
//    public static class ReadThread  {
//
//        @Override
//        public void run() {
//        }
//    }
//}

//
//public class Solution {
//    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String fileName;
//        while (!(fileName = scanner.nextLine()).equals("exit")){
//            new ReadThread(fileName).start();
//        }
//        scanner.close();
//    }
//
//    public static class ReadThread extends Thread {
//        private String fileName;
//        public ReadThread(String fileName) {
//            //implement constructor body
//            this.fileName = fileName;
//        }
//        @Override
//        public void run() {
//            try {
//                FileInputStream fileInputStream = new FileInputStream(fileName);
//                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//                while (fileInputStream.available() > 0){
//                    int data = fileInputStream.read();
//                    if (map.containsKey(data)) map.put(data, map.get(data) + 1);
//                    else map.put(data, 1);
//                }
//                int max = 0;
//                TreeSet<Integer> treeMap = new TreeSet<Integer>(map.values());
//                max = treeMap.last();
//                for (Map.Entry pair : map.entrySet()){
//                    if (pair.getValue() == treeMap.last()) max = (int) pair.getKey();
//                }
//                synchronized (this){resultMap.put(fileName, max);}
//                System.out.println(resultMap);
//                fileInputStream.close();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//}
