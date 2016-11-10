package com.javarush.test.level19.lesson10.bonus03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuffer str = new StringBuffer();
        while (file.ready()){
            str.append(file.readLine());
        }
        String l = str.toString().replaceAll("\r\n","");
        if (!l.contains("CDATA")){
            findTags(args[0], l, 0);
        }
    }
    public static void findTags(String tag, String x, int q)
    {
        int howManyTag = 0, lastTagsIndex = 0;
        int i = q;
        while (i < (x.length() - tag.length() - 1))
        {
            if (x.substring(i, i + tag.length() + 1).equals("<" + tag))
            {
                if (howManyTag == 0) lastTagsIndex = i;
                howManyTag++;
            }
            else if (x.substring(i, i + tag.length() + 2).equals("</" + tag))
            {
                howManyTag--;
                if (howManyTag == 0)
                {
                    String newString = x.substring(lastTagsIndex, i + tag.length() +3);
                    System.out.println(newString);
                    findTags(tag, newString, 1);
                }
            }
            i++;
        }
    }
}
//Здоровская задача! три дня потратил, сдал с первой попытки… логика 12 строк… механизм такой:
//        1.Ищем индексНачало, нашли, флаг=1 (в любом случае будет закрывашка)
//        2. (While флаг>0) если следующий тег <...> флаг инкрементируем, иначе </...> флаг декрементируем индексКонец=текущий (флаг стремится к нулю по любому)
//        3. результат в консоль, инкрементируем индексНачало и в пункт 1.
//        Все просто, без листов, мапов, арэев и т.д.
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
//        reader.close();
//        StringBuffer str = new StringBuffer();
//        while (file.ready()){
//            str.append(file.readLine());
//        }
//        String l = str.toString().replaceAll("\r\n","");
//        if (!l.contains("CDATA")){
//            findTags(args[0], l, 0);
//        }
//    }
//    public static void findTags(String tag, String x, int q)
//    {
//        int howManyTag = 0, lastTagsIndex = 0;
//        int i = q;
//        while (i < (x.length() - tag.length() - 1))
//        {
//            if (x.substring(i, i + tag.length() + 1).equals("<" + tag))
//            {
//                if (howManyTag == 0) lastTagsIndex = i;
//                howManyTag++;
//            }
//            else if (x.substring(i, i + tag.length() + 2).equals("</" + tag))
//            {
//                howManyTag--;
//                if (howManyTag == 0)
//                {
//                    String newString = x.substring(lastTagsIndex, i + tag.length() +3);
//                    System.out.println(newString);
//                    findTags(tag, newString, 1);
//                }
//            }
//            i++;
//        }
//    }
//}