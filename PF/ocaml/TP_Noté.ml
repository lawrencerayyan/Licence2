let rec finde_number_aux s  j = 
  if j> String.length s then j 
  else if int_of_char (String.get s j) >=48 && int_of_char (String.get s j)<=57 then j
  else finde_number_aux s (j+1);;
let find_number s i = 
  if i> String.length s then i 
  else finde_number_aux s i;;

find_number "helloevry4b" 3;;


let pow7 = fun n -> 
  let n2 = n*n in 
  let n4 = n2*n2 in
  n*n2*n4;;
pow7 2;;

let rec  fcat_firsts = fun f -> fun  x -> 
  if x = 1 then f 1
  else fcat_firsts f (x-1) ^ f x;;


let g f x = (f x ,x) ;;

type expr = 
  |Val of float 
  |Var of string 
  |Minus of expr 
  | Max of expr * expr 
  | Plus of expr * expr 

let ex = Max ((Add(Number 3,Minus(Variable "y")),Number 5));;
let ex = Plus(Max(Var "x",Val 1.3),Max(Val 7.9,Val 4.1));;
Plus(Max(Var("x"), Val(1.3)), Max(Val(7.9), Val(4.1)))

  Plus(Max(Plus(Var("x"), Val(5.)), Val(3.14)), Max(Val(0.9), Val(1.1)))


let rec string_of_expr  expr = match expr with
    Val i-> (string_of_float i)
  |Var x -> x
  |Max (e1,e2)-> "("^string_of_expr e1^", "^string_of_expr e2^")"
  |Plus (e1,e2)-> "Max("^string_of_expr e1^" + "^string_of_expr e2^")";;
let max a b = if a>=b then a else b;;

type expr = 
  |Val of float 
  |Var of string 
  | Max of expr * expr 
  | Plus of expr * expr 
let ex = Plus(Max(Var "x",Val 1.3),Max(Val 7.9,Val 4.1));;

let rec string_of_expr  expr = match expr with
    Val i-> (string_of_float i)
  |Var x -> x
  |Max (e1,e2)-> "max("^string_of_expr e1^", "^string_of_expr e2^")"
  |Plus (e1,e2)-> "("^string_of_expr e1^" + "^string_of_expr e2^")"
let max a b = if a>=b then a else b;;
let rec eval_simple expr = match expr with 
    Val n ->Some n 
  |Var v -> None
  |Max (e1,e2)-> (match (e1, e2) with
      |(Val n1, Val n2) ->Some Max(max n1  n2)
      |(Val n1 ,Var v) -> None
      |(Var v,Val  n1) -> None
      |(Var v1, Var v2) -> None
      |_ -> Min(eval_complex e1, eval_complex e2))
  |Plus(e1 ,e2)-> (match (e1, e2) with
      |(Val n1, Val n2) -> Some Plus(n1 +. n2)
      |(Val n1 ,Var v) -> None
      |(Var v,Val  n1) -> None
      |(Var v1, Var v2) -> None
      |_ -> Plus(eval_complex e1 +. eval_complex e2));;

let rec replace e1 x e2 = e1

