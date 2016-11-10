package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА*/
public class Solution {
    public static void main(String[] args) {
        char[] chars = "dhfgbshfgvdhfgvdhfgvkxfvkfdjghkdjfgh".toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}



//public class Solution {
//    public static void main(String[] args) throws IOException    {
//        Scanner scanner = new Scanner(System.in);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
//        while (bufferedReader.ready()){
//            char[] chars = bufferedReader.readLine().toCharArray();
//            char[] charsRev = new char[chars.length];
//            for (int i = 0; i < chars.length; i++)            {
//                charsRev[i] = chars[chars.length - i - 1];
//            }
//            System.out.println(String.valueOf(charsRev));
//        }
//    }
//}
