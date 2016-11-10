package KOS.Lessons.core.thinkingInJava.chapter10.controller;

//: innerclasses/controller/Controller.java
// ���������� ������� ����������
import java.util.*;

public class Controller {
    // ����� �� ������ java.util ��� �������� ������� Event::
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {
        eventList.add(c);
    }
    public void run() { //������� action �� ���� � ��ﳿ Evant<List> � ����� ������� ������������ action � ��ﳿ List
        while(eventList.size() > 0)
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for(Event e : new ArrayList<Event>(eventList))
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
    }
}