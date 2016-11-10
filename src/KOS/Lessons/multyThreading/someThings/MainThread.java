package KOS.Lessons.multyThreading.someThings;

public class MainThread{
    public static void main(String[] args)    {
        for (int i = 0; i < 100; i++)
            new Thread(new LiftOff(5)).start();
        System.out.println("Waiting for LiftOff.");
    }
}
