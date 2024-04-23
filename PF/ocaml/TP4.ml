let first (a,_) = a
let second (_,b) = b
____________________________________
let po_pair (a,b) = if a <=b then (a,b) else (b,a)
____________________________________
let is_empty  (x,y) = if (int_of_float x) <= (int_of_float y) then false else true 
let is_empty (a,b) = a>b
_____________________________________
let inclus a (x,y) = if (int_of_float x) <= (int_of_float a) && (int_of_float a) <=(int_of_float y) then true else false 
____________________________________
let intersection (a,b) (x,y) = if (int_of_float a) >= (int_of_float x) && (int_of_float b) >= (int_of_float y) then ( a, y) 
else if (int_of_float a) >= (int_of_float x) && (int_of_float b) <= (int_of_float y) then ( a, b)
else if (int_of_float a) <= (int_of_float x) && (int_of_float b) >= (int_of_float y) then ( x, y)
else ( x , b)

let intersection (a,b) (c,d) = (max a c) , (min b d)
____________________________________
let rec fibonacci_1 x = if 
  x = 0 || x = 1 then 1 else (fibonacci_1 (x-1)) + (fibonacci_1 (x-2)) 
 ____________________________________
 let rec fibonacci_2 = function 
| 1 -> (1,1)
| n -> let (f_n_2,f_n_1) = fibonacci_2 (n-1) in 
 (f_n_1,f_n_2+f_n_1)
 ____________________________________
 let applique2 x f = f (f x )
 ____________________________________
 let applique2_2 f(x) = f(f x )
 ____________________________________

 let rec applique_n n f x = if n>= 2 then f(applique_n (n-1) f x )
 else if n = 0 then 0 
 else f x 
____________________________________
let frac_mul (a,b) (x,y) = (a*x,b*y)
____________________________________
let frac_add (a,b) (x,y) = ((a*y)+(b*x),b*y)
____________________________________*
let rec pgcd a b = if b = 0 then a  else pgcd b (a mod b)

(*let frac_irr (a,b) = if pgcd (a,b)= 1 && b<0  then (a,-b) else if
                        pgcd (a,b)= 1 && b>0 then (a,b)
                        else if pgcd(a,b)< 0 && b>0 then (a / pgcd(a,b)*(-1) , b / pgcd(a,b)*(-1))
                        else if pgcd(a,b)>0 && b<0 then (a / pgcd(a,b)*(-1) , b / pgcd(a,b)*(-1))
                            else (a / pgcd(a,b) , b / pgcd(a,b)) *)
                            
let frac_irr (a,b) = 
    let g = pgcd a b in
    let n = a/g in
    let d = b/g in
    if(d<0) then (-n,-d)else (n,d)
____________________________________
let frac_eq (a,b) (x,y) = if (a*y=b*x ) then true else false
____________________________________
