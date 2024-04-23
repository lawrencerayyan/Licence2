package TP2;


import java.util.*;

public class Chronometre
{
    private long tempsDepart;
    private long duree;

  
    
    public Chronometre()
    {
        this.tempsDepart = System.nanoTime() ;
    }
    
    public long dureeMicro (){
        return ((System.nanoTime() - tempsDepart)/1000) ;
    }
   
    public long dureeMilli(){
        return ((System.nanoTime() - tempsDepart)/1000000) ;
    }
    
    public void reset(){
     tempsDepart = System.nanoTime();
    }
}
