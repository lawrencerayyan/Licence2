#include <stdio.h>
#include <stdlib.h>

typedef struct regexp_s regexp_t;
struct regexp_s {
    int parent_count;   // nombre de parents de l'expression régulière
    enum { EMPTY, EPSILON, LETTER, UNION, CONCAT, STAR } type;
    union {
        char letter;        // lettre (type LETTER)
        struct {
            regexp_t *left;  // sous-expression régulière gauche (type UNION et CONCAT)
            regexp_t *right; // sous-expression régulière droite (type UNION et CONCAT)
        };
        regexp_t *exp;      // sous-expression régulière (type STAR)
    };
};

regexp_t* regexp(void) {
    regexp_t *r = malloc(sizeof(regexp_t));
    r->parent_count = 0;
    return r;
}

regexp_t* regexp_empty(void) {
    regexp_t *r = regexp();
    r->type = EMPTY;
    return r;
}

regexp_t* regexp_epsilon(void) {
    regexp_t *r = regexp();
    r->type = EPSILON;
    return r;
}

regexp_t* regexp_letter(char c) {
    regexp_t *r = regexp();
    r->type = LETTER;
    r->letter = c;
    return r;
}

regexp_t* regexp_plus(regexp_t *l, regexp_t *r) {
    regexp_t *res = regexp();
    res->type = UNION;
    res->left = l;
    res->right = r;
    l->parent_count++;
    r->parent_count++;
    return res;
}

regexp_t* regexp_concat(regexp_t *l, regexp_t *r) {
    regexp_t *res = regexp();
    res->type = CONCAT;
    res->left = l;
    res->right = r;
    l->parent_count++;
    r->parent_count++;
    return res;
}

regexp_t* regexp_star(regexp_t *r) {
    regexp_t *res = regexp();
    res->type = STAR;
    res->exp = r;
    r->parent_count++;
    return res;
}

void delete_regexp(regexp_t *r) {
    if (r->parent_count != 0) {
        printf("Erreur: expression régulière avec des parents\n");
        return;
    }
    switch (r->type) {
        case LETTER:
            free(r);
            break;
        case UNION:
        case CONCAT:
            delete_regexp(r->left);
            delete_regexp(r->right);
            free(r);
            break;
        case STAR:
            delete_regexp(r->exp);
            free(r);
            break;
        default:
            free(r);
    }
}

void print_regexp(regexp_t *r) {
    switch (r->type) {
        case EMPTY:
            printf("<empty>");
            break;
        case EPSILON:
            printf("<epsilon>");
            break;
        case LETTER:
            printf("%c", r->letter);
            break;
        case UNION:
            printf("(");
            print_regexp(r->left);
            printf(" + ");
            print_regexp(r->right);
            printf(")");
            break;
        case CONCAT:
            printf("(");
            print_regexp(r->left);
            printf(".");
            print_regexp(r->right);
            printf(")");
            break;
        case STAR:
            printf("(");
            print_regexp(r->exp);
            printf(")*");
            break;
    }
}

int main() {
 
    // RegExp: (a + b)*ab(a + b)*   
 
    regexp_t* r =
        regexp_concat(
            regexp_star(regexp_plus(regexp_letter('a'), regexp_letter('b'))),
            regexp_concat(
                regexp_concat(regexp_letter('a'), regexp_letter('b')),
                regexp_star(regexp_plus(regexp_letter('a'), regexp_letter('b')))
            )
        );
 
    print_regexp(r); prl; prl;
 
    const char* test[4] = { "", "ab", "aaabbb", "bbaa" };
    size_t i;
    for(i = 0; i < 4; i++)
        printf("'%s': %s\n", test[i], recon_regexp(r, test[i]) ? "true" : "false");
 
    delete_regexp(r);
 
   return EXIT_SUCCESS;
}