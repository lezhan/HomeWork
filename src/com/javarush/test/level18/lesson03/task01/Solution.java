package com.javarush.test.level18.lesson03.task01;

import java.io.*;
import java.util.Arrays;

// My Changes
public class Solution {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.nextLine();
//        Scanner fileScaner = new Scanner(new File(fileName));
//        int max = 0;
//        while (fileScaner.hasNext()){
////            System.out.println("In while");
//            int data = fileScaner.nextInt();
//            System.out.print(data + "  ");
//            if (data > max) max = data;
//        }
//        System.out.println("max = " + max);
//        fileScaner.close();
//        scanner.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(new File(fileName)));
        int max = 0;
        while (fileBufferedReader.ready()){
            String[] data = fileBufferedReader.readLine().split(" ");
            System.out.println(Arrays.toString(data));

            for (int i = 0; i < data.length; i++) {
                int intData  = Integer.valueOf(data[i]);
                System.out.print(intData + " ");
                if(intData > max) max = intData;
            }
        }
        System.out.println("max = " + max);
    }
}


//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.nextLine();
//        FileInputStream inputStream = new FileInputStream(fileName);
//        int max = 0;
//        while (inputStream.available() > 0){
//            int data = inputStream.read();
//            System.out.println(Integer.toBinaryString(data));
//            if (data > max) max = data;
//        }
//        System.out.println(max);
//        inputStream.close();
//    }
//}
