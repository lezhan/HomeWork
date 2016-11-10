package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private String Circle;

    public void initialize(int centerX,int centerY,int radius){
       this.Circle = String.valueOf(centerX + centerY + radius);
   }
    public void initialize(int centerX,int centerY,int radius, int width){
        this.Circle = String.valueOf(centerX + centerY + radius + width);
    }
    public void initialize(int centerX,int centerY,int radius, int width,String color){
        this.Circle = centerX + centerY + radius + width + color;
    }

}
