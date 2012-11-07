package ch04;

public class AssertionFail {

    public boolean timeOut;

    public void invoke(Runnable logic) {
        if (timeOut) throw new IllegalStateException();
        logic.run();
    }

}
