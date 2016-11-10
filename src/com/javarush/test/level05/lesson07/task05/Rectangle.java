package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int Rectangle;

    public void initialize(int left, int top, int width, int height){
        this.Rectangle = left + top + width + height;
    }
    public void initialize(int left, int top){
        this.Rectangle = left + top;
    }
    public void initialize(int width){
        this.Rectangle = width * 4;
    }
    public void initialize(Rectangle rectangle){
        this.Rectangle = Rectangle;
    }
}
