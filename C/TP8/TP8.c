// Definition of type regexp_t 
// typedef struct regexp_ regexp_t;
// struct regexp_
// {
//     int nb_parents;
//     enum
//     {
//         EMPTY,
//         EPSILON,
//         LETTER,
//         PLUS,
//         CONCAT,
//         STAR
//     } type;
//     union
//     {
//         char letter;
//         struct
//         {
//             regexp_t *r1;
//             regexp_t *r2;
//         } plus, concat;
//         regexp_t *star;
//     };
// }; 

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define prl { printf("\n"); }

typedef struct regexp_s regexp_t;
struct regexp_s {
    int nb_parents;   // nombre de parents de l'expression régulière
    enum { EMPTY, EPSILON, LETTER, PLUS , CONCAT, STAR } type;
    union {
        char letter;        // lettre (type LETTER)
        struct {
            regexp_t *r1;  // sous-expression régulière gauche (type UNION et CONCAT)
            regexp_t *r2; // sous-expression régulière droite (type UNION et CONCAT)
        }plus, concat;
        regexp_t *star;      // sous-expression régulière (type STAR)
    };
};

// Constructors
regexp_t *regexp()
{
    regexp_t *r = malloc(sizeof(regexp_t));
    r->nb_parents = 0;
    return r;
}
regexp_t *regexp_empty()
{
    regexp_t *r = regexp();
    r->type = EMPTY;
    return r;
}
regexp_t *regexp_epsilon()
{
    regexp_t *r = regexp();
    r->type = EPSILON;
    return r;
}
regexp_t *regexp_letter(char c)
{
    regexp_t *r = regexp();
    r->type = LETTER;
    r->letter = c;
    return r;
}
regexp_t *regexp_plus(regexp_t *l, regexp_t *r)
{
    regexp_t *res = regexp();
    res->type = PLUS;
    res->plus.r1 = l;
    res->plus.r2 = r;
    l->nb_parents++;
    r->nb_parents++;
    return res;
}
regexp_t *regexp_concat(regexp_t *l, regexp_t *r)
{
    regexp_t *res = regexp();
    res->type = CONCAT;
    res->concat.r1 = l;
    res->concat.r2 = r;
    l->nb_parents++;
    r->nb_parents++;
    return res;
}
regexp_t *regexp_star(regexp_t *r)
{
    regexp_t *res = regexp();
    res->type = STAR;
    res->star = r;
    r->nb_parents++;
    return res;
} // Destructor
void delete_regexp(regexp_t *r)
{
    r->nb_parents--;
    if (r->nb_parents == 0)
    {
        switch (r->type)
        {
        case EMPTY:
        case EPSILON:
        case LETTER:
            free(r);
            break;
        case PLUS:
            delete_regexp(r->plus.r1);
            delete_regexp(r->plus.r2);
            free(r);
            break;
        case CONCAT:
            delete_regexp(r->concat.r1);
            delete_regexp(r->concat.r2);
            free(r);
            break;
        case STAR:
            delete_regexp(r->star);
            free(r);
            break;
        }
    }
} // Display
void print_regexp(regexp_t *r)
{
    switch (r->type)
    {
    case EMPTY:
        printf("<empty>");
        break;
    case EPSILON:
        printf("<epsilon>");
        break;
    case LETTER:
        printf("%c", r->letter);
        break;
    case PLUS:
        printf("(");
        print_regexp(r->plus.r1);
        printf(" + ");
        print_regexp(r->plus.r2);
        printf(")");
        break;
    case CONCAT:
        printf("(");
        print_regexp(r->concat.r1);
        printf(").(");
        print_regexp(r->concat.r2);
        printf(")");
        break;
    case STAR:
        printf("(");
        print_regexp(r->star);
        printf(")*");
        break;
    }
} // Functions for recognition
bool nullable_regexp(regexp_t *r)
{
    switch (r->type)
    {
    case EMPTY:
        return false;
    case EPSILON:
        return true;
    case LETTER:
        return false;
    case PLUS:
        return nullable_regexp(r->plus.r1) || nullable_regexp(r->plus.r2);
    case CONCAT:
        return nullable_regexp(r->concat.r1) && nullable_regexp(r->concat.r2);
    case STAR:
        return true;
    }
}
regexp_t *derivate_regexp(regexp_t *r, char a)
{
    if (r == NULL){
        return NULL ;
    }
    switch (r->type)
    {
    case EMPTY:
        return regexp_empty();
    case EPSILON:
        return regexp_empty();
    case LETTER:
        if (r->letter == a)
        {
            return regexp_epsilon();
        }
        else
        {
            return regexp_empty();
        }
    case PLUS:
        return regexp_plus(derivate_regexp(r->plus.r1, a), derivate_regexp(r->plus.r2, a));
    case CONCAT:
        if (nullable_regexp(r->concat.r1))
        {
            return regexp_plus(regexp_concat(derivate_regexp(r->concat.r1, a), r->concat.r2), derivate_regexp(r->concat.r2, a));
        }
        else
        {
            return regexp_concat(derivate_regexp(r->concat.r1, a), r->concat.r2);
        }
    case STAR: return regexp_concat(derivate_regexp(r->plus.r1 ,a),regexp_star(r-> plus.r1));
    default:
    return NULL ;
    }
    }
    
bool recon_regexp(regexp_t* r, const char* w) {
    if (w[0] == '\0')
        return nullable_regexp(r);
    else {
        regexp_t* d = derivate_regexp(r, w[0]);
        bool b = recon_regexp(d, w+1);
        if (d != r) delete_regexp(d);
        return b;
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
