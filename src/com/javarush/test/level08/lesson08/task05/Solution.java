package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("Bandera", "Stepan");
        map.put("Shevchenko", "Taras");
        map.put("Bulba", "Semen");
        map.put("Sheremeta", "Tolik");
        map.put("Shmatko", "Kolja");
        map.put("Kyrulo", "Oleg");
        map.put("Kmet", "Nazar");
        map.put("Lema", "Ivan");
        map.put("KYK", "Vasul");
        map.put("Zep", "Kolja");
        return (HashMap)map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            int count = 0;
            for (Map.Entry<String, String> p: copy.entrySet()) {
                if (pair.getValue().equals(p.getValue())){
                    count++;
                    if(count > 1){
                        map.remove(pair.getKey());
                    }
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

        removeTheFirstNameDuplicates(createMap());
    }
}
