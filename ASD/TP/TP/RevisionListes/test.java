package RevisionListes;

public class test
{
   public static void main (String [] args){
       List l = List.creerLSC(10);
       l.afficher(l);
       List l1 = List.syracus_it(6);
       l1.afficher(l1);
       List l2 = List.syracus_rec(6);
       l2.afficher(l2);
       int [] tab = {3,1,2,-3,4,3,56,-6,7,3,-9,3};
       List l3 = List.convertirLSC(tab);
       l3.afficher(l3);
       List l4 =List.convertirLDC(tab);
       /*l4.afficherLDC(l4);
       System.out.println("la longueur de l est : " + l.longueur(l));
       System.out.println("la longueur de l est : " + l.longueurRec(l));
       System.out.println("la position de 4 est : " + l.position(l,4));
       System.out.println("la position de 4 est : " + l.positionRec(l,4));
       System.out.println("le nombre d'occurence de 3 est : "+l3.nbOccurence(l3,3));
       System.out.println("le nombre d'occurence de 3 est : "+l3.nbOccurenceRec(l3,3));
       System.out.println("le max est " + l3.nbMax(l3));
       System.out.println("le max est " + l3.nbMaxRec(l3));
       l.un_sur_deux(l);
       l.un_sur_deuxRec(l);
       System.out.println();
       /*System.out.println("est ce que l est croissante "+ l.verifierCroissance(l));
       System.out.println("est ce que l est croissante "+ l.verifierCroissanceRec(l));
       System.out.println("est ce que l3 est croissante "+ l.verifierCroissance(l3));
       System.out.println("est ce que l3 est croissante "+ l.verifierCroissanceRec(l3));
       l.afficherInverse(l);
       System.out.println("----------------------------");
       l.afficherInverseRec(l);*/
       System.out.println("la position du premier element negatif est "+l3.rechercheElementNeg(l3));
       List sous = List.sous_list_rec(l3);
       sous.afficher(sous);
       int [] tab1 = {3,4,2,5,7,6,8,9};
       List l5 = List.convertirLSC(tab1);
       int [] tab2 ={2,7,6,9};
       List l6 = List.convertirLSC(tab2);
       System.out.println(List.contient(l5,l6));
       int [] tab3 = {1,2,3};
       List l7 = List.convertirLSC(tab3);
       int [] tab4 ={3,2,1};
       List l8 = List.convertirLSC(tab4);
       System.out.println(List.contient(l7,l8));
       List l9 = List.concatener(l5, l6);
       l9.afficher(l9);
   }
}
