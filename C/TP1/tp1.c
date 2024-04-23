#define __use_MINGW_ANSI_STDIO 1
#include <stdlib.h>
#include <stdio.h>
 
 void exo1(){
      setbuf(stdout,NULL);
  int    prod_num[3] = { 23, 42, 0 };
  char*  prod_name[3] = { "muffins", "cookies", "croissant" };
  int    id = -1;
  printf("Entrez un identifiant de produit : \n");
  scanf("%d", &id);
  if (id >= 3) {
    printf("Cet identifiant n'existe pas.\n");
    return EXIT_FAILURE;
  }
  printf("Il reste %d %s en stock.\n", prod_num[id], prod_name[id]);
  return EXIT_SUCCESS;
 }

int main() {
    setbuf(stdout,NULL);
//   int    prod_num[3] = { 23, 42, 0 };
//   char*  prod_name[3] = { "muffins", "cookies", "croissant" };
//   int    id = -1;
//   printf("Entrez un identifiant de produit : \n");
//   scanf("%d", &id);
//   if (id >= 3) {
//     printf("Cet identifiant n'existe pas.\n");
//     return EXIT_FAILURE;
//   }
//   printf("Il reste %d %s en stock.\n", prod_num[id], prod_name[id]);
//   return EXIT_SUCCESS;
    int tailletab ;
    
    printf("Entrez la Taille du tableau : \n");
    scanf("%d", &tailletab);
    
    int tab [tailletab];
    int lenth = sizeof(tab);
    for (int i = 0; i < lenth ; i++)
    {
        int valeur ;
        printf("Entrez la %i valeur : \n", %i);
        scanf("%d", &valeur);
        tab[i]= valeur ;
       if (tab[i] == 0) {
        printf("l'indice où e trouve la premiere 0 est %d",tab[i]);
       }
    }
    return EXIT_SUCCESS;
}
