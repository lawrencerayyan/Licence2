(*EXO_1*)
type expr = 
  |Number of int 
  |Variable of string 
  |Minus of expr 
  | Add of expr * expr 
  | Multiply of expr * expr 
  (*EXO_2*)
let ex = Multiply ((Add(Number 3,Minus(Variable "y")),Number 5));;
(*EXO_3*)
let rec string_of_expr  expr = match expr with
    Number i-> (string_of_int i)
  |Variable x -> x
  |Minus m -> "("^ " -"^string_of_expr m^")"
  |Add (e1,e2)-> "("^string_of_expr e1^" + "^string_of_expr e2^")"
  |Multiply(e1,e2)-> "("^string_of_expr e1^" * "^string_of_expr e2^")";;
(*EXO_4*)
let rec eval_simple expr = match expr with 
    Number n -> n 
  |Variable v -> int_of_string v
  | Minus m -> - eval_simple m
  |Add (e1,e2)-> eval_simple e1 + eval_simple e2 
  |Multiply(e1 ,e2)-> eval_simple e1 * eval_simple e2;;
(*EXO_5*)
let rec eval_complex expr =
  match expr with
  | Number n -> Number n
  | Variable s -> Variable s
  | Add (e1,e2) -> (
      match (e1, e2) with
      |(Number n1, Number n2) -> Number (n1 + n2)
      |(Number n1 ,Variable v) -> Add(Number n1, Variable v)
      |(Variable v, Number n1) -> Add(Variable v, Number n1)
      |(Variable v1, Variable v2) -> Add(Variable v1, Variable v2)
      |_ -> Add(eval_complex e1, eval_complex e2))
  |Minus e -> (
      match e with
        Number n -> Number (-n)
      |Minus (Number n)-> Number n
      |Minus (Minus (Number n)) -> Number (-n)
      |_-> Minus (eval_complex e))
  |Multiply(e1,e2) -> (
      match (e1,e2) with
      |(Number n1,Number n2)-> Number(n1*n2)
      |(Number n1, Variable v)-> Multiply(Number n1, Variable v)
      |(Variable v, Number n2)-> Multiply(Variable v, Number n2)
      |(Variable v1, Variable v2)-> Multiply(Variable v1, Variable v2)
      | _-> Multiply(eval_complex e1, eval_complex e2))
(*EXO_6.1*)
let rec find_space s i= 
  if (i >= String.length s) || (String.get s i = ' ') then i else find_space s (i+1)
(*EXO_6.2*)
let rec tokenize_aux s i= 
  if i >= String.length s then []
  else if ((find_space s i) + 1) >= String.length s then (String.sub s i ((find_space s i) - i)) :: []
  else (String.sub s i ((find_space s i) - i)) :: tokenize_aux s ((find_space s i) + 1)
(*EXO_6.3*)
let tokenize s =tokenize_aux s 0 ;;
(*EXO_7*)
let ex2 = Add (Add (Minus (Number 7), (Number 3)), Number 2) ;;



let rec find_space s i = 
  if i>= String.length s then i 
  else if int_of_char (String.get s i) = 32 then i
  else find_space s (i+1);;
find_space "fevrbrgbg" 3;;

(******)
let make_polish_aux1 expr1 str =
  match expr1,str with
  |e1::q,"-" -> Minus(e1)::q
  |l,"" -> Variable ""::l
  |l," " -> Variable " "::l
  |l,x when String.length x > 1 -> Variable x::l
  |l,x when Char.code (String.get x 0) < 48 -> Variable x::l
  |l,x when Char.code (String.get x 0) > 57 -> Variable x::l
  |[],"-" -> raise (Invalid_argument "Impossible a evaluer !")
  |e1::e2::q,"+" -> Add(e1,e2)::q
  |e1::e2::q,"" -> Multiply(e1,e2)::q;;
let rec make_polish_aux2 expr str = match str with
    [] -> expr
  |e::q -> make_polish_aux2 (make_polish_aux1 expr e) q

let make_polish l = make_polish_aux2[] l
let tokenize = fun s -> tokenize_aux s 0
let expr_of_string str =
  match make_polish (tokenize str) with
  |[] -> raise(Ill_formed_expr)
  |t1::t2::q -> raise(Ill_formed_expr)
  |t::q -> t
let compute s = string_of_expr (eval_complex (expr_of_string s));;




