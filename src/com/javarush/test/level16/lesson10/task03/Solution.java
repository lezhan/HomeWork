 package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread thread = new TestThread();
        thread.start();
        thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        @Override
        public void run()
        {

        }
    }
}



// public class Solution {
//     public static void main(String[] args) throws InterruptedException {
//
//         }
//
//     //Add your code below - добавь код ниже
//
// }
