package TP6;

public class Carrot extends Vegetable {
    private final double weight;
    private final int length;

    public Carrot(double weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Carotte: [" +
                weight + "kg - " +
                length + "cm]";
    }
}
