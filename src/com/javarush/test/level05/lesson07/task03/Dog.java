package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String Dog;

    public void initialize(String name){
        this.Dog = name;
}
    public  void initialize(String name, int height){
        this.Dog = name + height;
    }
    public void initialize(String name, int height, String colore){
        this.Dog = name + height + colore;
    }
}
