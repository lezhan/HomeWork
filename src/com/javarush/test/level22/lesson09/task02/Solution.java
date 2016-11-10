package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static StringBuilder getCondition(Map<String, String> params) {
        if (params.isEmpty()) return new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue() != null){
                stringBuilder.append(pair.getKey() + " = '" + pair.getValue() + "'" + " and ");
            }
        }
        return stringBuilder.delete(stringBuilder.length() - " and ".length(), stringBuilder.length());
    }

    public static void main(String[] args)    {
        Map<String, String> map = new HashMap<String, String>();

        map.put("height", "185");
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);

        System.out.println(getCondition(map));
    }
}

//public class Solution {
//    public static StringBuilder getCondition(Map<String, String> params) {
//
//        return null;
//    }
//}
