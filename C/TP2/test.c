#include <stdio.h>
int main(void){
printf("Bonjour tout le monde");
return 0; 
}

#include <stdint.h>

int64_t m(int64_t n) {
    uint64_t mask = 0x1FFFFFFFFFFFFFFF;  // masque pour les 5 bits de poids forts
    return (n & mask) | (1ULL << 63);    // applique le masque et ajoute 1 au bit de signe
}