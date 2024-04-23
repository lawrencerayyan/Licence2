package Avant_CC2;


/**
 * Décrivez votre classe tab_list ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class tab_list
{
    public static list convertir(int[] tab){
        list l = new list(new Maillon(tab[0]));
        Maillon cour = l.tete;
        for (int i=1; i<tab.length ;i++){
            Maillon nouveau =new Maillon(tab[i]);
            cour.succ= nouveau;
            cour=nouveau;
        }
        return l;
    }
}
