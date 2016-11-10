package KOS.Lessons.multyThreading.tkach;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Operations2 {
    public static void main(String[] args) {
        Acount a = new Acount(1000);
        Acount b = new Acount(2000);
//        ExecutorService ex = Executors.newScheduledThreadPool(1);
//        for (int i = 0; i < 10; i++) {
//            ex.submit()
//        }
        Random random = new Random(500);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Transfer(a, b, random.nextInt()));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
