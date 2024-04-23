package TP6;

public class Pair implements Condition {

    public Pair() {
    }

    @Override
    public String toString() {
        return "Pair";
    }

    @Override
    public boolean verif(int param) {
        return param % 2 == 0;
    }
}
