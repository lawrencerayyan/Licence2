package TP6;

import java.util.ArrayList;

public class Soup {
    private ArrayList<Vegetable> vegetables;

    public Soup() {
        vegetables = new ArrayList<>();
    }

    public void add(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public double getPeelingWeight() {
        double weight = 0;
        for (Vegetable vegetable : vegetables) {
            if (vegetable instanceof Carrot) {
                weight += (((Carrot) vegetable).getWeight()) * 0.1;
            } else if (vegetable instanceof Potatoe) {
                weight += (((Potatoe) vegetable).getWeight()) * 0.1 +
                        (((Potatoe) vegetable).getEyes()) * 0.01;
            }

        }
        return weight;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Soupe  \n- - - - - - \n");
        for (Vegetable vegetable : vegetables) {
            result.append(vegetable).append("\n");
        }
        return result.toString();
    }
}
