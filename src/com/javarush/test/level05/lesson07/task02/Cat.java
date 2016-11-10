package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String cat= null;

    public void initialize(String name)
    {
        this.cat = name;
    }

    public void initialize(String name, int ves, int voz)
    {
        this.cat = name + ves + voz;
    }

    public void initialize(String name, int voz)
    {

        this.cat = name + 5 + voz;
    }

    public void initialize(String name, String add, int voz, int ves, String cvet)
    {
        if(add == null)
        {
            add = "www";
        }

        this.cat = name + add + voz + ves + cvet;
    }
    public void initialize(String add, int ves, String cvet)
    {

        this.cat = add + ves + cvet;
    }
}