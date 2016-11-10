package KOS.Lessons.core;

import java.util.*;

public class TestIterator{
    public static void main(String[] args){
        final List synchList = Collections.synchronizedList(new ArrayList());
        fillList(synchList, 10);
        Thread anotherThread = new Thread(){
            public void run(){
                try{
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    System.out.println("anotherThread interrupted");
                    return;
                }
                synchList.remove(1);
                synchList.remove(7);
            }
        };
        anotherThread.start();
        Iterator iterator = synchList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
                return;
            }
        }
    }
    static void fillList(List list, int n){
        for(int i = 1; i <= n; i++)
            list.add(i);
    }
}