(*TD_1*)
let ajoute_num s i = s^" "^ string_of_int i;;
ajoute_num "u-pec" 3;;
let sqrt x = sqrt x ;;
let distance (x1,y1) (x2,y2) = sqrt((x2-.x1)*.(x2-.x1) +. (y2-.y1)*.(y2-.y1));;
let appartienDisque (x,y) r = distance (x,y) (0.,0.)>= r ;;
appartienDisque (2.,3.) 4. ;;
let sgn f = if f>0. then 1 
  else if f = 0. then 0 
  else -1 ;;
sgn (-1.)  ;;
let abs i =  sgn (float_of_int i) * i ;;

(*TD_2*)
let pow7 i = i* (i*i) *(i*i)*(i*i);;
let xor b1 b2 = if (b1=true &&b2=false) ||(b1=false &&b2=true) then true 
  else false ;;
let perimetre longueur largeur = 2.*. (longueur+.largeur);;
perimetre 3. 2.;;

let arg_max3 x y r z= if x>y && x> z && x>r then 1
  else if  y > x && y > z && y>r then 2 
  else if z> x && z>y &&z>r then 3 
  else 4 ;;
arg_max3 3 2 4;;
let scalaire  (x1,y1) (x2,y2) = (x2*.x1)+.(y2*.y1);;
let proj_diag (x,y) = scalaire (x,y) (sqrt 2. /. 2. , sqrt 2. /. 2.);;
let opp_abs x = abs x * -1;;
let x i = i * i ;; 
let opp_succ i = x i  * -1 ;;
let f x = x*x ;;
let opp_fct f x = f x * -1 ;;
let min_arg2 f x = if f x < x then 1 else 2 ;;
let applique2 f x = f (f x) ;;

(*TD_3*)

let rec puissance1  x i = 
  if i= 0 then 1.
  else if i>0 then x*. puissance1 x (i-1)
  else (puissance1 x (i+1))/.x;;

let rec factorial n = 
  if n=1 then 1 
  else n* factorial (n-1);;
let rec stars i = 
  if i= 0 then ""
  else "*" ^ stars (i-1);;
let rec compte_a_rebour i = 
  if i= 0 then "0"
  else string_of_int i^" "^ compte_a_rebour (i-1);;

let rec compteur i = 
  if i = 1 then "1"
  else compteur (i-1)^" "^string_of_int i;;

let rec  sum_firsts i = 
  if i = 1 then 1 
  else i+ sum_firsts (i-1);;


let rec  fsum_firsts f i = 
  if i=1 then f 1 
  else f i+ fsum_firsts f (i-1);;

let f i = string_of_int i;;
let rec fcat_firsts f i =
  if i=1 then  f 1
  else fcat_firsts f (i-1)^" "^f i ;;

let rec  retourne_aux s i = 
  if i <0 then ""
  else 
let sr = retourne_aux (i-1) s in 
let c =   String.get sr i in 
(Char.escaped c) ^sr ;;

let rec retourne_aux = fun s -> fun n ->
  if n <0 then ""
  else 
    let sr = retourne_aux s (n-1) in
    let c = String.get s n in
    (Char.escaped c)^sr;;

retourne_aux "upec" 4;;    

let retourne = fun s ->
  retourne_aux s ((String.length s)-1);;

retourne "upec";;

let rec nb_occurence_aux = fun c -> fun s -> fun n ->
  if n<0 then 0
  else let noa = nb_occurence_aux c s (n-1) in
    if (String.get s n) = c then 
      1 + noa
    else  noa;;

nb_occurence_aux 't' "toto" 1;;

let nb_occurence = fun c -> fun s ->
  nb_occurence_aux c s ((String.length s)-1);;

nb_occurence 't' "toto";;

type fintint = int -> int;;

let (f:fintint)  = fun x -> x+1;;

f 3;;

let couple = (1,3.4);;

fun x -> (x,2);;

type pt = float*float

let add_pt = fun ((x1,y1):pt) -> fun ((x2,y2):pt) ->
  ( (x1+.x2, y1+.y2):pt);;

add_pt (1.0,0.0) (0.0,1.0)   

let mult_scalaire = fun k -> fun ((x,y):pt) ->
  ((k*.x,k*.y):pt)

(* cc *)

(*EXO1 *)
let sgn = fun x -> 
  if x < 0.0 then -1 
  else is x = 0.0 then 0 
  else -1 ;;
let abs = fun x -> 
  sgn(float_of_int x )* x ;;
let nun (x1,y1) (x2,y2) = max (abs (x2-x1) , abs (y2-y1));;

(*EXO 2*)

(*EXO 3*)
let b f a = 
  if a = f then Some abs
  else None ;;
(*EXO 4*)
let ftostring i = 
  if i mod 2 = 0 && i mod 3 = 0 then "upecfst"
  else if i mod 3 = 0 then "fst"
  else if i mod 2 = 0 then "upec"
  else string_ofint i
  let = Printf.printf "%s\n" (ftostring 12)
(*EXO 5*)
let rec binom n k =
  if k = n then 1
  else if k > n then 0
  else binom (n+1)(k+1) - binom n (k+1)
  j sais pas si elle est juste
  q6
  let f (a,b) g n = n
(*EXO 6*)

(*EXO 7*)
let rec fix_point f a = 
  if f a = a then a 
  else fix_point f (f a)
(*EXO 8*)
let rec string_of_float_list l = match l with 
| [] -> []
|e::y -> [string_of_float e]
la q9 pour moi c'est aucun des deux
pou la q10 c'est la reponse c je crois
(*EXO 9*)

(*EXO 10*)

(*EXO 11*)
let safe_first_char s = 
  if String.length s = 0 then None
  else Some Char.escaped(s.[0])
(*EXO 12*)
let rec find f n = 
  if i > n then None
  else if f i = true then Some i