 

public class test
{
   public static void main(String [] args){
       Arbre a = Arbre.creerArbreParfait(3,1);
       a.afficherPreordre(a);
       a.afficherInordre(a);
       a.afficherPostordre(a);
       a.affichage(a);
       System.out.println("le nombre d'elements est " + a.nbElement(a));
       System.out.println("le nombre de feuilles est "+ a.nbFeuilles(a));
       System.out.println("le nombre de points Double est "+ a.nbPointsDouble(a));
       System.out.println("le nombre de points Simple est "+a.nbPointSimple(a));
       System.out.println("la hauteur est "+a.Hauteur(a));
       Arbre b=Arbre.ajout(null,5);
       b=Arbre.ajout(b,2);
       b=Arbre.ajout(b,3);
       b=Arbre.ajout(b,1);
       b=Arbre.ajout(b,12);
       b=Arbre.ajout(b,9);
       b=Arbre.ajout(b,21);
       b=Arbre.ajout(b,19);
       b=Arbre.ajout(b,25);
       b.affichage(b);
       System.out.println("le min de l'arbre est "+ b.minABR(b));
       System.out.println("le max de l'arbre est "+ b.maxABR(b));
       //b.echangeMax(b);
       //b.echangeMin(b);
       /*System.out.println("suppression de 5");
       b.supprimerABR(b,5);
       b.affichage(b);
       System.out.println("suppression de 86");
       b.supprimerABR(b,86);
       b.affichage(b);
       System.out.println("suppression de 6");
       b.supprimerABR(b,6);
       b.affichage(b);
       b.supprimerPetit(b);
       b.affichage(b);*/
       System.out.println("nombre de feuille a la profondeur 3 est "+a.nbFe(b,3));
       System.out.println("est ce que c'est des freres " + Arbre.noeudsFreres(b,new Noeud(3),new Noeud(10)));
       System.out.println("Somme de neoud double  a la profondeur 2 est "+b.somme_pintsDoubles_couche(b,3));
       System.out.println("distance entre 3 et 9 est  "+Arbre.distance(b,new Noeud(3),new Noeud(9)));
       System.out.println("distance entre 25 et 9 est  "+Arbre.distance(b,new Noeud(25),new Noeud(9)));
   }
}
