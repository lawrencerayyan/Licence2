package TP2;


/**
 * Décrivez votre classe GestionnaireDeTache ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GestionnaireDeTache
{
    private Tache [] tab ;
    private static final int taille = 5000 ;
    private int compteurdetaches;
    
    public GestionnaireDeTache()
    {
        tab = new Tache[taille ] ;
    }

    
    public Tache tacheAccomplieJour (long jour, String Description){
        return new Tache(jour,Description);
    }
    
    public Tache tacheAccomplieHeure (long heure, String Description){
        return new Tache(heure,Description);
    }
    
    public Tache tacheAccomplieMinute (long minute, String Description){
        return new Tache(minute,Description);
    }
    
    public Tache tacheAccomplieSeconde (long seconde, String Description){
        return new Tache(seconde,Description);
    }
    
    
    
    public void ajouter(Tache tache){
        if (compteurdetaches < taille ){
            tab[compteurdetaches] = tache ;
            }
        }
        
    public void affichage(){
        int i = 0;
        while(i<tab.length){
            if(tab[i] != null){
                if(!tab[i].estFini()){
                    System.out.println(tab[i].printTache());
                }
            }
            i++;
        }
    }
    public void retireTache (){
        int i = 0;
        while (i<tab.length){
            if(tab[i] != null){
                if (tab[i].estFini()){
                    tab[i] = null;
                }
            }
            i++;
        }    
    }
    public Tache[] tachesDepassées(){
        int i = 0;
        int j = 0;
        Tache[] t = new Tache[taille];
        while(i<tab.length){
            if(tab[i] != null){
                if(tab[i].estFini()){
                    t[j++] = tab[i];
                }
            }
            i++;
        }
        return t;
    }
    public Tache[] tachesPosterieur(Tache tache){
        int i = 0;
        int j = 0;
        Tache[] t = new Tache[taille];
        while(i<tab.length){
            if(tab[i] != null){
                if(tab[i].DateLimite > tache.DateLimite){
                    t[j++] = tab[i];
                }
            }
            i++;
        }
        return t;
    }
    
    }

