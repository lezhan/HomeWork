package KOS.Lessons.multyThreading.tkach;

import java.util.concurrent.TimeUnit;

public class Operations {
    public static void main(String[] args) throws Exception {
        final Acount a = new Acount(1000);
        final Acount b = new Acount(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        transfer(b, a, 300);
    }

    static void transfer(Acount acc1, Acount acc2, int amount) throws Exception {
        if (acc1.getBalance() < amount) throw new Exception();
        if (acc1.getLock().tryLock(3, TimeUnit.SECONDS)) {
            try {
                if (acc2.getLock().tryLock(3, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Got Lock to acc1   " + acc1.getBalance());
                        Thread.sleep(1000);

                        System.out.println("Got Lock to ___________acc2  " + acc2.getBalance());
                        acc1.withdraw(100);
                        acc2.deposit(200);
                    }
                    finally {
                        acc2.getLock().unlock();
                    }
                }
            }
            finally {
                acc1.getLock().unlock();
            }


            System.out.println("Transfer succesful");
        } else {
            acc1.incFailedTransferCount();
            acc2.incFailedTransferCount();
            System.out.println("Fuck, we didn't make it");
        }
    }
}
