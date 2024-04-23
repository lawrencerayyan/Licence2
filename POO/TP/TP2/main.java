package TP2;

/**
 * Décrivez votre classe main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class main
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public static void main(String[] args) {
        Chronometre chronometre = new Chronometre();
        for(int i=1;i<=1000000;i=i+1) {
            if (i%1000==0) {
                System.out.println(i+" "+chronometre.dureeMicro());
            }
        }
        System.out.println(chronometre.dureeMilli());
        chronometre.reset();
        for(int i=1000000;i>=1;i=i-1) {
            if (i%1000==0) {
                System.out.println(i+" "+chronometre.dureeMicro());
            }
        }
        System.out.println(chronometre.dureeMilli());
    }
} 

