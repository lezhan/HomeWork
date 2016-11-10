package KOS.Lessons.core;

import java.util.*;
//import java.util.Iterator;
//import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            List temp = ar; //1
            temp.add(new java.util.Date()); //2
            temp.add(new Float(1.66));
            Iterator it = ar.iterator();
            while (it.hasNext())
                System.out.println(it.next());
            System.out.println(ar.get(0));

            int i = 1;            //1
//            i = -+(10 + 2 + i);   //2
////        ++i--;                //3
//            System.out.println(i);

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}