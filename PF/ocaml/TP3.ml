(*EXO 1*)
let first = fun (a,b) -> a ;;
let second = fun (a,b) -> b ;;
(*EXO 2*)
let po_pair = fun (x,y) ->
    if x<y then (x,y) 
    else (y,x);;
(*EXO 3*)
type floatfun = float * float -> bool ;;
let (is_empty:floatfun) = fun (a,b) -> 
    if a > b  then true 
    else false ;;
(*test *) is_empty (1.2 , 3.0);;
(*EXO 4*)
let inclus = fun x -> fun (a,b) -> 
    if x<=b && x >= a then true 
    else false ;;
(*test *)inclus 2.0 (1.2 , 3.0);;

fibonacci 100 ;;

(*EXO_5*)
let intersection = fun (a,b) -> fun (c,d) ->
if a >= c && b <= d then (a ,b)
else if a>c && b>d then (a,d)
else if a<c && b > d then (c,d)
else if a < c && b < d then (c,b)
else (0.,0.);;


(*EXO_6*)
let rec fibonacci_1 = fun x -> 
    if x<2 then 1 
    else fibonacci_1(x-1)+ fibonacci_1(x-2);;

(*EXO_7*)
type intfun = int -> int*int ;;
let rec (fibonacci_2:intfun) = fun x -> 
    if x<2 then (1,1)
    else let (v1,v2) = fibonacci_2 (x-1) in 
    (v2,v1+v2);;
(*EXO_8*)
let applique2 = fun x -> fun f -> f (f x) ;;
(*EXO_9*)
let applique2_2 = fun f -> fun  x -> f (f x) ;;
(*EXO_10*)
let rec applique_n = fun n -> fun f -> fun x -> 
    if n = 0 then x 
    else f (applique_n (n-1) f x );;
(*EXO_11*)
let frac_mul = fun (a,b) -> fun (c,d) -> 
        let x = a*c in 
        let y = b*d in 
        (x,y) ;;
(*EXO_12*)
let frac_add = fun (a,b) -> fun (c,d) -> 
    let x = a*d in 
    let y = c*b in 
    (x+y,b*d) ;;
(*EXO_13*)
let rec pgcd = fun (a ,b) -> 
    if b = 0 then a 
    else pgcd (b,(a mod b));;

    let frac_irr = fun (a,b)->
    let x = a/ pgcd(a,b)
    and y = b/ pgcd(a,b) in 
    if x*y>0 then (abs x,abs y)
else (-abs x, abs y);;
(*EXO_14*)
let frac_eq = fun (a,b) -> fun (c,d)->
if b = 0 || d = 0 then false  
else if (a/b) = (c/d) && a mod b = c mod d then true 
else false ;;

    
    

    