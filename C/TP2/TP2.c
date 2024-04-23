#define __use_MINGW_ANSI_STDIO 1
#define DEGRE_MAX 500
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
 
struct polynomial {
  float          a[DEGRE_MAX + 1];
  unsigned int   degree;
} ;


struct polynomial zero_polynomial() {
    struct polynomial p;
    p.degree = 0 ;
    for (int i = 0; i <= DEGRE_MAX; i++) {
        p.a[i] = 0;
    }
    return p;
}

int main () {
  
  struct polynomial p;
  printf("La taille de p est: %lu bytes\n", sizeof(p));
  /*
  Il faut s'assurer que le degré du polynôme ne dépasse pas la taille maximale définie, sinon cela pourrait causer des erreurs de mémoire
  */

 printf("le poly zero %d ", zero_polynomial());
 return EXIT_SUCCESS;
}
