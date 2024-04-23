(*Q1 *)
let rec positions_paires l = match l with 
| [] -> [] 
| x::y::t -> x::(positions_paires t)
| x::[] -> [x] 
(*Q2 *)
let rec positions_impaires l  = match l with 
| [] -> []
| x::y::t -> y::(positions_impaires t)
| x::t -> [] 
(*Q3*)

let rec positions_paires l = match l with 
| [] -> [] 
| x::y::t -> x::(positions_paires t)
| x::[] -> [x] 

let rec positions_impaires l  = match l with 
| [] -> []
| x::y::t -> y::(positions_impaires t)
| x::t -> [] 

let coupe l = match l with
  | [] -> ([],[])
  | _::t -> (positions_paires t),(positions_impaires t)

(*Q4*)

let rec fusion l1 l2 = 
  match l1 with 
  |[] -> l2 
  |x::t1 -> let num1 = x in 
  match  l2 with 
  |[] -> l1
  |x::t2 -> let num2 = x in
  if num1 >num2 then num2 :: (fusion l1 t2)
  else num1 :: (fusion t1 l2)

  (*Q5*)
  
let rec trifusion l = match l with 
 |[] -> [] 
 |x::[]-> [x]
 | -> fusion(tri_fusion (position_impaire l )(position_paire l))*