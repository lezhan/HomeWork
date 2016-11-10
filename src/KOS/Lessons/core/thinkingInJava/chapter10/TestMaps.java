package KOS.Lessons.core.thinkingInJava.chapter10;

import java.util.HashMap;
import java.util.TreeMap;

public class TestMaps {

    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
        TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
        long start;
        long end;
        long hashTime;
        long treeTime;

        for(int i=0; i<1_000_000; i++){
            hashMap.put(new Integer((int)Math.random()*1000000),genRandString((int)Math.round(Math.random()*36)).toString());
            treeMap.put(new Integer((int)Math.random()*1000000),genRandString((int)Math.round(Math.random()*36)).toString());
        }
        start=System.currentTimeMillis();
        for(int i=0;i<10_000_000;i++){
            String s =hashMap.get(new Integer((int)Math.random()*1000000));
        }
        end=System.currentTimeMillis();
        hashTime=end-start;
        System.out.println("����������� ����� �� ������� hashMap (ms): "+hashTime);

        start=System.currentTimeMillis();
        for(int i=0;i<10_000_000;i++){
            String s =treeMap.get(new Integer((int)Math.random()*1000000));
        }
        end=System.currentTimeMillis();
        treeTime=end-start;
        System.out.println("����������� ����� �� ������� treeMap (ms): "+treeTime);

    }
    static StringBuilder genRandString(int lenght){
        String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder randString = new StringBuilder();
        for(int i=0;i<lenght;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString;

    }
}