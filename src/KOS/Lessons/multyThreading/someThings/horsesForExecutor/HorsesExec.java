package KOS.Lessons.multyThreading.someThings.horsesForExecutor;

import java.util.ArrayList;
import java.util.List;

public class HorsesExec {
    public static int countHorses = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart();
        while (calculateHorsesFinished(horses) != countHorses){}
    }

    public static class Horse extends Thread{
        private boolean isFinished;

        public Horse(String name){
            super(name);
        }
        public boolean isFinished(){
            return isFinished;
        }
        public void run(){
            String s = "";
            for (int i = 0; i <= 1000; i++) {
                s += "" + i;
                if(i == 1000){
                    s = " is finished";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int countFinished = 0;
        for (Horse h : horses){
            if (h.isFinished) countFinished++;
            else {
                System.out.println("Waiting for " + h.getName());
                h.join();
            }
        }
        return countFinished;
    }

    public static List<Horse> prepareHorsesAndStart(){
        List<Horse> horses = new ArrayList<Horse>(countHorses);
        String number;
        for (int i = 1; i <= countHorses; i++) {
            number = i < 10 ? ("Horse_0" + i) : ("Horse_" + i);
            horses.add(new Horse(number));
        }
        for (Horse horse : horses) horse.start();

        return horses;
    }
}
