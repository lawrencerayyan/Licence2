type jour_semaine = Lundi | Mardi | Mercredi | Jeudi | Vendredi | Samedi | Dimanche;;

let jour_de_week_end = fun x ->
match x with
Samedi | Dimanche -> true
| _ -> false ;;


let nb_jour_avant_week_end = fun x ->
match x with
Lundi -> 5
| Mardi -> 4
| Mercredi -> 3
| Jeudi -> 2
| Vendredi -> 1
| Samedi| Dimanche -> 0 ;;



let jour_suivant = fun x ->
match x with
Lundi -> Mardi
| Mardi -> Mercredi
| Mercredi -> Jeudi
| Jeudi -> Vendredi
| Vendredi -> Samedi
| Samedi -> Dimanche
| Dimanche -> Lundi ;;



let rec jour_apres = fun x y ->
if y<=0 then x
else jour_suivant(jour_apres x (y-1));;



let rec nb_jour_avant_week_end_rec = fun x ->
match x with
| Samedi| Dimanche -> 0
| _ -> (nb_jour_avant_week_end (jour_suivant x)) + 1;;