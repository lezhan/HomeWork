package KOS.Lessons.patterns;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        UserInvoker userInvoker = new UserInvoker(new ConcreteCommandStart(comp), new ConcreteCommandStop(comp), new ConcreteCommandReset(comp));
        userInvoker.startComp();
        userInvoker.stopComp();
        userInvoker.resetComp();
    }
}

// Command
interface Command {
    void execute();
}

// Receiver
class Comp {
    public void start() {
        System.out.println("Start");
    }

    public void stop() {
        System.out.println("Stop");
    }

    public void reset() {
        System.out.println("Reset");
    }
}

//Concrete CommandStart
class ConcreteCommandStart implements Command {
    private Comp comp;

    public ConcreteCommandStart(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.start();
    }
}

//Concrete CommandStop
class ConcreteCommandStop implements Command {
    private Comp comp;

    public ConcreteCommandStop(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.stop();
    }
}

//Concrete CommandReset
class ConcreteCommandReset implements Command {
    private Comp comp;

    public ConcreteCommandReset(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.reset();
    }
}

//Invoker
class UserInvoker {
    private Command start;
    private Command stop;
    private Command reset;

    public UserInvoker(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComp() {
        start.execute();
    }

    public void stopComp() {
        stop.execute();
    }

    public void resetComp() {
        reset.execute();
    }
}

