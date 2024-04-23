package TP6;

import java.util.ArrayList;
import java.util.Random;

public class TestConditions {

    public static void remplitAlea(ArrayList<Object> list, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(1, 51));
        }
    }

    public static int length(ArrayList<Object> list, Condition cond, boolean bool) {
        int count = 0;
        for (Object o : list) {
            if (bool) {
                if (cond.verif((int) o)) {
                    count++;
                }
            } else {
                if (!cond.verif((int) o)) {
                    count++;
                }
            }
        }
        return count;
    }
}
