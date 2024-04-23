class Huffman{
    Noeud racine;
    Noeud[] feuilles;
   // Huffman(String[] car, int [] tabfreq);
   // String codage(String car);
   // String decodage(String code);

   public Huffman(String [] car , int [] tabfreq){
    if (car == null || tabfreq == null || car.length != tabfreq.length ||car.length == 0 ) {
        throw new IllegalArgumentException("Les tableaux d'entrée ne sont pas valides.");
        }

         // Création des feuilles
         int n = car.length;
         feuilles = new Noeud[n];
         for (int i = 0; i < n; i++) {
             feuilles[i] = new Noeud(car[i], tabfreq[i], null, null, null);
         }
          
    }
}
