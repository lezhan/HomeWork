package KOS.Lessons.multyThreading.tkach;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
    private Acount accountFrom;
    private Acount acountTo;
    private int amount;

    public Transfer(Acount acountFrom, Acount acountTo, int amount) {
        this.accountFrom = acountFrom;
        this.acountTo = acountTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {

        if (accountFrom.getLock().tryLock(3, TimeUnit.SECONDS)) {
            try {
                if (accountFrom.getBalance() < amount) throw new Exception();
                if (acountTo.getLock().tryLock(3, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Got Lock to acc1   " + accountFrom.getBalance());
                        Thread.sleep(1000);

                        System.out.println("Got Lock to     acc2  " + acountTo.getBalance());
                        accountFrom.withdraw(100);
                        Random random = new Random(1000);
                        Thread.sleep(random.nextInt(400));
                        acountTo.deposit(200);
                    }
                    finally {
                        acountTo.getLock().unlock();
                    }
                }
            }
            finally {
                accountFrom.getLock().unlock();
            }
            System.out.println("Transfer succesful");
            return true;
        } else {
            accountFrom.incFailedTransferCount();
            acountTo.incFailedTransferCount();
            System.out.println("Fuck, we didn't make it");
            return false;
        }
    }
}
