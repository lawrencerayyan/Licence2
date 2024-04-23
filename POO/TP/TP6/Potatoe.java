package TP6;

public class Potatoe extends Vegetable {
    private final double weight;
    private int yeux;

    public Potatoe(double weight) {
        this.weight = weight;
        this.yeux = (int) (weight * 10);
    }

    public Potatoe(double weight, int yeux) {
            this.weight = weight;
            this.yeux = yeux;
    }

    public void format() {
        if (weight * 10 < yeux) {
            yeux = (int) (weight * 10);
        }
    }

    public double getWeight() {
        return weight;
    }

    public int getEyes() {
        return yeux;
    }

    @Override
    public String toString() {
        return "Patate: [" +
                weight + "kg - " +
                yeux + " yeux]";
    }
}
