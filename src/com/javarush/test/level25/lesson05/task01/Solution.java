package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread currentThread : threads){
            switch (currentThread.getState()){
                case NEW: currentThread.start();
                    break;
                case WAITING: currentThread.interrupt();
                    break;
                case TIMED_WAITING: currentThread.interrupt();
                    break;
                case RUNNABLE: currentThread.isInterrupted();
                    break;
                case TERMINATED: System.out.println(currentThread.getPriority());
            }
        }
    }

    public static void main(String[] args) { /////??????????????????????
        Thread[] threadList = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            threadList[i] = (new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + finalI);
                }
            }));
        }
        for (int i = 0; i < 10; i++) {
            threadList[i].start();
        }
        processThreads(threadList);
    }
}































//public class Solution {
//    public static void processThreads(Thread... threads) {
//        //implement this method - реализуйте этот метод
//    }
//}


//public class Solution {
//    public static void processThreads(Thread... threads) {
//        //implement this method - реализуйте этот метод
//        for (Thread t : threads){
//            switch (t.getState()){
//                case NEW:
//                    t.start();
//                    break;
//                case RUNNABLE:
//                    t.isInterrupted();
//                    break;
//                case WAITING:
//                    t.interrupt();
//                    break;
//                case TIMED_WAITING:
//                    t.interrupt();
//                    break;
//                case BLOCKED:
//                    t.interrupt();
//                    break;
//                case TERMINATED:
//                    System.out.println(t.getPriority());
//                    break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
