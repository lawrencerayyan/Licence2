package Avant_CC2;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TestIterator
{
    public static void main (String [] args){
        int sum = 0 ;
        List<Integer> list = new ArrayList();

       
        list.add(3);
        list.add(2);
        list.add(1);
        for (Iterator<Integer> i= list.iterator();i.hasNext(); ){
            int v = i.next();
            sum += v;
            System.out.println(v);
        }
        System.out.println(sum);
    }
}
