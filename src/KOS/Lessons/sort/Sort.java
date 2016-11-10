package KOS.Lessons.sort;

import java.util.Arrays;

public class Sort {
    private int[] arr = new int[20];

    public void initArr(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int) (Math.random()*100);
        }
    }
    public int[] sortBubleAsc(int[] arr){
        // asc sort
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.initArr();
        System.out.println("init arr  " + Arrays.toString(sort.arr));
        System.out.println(Arrays.toString(sort.sortBubleAsc(sort.arr)));

        String s1 = new String("Bicycle");
        String s2 = new String("bicycle");
        System.out.println(s1.equals(s2) == s2.equals(s1));
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));

    }
}
