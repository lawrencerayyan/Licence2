package TP6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Soup soup = new Soup();
//        Random rand = new Random();
//        for (int i = 0; i < 10; i++) {
//            if (rand.nextBoolean()) {
//                soup.add(new Carrot(rand.nextDouble(0, 2), rand.nextInt(0, 10)));
//            } else {
//                soup.add(new Potatoe(rand.nextDouble(0,3), rand.nextInt(30)));
//            }
//        }
//        System.out.println(soup);
//        System.out.println("Poids de la peau: " + soup.getPeelingWeight());

        ArrayList<Object> list = new ArrayList<>();
        TestConditions.remplitAlea(list, 1000);
        Condition[] conds = new Condition[2];
        conds[0] = new Pair();
        conds[1] = new SuperieurA(25);

        System.out.println("Pairs: " + TestConditions.length(list, conds[0], true) + "V+"
                + TestConditions.length(list, conds[0], false) + "F");
        System.out.println("SuperieurA(25): " + TestConditions.length(list, conds[1], true) + "V+"
                + TestConditions.length(list, conds[1], false) + "F");
    }
}
