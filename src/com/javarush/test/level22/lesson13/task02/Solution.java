package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileNameWindows_1251 = args[0];
        String fileNameTo_Utf_8 = args[1];

        FileInputStream inputStream = new FileInputStream(fileNameWindows_1251);
        FileOutputStream outputStream = new FileOutputStream(fileNameTo_Utf_8);
        while (inputStream.available() > 0){
            byte[] bytes = new byte[1000];
            inputStream.read(bytes);
            String s = new String(bytes, "UTF-8");
            bytes = s.getBytes("Windows-1251");
            outputStream.write(bytes);
        }
    }
}
