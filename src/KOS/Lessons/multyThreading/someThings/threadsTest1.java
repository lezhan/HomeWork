package KOS.Lessons.multyThreading.someThings;

import java.util.Hashtable;
import java.util.Map;

public class threadsTest1 {
    public static void main(String[] args) {
        Hashtable<String, Integer> counters = new Hashtable<String, Integer>();
        counters.put("first", 0);
        counters.put("second", 1);
        counters.put("third", 0);
        for (Map.Entry<String, Integer> entry : counters.entrySet())
            System.out.println(entry.getKey() + "   " + entry.getValue());
    }
}
