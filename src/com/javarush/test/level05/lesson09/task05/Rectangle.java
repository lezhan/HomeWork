package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int Rectangle;

    public Rectangle(int left, int top, int width, int height){
        this.Rectangle = left + top + width + height;
    }
    public Rectangle(int left, int top){
        this.Rectangle = left + top;
    }
    public Rectangle(int width){
        this.Rectangle = width * 4;
    }
    public Rectangle(Rectangle rectangle){
        this.Rectangle = Rectangle;
    }
}
