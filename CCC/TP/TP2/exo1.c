#include <stdio.h>
#include <math.h>

int premier(int n) {
    int i;
    if (n <= 1) {
        return 0; // 0 et 1 ne sont pas des nombres premiers
    }
    for (i = 2; i <= n/2; i++) {
        if (n % i == 0) {
            return 0; // n est divisible par i, donc n n'est pas premier
        }
    }
    return 1; // n est premier
}


int choix_cle_privee(int e, int p, int q) {
    int phi = (p - 1) * (q - 1);
    int d = 1;
    while ((e * d) % phi != 1 || d == e) { // e*d mod phi = 1
        d++;
    }
    return d;
}


int chiffrement(int e, int n, int m) {
    int c = 1;
    for (int i = 0; i < e; i++) {
        c = (c * m) % n; //c = m^e mod n
    }
    return c;
}



int dechiffrement(int d, int n, int c) {
    int m = 1;
    for (int i = 0; i < d; i++) {
        m = (m * c) % n; // m = c^d mod n
    }
    return m;
}
// int main(){
//      int e, p, q, d, n, c, m;
//     printf("Entrez la valeur de e : ");
//     scanf("%d", &e);
//     printf("Entrez la valeur de p : ");
//     scanf("%d", &p);
//     printf("Entrez la valeur de q : ");
//     scanf("%d", &q);
//     printf("Entrez la valeur de n : ");
//     scanf("%d", &n);
//      printf("Entrez la valeur de m : ");
//     scanf("%d", &m);
//     d = choix_cle_privee(e, p, q);
//     printf("La valeur de d est : %d\n", d);

//     c = chiffrement(e, n, m);
//     printf("Le message chiffré est : %d\n", c);

//     m = dechiffrement(d, n, c);
//     printf("Le message déchiffré est : %d\n", m);
// }

// main 4
// int main() {
//     int d, n, c, m;
//     printf("Entrez la valeur de d : ");
//     scanf("%d", &d);
//     printf("Entrez la valeur de n : ");
//     scanf("%d", &n);
//     printf("Entrez la valeur de c : ");
//     scanf("%d", &c);
//     m = dechiffrement(d, n, c);
//     printf("Le message déchiffré est : %d\n", m);
//     return 0;
// }


// main 3 
// int main() {
//     int e, n, m, c;
//     printf("Entrez la valeur de e : ");
//     scanf("%d", &e);
//     printf("Entrez la valeur de n : ");
//     scanf("%d", &n);
//     printf("Entrez la valeur de m : ");
//     scanf("%d", &m);
//     c = chiffrement(e, n, m);
//     printf("Le message chiffré est : %d\n", c);
//     return 0;
// }


// main 2
// int main() {
//     int e, p, q, d;
//     printf("Entrez la valeur de e : ");
//     scanf("%d", &e);
//     printf("Entrez la valeur de p : ");
//     scanf("%d", &p);
//     printf("Entrez la valeur de q : ");
//     scanf("%d", &q);
//     d = choix_cle_privee(e, p, q);
//     printf("La valeur de d est : %d\n", d);
//     return 0;
// }

// main 1
// int main() {
//     int n;
//     printf("Entrez un entier positif: ");
//     scanf("%d", &n);
//     if (premier(n) == 1) {
//         printf("%d est un nombre premier.\n", n);
//     } else {
//         printf("%d n'est pas un nombre premier.\n", n);
//     }
//     return 0;
// }
