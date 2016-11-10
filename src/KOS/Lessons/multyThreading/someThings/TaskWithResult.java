package KOS.Lessons.multyThreading.someThings;

import java.util.concurrent.Callable;

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
        @Override
    public String call(){
        return "result of TaskWithResult " + id;
    }
}

