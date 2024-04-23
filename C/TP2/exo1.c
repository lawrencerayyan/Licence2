#define __use_MINGW_ANSI_STDIO 1
#include <limits.h>
#include <stdlib.h>
#include <stdio.h>
#include <float.h>
#include <stdio.h>
#include <stdlib.h>
 
int main () {
//   printf("Size of char: %lu\n", sizeof(char));
//   printf("Signed char min/max: %hhd/%hhd\n", CHAR_MIN, CHAR_MAX );
//   printf("Unsigned char min/max: %hhu/%hhu\n", 0, UCHAR_MAX );
//   printf("Size of short: %lu\n", sizeof(short));
//   printf("Signed short min/max: %hd/%hd\n", SHRT_MIN, SHRT_MAX );
//   printf("Unsigned short min/max: %hu/%hu\n", 0, USHRT_MAX );
//   printf("Size of int: %lu\n", sizeof(int));
    // printf("Signed int min/max: %d/%d\n", INT_MIN, INT_MAX );
//   printf("Unsigned int min/max: %u/%u\n", 0, UINT_MAX );
//   printf("Size of long: %lu\n", sizeof(long));
//   printf("Signed long min/max: %ld/%ld\n", LONG_MIN, LONG_MAX );
//   printf("Unsigned long min/max: %lu/%lu\n", 0L, ULONG_MAX );
//   printf("Size of llong: %lu\n", sizeof(long long)); 
//   printf("Signed llong min/max: %lld/%lld\n", LLONG_MIN, LLONG_MAX );
//   printf("Unsigned llong min/max: %llu/%llu\n", 0LL, ULLONG_MAX );
  printf("Min/Max value of a float: %.5g/%.5g\n", FLT_MIN, FLT_MAX);
  
//   int entiers[10] = { 0, -0, -1, 11, 96, 4567, -255, 582, 2147483700, 4294967416 };
//   for (int i = 0; i < 10; i++)
//   {
//     printf("  %d  " , entiers[i]);
//   }
//   printf("\n");
//    for (int i = 0; i < 10; i++) {
//         printf("%u ", (unsigned int)entiers[i]); // %u : format d'affichage pour des entiers non signés
//     }
//     printf("\n");

//     for (int i = 0; i < 10; i++) {
//         printf("%o ", entiers[i]);  // %o : format d'affichage pour des entiers en base octale
//     }
//     printf("\n");

//     for (int i = 0; i < 10; i++) {
//         printf("%x ", entiers[i]);  // %x : format d'affichage pour des entiers en base hexadécimale (minuscules)
//     }
//     printf("\n");

//     for (int i = 0; i < 10; i++) {
//         printf("%X ", entiers[i]);  // %X : format d'affichage pour des entiers en base hexadécimale (majuscules)
//     }
//     printf("\n");
//      for (int i = 0; i < 10; i++) {
//         printf("%c ", entiers[i]);  // %c : format d'affichage pour des caractères
//     }
//     printf("\n");



double flottants[12] = { 0.0,
			 -0.0,
			 123456123456123456,
			 1234561234561234561234,
			 1234561234561234561234.0,
			 0.123456123456123456123456,
			 0.000123456123456123456123456,
			 0.000000123456123456123456123456,
			 0.0000000000000123456123456123456123456,
			 1.23456123456123456123456e-14,
			 1.23456123456123456123456e-128,
			 1.23456123456123456123456e-324 };

        printf("repesente F \n");
     for (int i = 0; i < 11; i++) {
        printf("%f \n", flottants[i]);  // %f : format d'affichage pour les nombres flottants en notation décimale
    }
    printf("_______________\n");

        printf("repesente 10F \n");
    for (int i = 0; i < 12; i++) {
        printf("%.10f \n", flottants[i]);  // %.10f : format d'affichage pour les nombres flottants en notation décimale avec 10 chiffres après la virgule
    }
    printf("_______________\n");

        printf("repesente e \n");
    for (int i = 0; i < 11; i++) {
        printf("%e \n", flottants[i]);  // %e : format d'affichage pour les nombres flottants en notation scientifique (ex: 1.23e-4)
    }
    printf("_______________\n");

        printf("repesente E \n");
    for (int i = 0; i < 11; i++) {
        printf("%E \n", flottants[i]);  // %E : format d'affichage pour les nombres flottants en notation scientifique avec des majuscules (ex: 1.23E-4)
    }
    printf("_______________\n");

        printf("repesente g \n");
    for (int i = 0; i < 11; i++) {
        printf("%g \n", flottants[i]);  // %g : format d'affichage pour les nombres flottants en utilisant la notation la plus courte entre %f et %e
    }
    printf("_______________\n");

        printf("repesente G \n");
    for (int i = 0; i < 11; i++) {
        printf("%G \n", flottants[i]);  // %G : format d'affichage pour les nombres flottants en utilisant la notation la plus courte entre %f et %E
    }
    printf("_______________\n");
  
  return EXIT_SUCCESS;
}