package KOS.Lessons.multyThreading.someThings;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
    @Override
    public void run(){
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + "this = " + this.getClass().getSimpleName() );
            }
        } catch (InterruptedException e){
            System.err.println("sleep interrupted");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread simpleDeamon = new Thread(new SimpleDaemons());
            simpleDeamon.setDaemon(true);
            simpleDeamon.start();
            System.out.println("i = " + i);
        }
        System.out.println("All deamons started.");
//        Thread.currentThread().interrupt();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("         Current Thread  >>>" + Thread.currentThread());
        System.out.println("    sleep ___   Finished");
    }
}
