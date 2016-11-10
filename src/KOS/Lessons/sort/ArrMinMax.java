package KOS.Lessons.sort;

import java.util.Arrays;
import java.util.Random;

public class ArrMinMax {
    static int[] arr = new int[50];

    static int[] sortAsc(int[] arr) {
        int[] sortedAscArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedAscArr);
        return sortedAscArr;
    }

    static void sortDesc(int[] arr) {
        int[] sortedDescArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedDescArr);
        System.out.print("Sorted Asc = " + "[");
        for (int i = sortedDescArr.length - 1; i >= 0 ; i--) {
            System.out.print(sortedDescArr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        fillArr(arr);
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Sorted Desc = " + Arrays.toString(sortAsc(arr)));
        sortDesc(arr);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("min = " + min(arr));
        System.out.println("max = " + max(arr));

    }

    private static void fillArr(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
    }

    private static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min < arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max > arr[i])
                max = arr[i];
        }
        return max;
    }
}
