package KOS.Lessons.multyThreading.tkach;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Acount {
    private  int balance;
    private AtomicInteger failCount;
    private Lock lock = new ReentrantLock();

    public Acount (int initBalance ){
        this.balance = initBalance;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock(){
        return lock;
    }
    public void incFailedTransferCount(){
        failCount.incrementAndGet();
    }

    public AtomicInteger getFailCount() {
        return failCount;
    }
}
