package ch09;

public class VerifierExample {

    int value = 0;

    public void set(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.value += value;
    }

    public void minus(int value) {
        this.value -= value;
    }

    public int getValue() {
        return this.value;
    }

}
