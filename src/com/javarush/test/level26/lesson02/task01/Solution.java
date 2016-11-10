package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        final double median;
        if (array.length % 2 == 0) {
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        else median = array[array.length / 2];
        Comparator<Integer> comparatorMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) (Math.abs(o1 - median)- Math.abs(o2-median));
            }
        };
        Arrays.sort(array, comparatorMedian);
//        System.out.println("median = " + median);
        return array;
    }

    public static void main(String[] args) {
        Integer[] mass = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(sort(mass)));
    }
}






//public class Solution {
//    public static Integer[] sort(Integer[] array) {
//        //implement logic here
//        return array;
//    }
//
//    public static void main(String[] args) {
//    }
//}
