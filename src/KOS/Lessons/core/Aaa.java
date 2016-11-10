package KOS.Lessons.core;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Aaa {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> allList = new ArrayList<Integer>();
//        List<Integer> list_2 = new ArrayList<Integer>();
//        List<Integer> list_3 = new ArrayList<Integer>();
//        System.out.println(list_3.size());

        Map<Integer, String> map = new LinkedHashMap<>(5,1,true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");

        map.get(3);
        map.get(5);
        map.get(1);
        System.out.println(map);







//        List<Integer> list_Other = new ArrayList<Integer>();
//
//        for (int i = 0; i < 10; i++) {
//            allList.add(Integer.valueOf(bufferedReader.readLine()));
//        }
//        for (int i = 0; i < allList.size(); i++) {
//            if(allList.get(i) == null)
//                System.out.println("I'm got null");
//
//            if(allList.get(i)%2==0)
//                list_2.add(allList.get(i));
//
//            if(allList.get(i)%3==0)
//                list_3.add(allList.get(i));
//
//            if(allList.get(i) % 2 == 0 && allList.get(i) % 3 == 0)
//                list_Other.add(allList.get(i));
//        }
//        System.out.println("list 2 ");
//        printList(list_2);
//        System.out.println("list 3 ");
//        printList(list_3);
//        System.out.println("list_Other ");
//        printList(list_Other);
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}