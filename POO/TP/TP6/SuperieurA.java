package TP6;

public class SuperieurA implements Condition {

    private final int ref;

    public SuperieurA(int ref) {
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    @Override
    public String toString() {
        return "SuperieurA " + ref;
    }

    @Override
    public boolean verif(int param) {
        return param > ref;
    }
}
