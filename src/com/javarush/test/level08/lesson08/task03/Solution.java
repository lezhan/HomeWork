package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("rrrr","dyfh");
        map.put("eeee","dfh");
        map.put("www","dfdh");
        map.put("hhhhk","dfdfh");
        map.put("ffffj","dfhdfdf");
        map.put("errrdjk","ddfdfh");
        map.put("rrrrrk","dfsgvbnbnh");
        map.put("rrrrtt","dvbnnfh");
        map.put("yyyyyy","dnmfh");
        map.put("uuuuuu","dnmfh");
        return (HashMap)map;
    }


    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count=0;
        for ( Map.Entry<String, String> pair : map.entrySet())
            if (pair.getValue().equals(name))
            count++;
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        if (pair.getKey().equals(familiya))
                count++;
        return count;
    }
}
