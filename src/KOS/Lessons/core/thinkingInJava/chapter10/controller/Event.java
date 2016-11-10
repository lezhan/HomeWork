package KOS.Lessons.core.thinkingInJava.chapter10.controller;

//: innerclasses/controller/Event.java
// ����� ��� ������� ������������ ������� ������.

public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() { // ��������� ���������� (³������� ��������� �� �������)
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}