include DrawingType

(*Q1*)
let inverse geom =
match geom with
Forward n -> Forward (_. n)
| Turn n -> Turn (_.n)
| Text t -> Text t

let apply_draw = fun i f l ->
i :: f(inverse i :: l)
(*Q2*)
let rec dragon_left = fun n d l->
if(n<=0) then Forward d :: l
else Turn (pi4) ::
(dragon_right (n-1) (d*. (sqrt(2.)/. 2.)) (Turn (-.pi4) ::
Turn (-. pi4) ::
(dragon_left (n-1) (d*. (sqrt(2.)/. 2.)) (Turn pi4 :: l) ) ) )
and
dragon_right = fun n d l->
if (n<=0) then Forward d :: l
else
Turn (-.pi4) :: (dragon_right (n-1) (d*. (sqrt(2.)/. 2.))
(Turn pi4 :: Turn pi4 :: (dragon_left (n-1) (d*. (sqrt(2.)/.2.))
(Turn (-.pi4) :: l) ) ) )

let draw = fun n ->
dragon_right n 10. []

type 'a arbre = Feuille | Noeud of 'a arbre * 'a * 'a arbre

let rec tree_of_list_comb = fun arbre->
match arbre with
t :: [] -> Noeud(Feuille,t,Feuille)
| t :: q -> Noeud(Feuille,t, tree_of_list_comb q)
|[] -> Feuille

let rec size s = match s with
Feuille -> 0
| Noeud(flift,_,fright) -> 1 + (size flift) + (size fright)