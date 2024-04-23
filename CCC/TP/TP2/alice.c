
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
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

int pgcd(int a, int b) {
    int temp;
    while (b != 0) {
        temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
void chiffrement_texte(int e, int n, char* fich, char* res) {
    FILE* fichier_in = fopen(fich, "r");
    FILE* fichier_out = fopen(res, "w");
    if (fichier_in == NULL || fichier_out == NULL) {
        printf("Erreur: impossible d'ouvrir le fichier\n");
        return;
    }
    int c;
    while ((c = fgetc(fichier_in)) != EOF) {
        int m = c;
        int c_chiffre = 1;
        for (int i = 0; i < e; i++) {
            c_chiffre = (c_chiffre * m) % n;
        }
        fprintf(fichier_out, "%d\n", c_chiffre);
    }
    fclose(fichier_in);
    fclose(fichier_out);
}

// Fonction auxiliaire pour calculer l'exponentiation modulaire
int expmod(int a, int b, int n) {
    int res = 1;
    while (b > 0) {
        if (b % 2 == 1) {
            res = (res * a) % n;
        }
        a = (a * a) % n;
        b = b / 2;
    }
    return res;
}

void dechiffrement_texte(int p, int q, int d, char chiff[]) {
    // Calcul de n
    int n = p * q;

    // Ouverture du fichier chiffré en lecture
    FILE* fchiff = fopen(chiff, "r");
    if (fchiff == NULL) {
        printf("Erreur lors de l'ouverture du fichier chiffré\n");
        return;
    }

    // Lecture des entiers chiffrés, un par ligne
    int c;
    while (fscanf(fchiff, "%d", &c) == 1) {
        // Déchiffrement de l'entier avec la clé privée
        int m = expmod(c, d, n);
        // Affichage du caractère déchiffré
        printf("%c", m);
    }

    // Fermeture du fichier chiffré
    fclose(fchiff);
}

// Calcul de l'inverse modulaire de a modulo m
int inverse_modulaire(int a, int m) {
    int m0 = m, t, q;
    int x0 = 0, x1 = 1;
    if (m == 1) {
        return 0;
    }
    while (a > 1) {
        q = a / m;
        t = m;
        m = a % m;
        a = t;
        t = x0;
        x0 = x1 - q * x0;
        x1 = t;
    }
    if (x1 < 0) {
        x1 += m0;
    }
    return x1;
}


int generer_nombre_premier() {
    srand(time(NULL)); // Initialisation du générateur de nombres aléatoires
    int n;
    do {
        n = rand() % 1000 + 2; // Génère un nombre aléatoire entre 2 et 1001
    } while (!premier(n));
    return n;
}

int generer_nombre_aleatoire_entre(int a, int b) {
    srand(time(NULL)); // Initialisation du générateur de nombres aléatoires
    return rand() % (b - a + 1) + a; // Génère un nombre aléatoire entre a et b inclusivement
}

void creation_paire_cles(char fich_cle_pub[], char fich_cle_pri[] ) {
    int p, q, n, phi, e, d;
    
    // Génération de p et q
    p = generer_nombre_premier();
    q = generer_nombre_premier();
    
    // Calcul de n et phi
    n = p * q;
    phi = (p - 1) * (q - 1);
    
    // Choix de e (doit être premier avec phi)
    do {
        e = generer_nombre_aleatoire_entre(2, phi - 1);
    } while (pgcd(e, phi) != 1);
    
    // Calcul de d (inverse modulaire de e modulo phi)
    d = inverse_modulaire(e, phi);
    
    // Sauvegarde de la clé publique
    FILE *fpub = fopen(fich_cle_pub, "w");
    fprintf(fpub, "%d\n%d\n", e, n);
    fclose(fpub);
    
    // Sauvegarde de la clé privée
    FILE *fpri = fopen(fich_cle_pri, "w");
    fprintf(fpri, "%d\n%d\n%d\n%d\n", p, q, d, n);
    fclose(fpri);
}

void lecture_cle_pub(char nom_fichier[], int *e, int *n) {
    FILE *fichier = fopen(nom_fichier, "r");
    if (fichier == NULL) {
        printf("Erreur lors de l'ouverture du fichier %s.\n", nom_fichier);
        exit(1);
    }

    // Lecture de la clé publique
    if (fscanf(fichier, "%d\n%d", e, n) != 2) {
        printf("Erreur lors de la lecture de la clé publique dans le fichier %s.\n", nom_fichier);
        exit(1);
    }

    fclose(fichier);
}

int main(){
    char nom_cle_publique[100];
    char nom_fichier_entree[100];
    char nom_fichier_sortie[100];
    int e, n;

    // Lecture de la clé publique
    printf("Entrez le nom du fichier contenant la cle publique : ");
    scanf("%s", nom_cle_publique);
    lecture_cle_pub(nom_cle_publique, &e, &n);

    // Chiffrement du fichier d'entrée
    printf("Entrez le nom du fichier à chiffrer : ");
    scanf("%s", nom_fichier_entree);
    printf("Entrez le nom du fichier de sortie : ");
    scanf("%s", nom_fichier_sortie);
    chiffrement_texte(e, n, nom_fichier_entree, nom_fichier_sortie);

    return 0;
}
