package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static int getRectangleCount(byte[][] a){
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++){
                if (a[i][j]==1){
                    int x1 = i;
                    int y1 = j;
                    while (i < a.length){
                        if (a[i][j]==0) break;
                        i++;
                    }
                    i--;
                    while (j < a.length){
                        if (a[i][j]==0) break;
                        j++;
                    }
                    j--;
                    for (int l = x1; l <= i; l++)
                        for (int k = y1; k <= j; k++)
                            a[l][k]=0;
                    count++;
                }
            }
        return count;
    }
}