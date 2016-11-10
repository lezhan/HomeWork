package KOS.Lessons.multyThreading.someThings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool{
    public static void main(String[] args)    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 7; i++)
            executorService.execute(new LiftOff(5));
        executorService.shutdown();
    }
}
