package KOS.Lessons.oop.worker;

import java.io.Serializable;

abstract class Employee implements Comparable<Employee>, Serializable{
    private static final long serialVersionUID = 4479427575105980884L;
    String name;
    private static int countId;
    private int id;

    public Employee() {
        this.id = ++countId;
    }

    public abstract double salaryCount();

    public String toString(){
        return " # " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
