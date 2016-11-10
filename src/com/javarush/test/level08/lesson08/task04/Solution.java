package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Ван", new Date("AUGUST 1 1980"));
        map.put("Кум", new Date("JUNE 1 1980"));
        map.put("Сало", new Date("JUNE 1 1980"));
        map.put("Путін хуйло", new Date("JUNE 1 1980"));
        map.put("Меро", new Date("JUNE 1 1980"));
        map.put("Кутя", new Date("JUNE 1 1980"));
        map.put("Джміль", new Date("JULY 1 1980"));
        map.put("Сіе", new Date("JUNE 1 1980"));
        map.put("Кароне", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Date> pair = iterator.next();
            if (pair.getValue().getMonth()==5 || pair.getValue().getMonth()==6 || pair.getValue().getMonth()==7){
                iterator.remove();
            }
        }
    }


}
