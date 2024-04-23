
package TP3;


/**
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Personnage
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
     String nom_personne ;
     int niveauDeVie ;
     Arme arme_main ;
     Arme arme_poche ;
    
    public Personnage (String nom_personne, Arme arme_main, Arme arme_poche  ){
        this.nom_personne = nom_personne;
        this.arme_main = arme_main ;
        this.arme_poche = arme_poche;
        this.niveauDeVie = 100 ;
    }
      
    @Override
    public String toString(){
    return ( "Le personnage :" + this.nom_personne + ", son niveau de vie :" + this.niveauDeVie +
    ", L'arme dans la main "+ this.arme_main + ", L'arme dans la poche" + this.arme_poche) ;
    }
    
    public void attaque(Personnage ennemy){
        if(this.arme_main.Getnombre_utilisation() != 0 && ennemy.niveauDeVie >0 ){
            // System.out.print("base\n"+niveauDeVie+" "+this.arme_main.getForce() + " " + ennemy.arme_main.getForce() + " \n"  );
            ennemy.niveauDeVie = ennemy.niveauDeVie -(this.arme_main.getForce() - ennemy.arme_main.getForce() ) ;
            //je deminue le nb d'utilisation de mon arme dans ma main
            arme_main.Setnombre_utilisation(arme_main.Getnombre_utilisation()-1) ;
        }
        else if ((this.arme_poche.Getnombre_utilisation() != 0 && ennemy.niveauDeVie >0 )){
            // System.out.print("swap\n");
            swap();
            attaque(ennemy);
            // if ((this.arme_poche.Getnombre_utilisation() != 0)){
            // niveauDeVie = niveauDeVie -(this.arme_poche.getForce() - ennemy.arme_poche.getForce() ) ;
            }else 
            { if (this.arme_main.Getnombre_utilisation()== 0 && this.arme_poche.Getnombre_utilisation()==0){
                System.out.println("cette personnage ne peut plus attaquer ");
            }else if(ennemy.niveauDeVie == 0 ) {System.out.println("cette personnage est déjà morte") ;} 
            }
        }
    
    public void swap(){
        Arme temp = arme_main;
        arme_poche= arme_main;
        arme_poche = temp ;
    }
    
    public void newArme(){
        this.arme_poche = new Arme() ;
    }
    
    /**
     * Constructeur d'objets de classe Personne
     */
    public Personnage()
    {
        // initialisation des variables d'instance
        
    }
    
}
