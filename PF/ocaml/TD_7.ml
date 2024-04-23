
(*EXO_1*)
let rec somme = fun x -> match x with 
    []-> 0.
    |t :: q -> t+. somme q ;;
    
(*EXO_2*)
  let rec compte = function 
    []-> 0
    |t::q ->if t = true then 1+ compte q
        else compte q;;
  compte [true ; false ;true ;false ;false;true];;
(*EXO_3*)
let rec asso = fun l a-> match l with 
[]-> None
|(v1,v2)::q -> if v1= a then Some v2
else asso q a ;;
asso [(1,2);(2,3);(5,4)] 2 ;;
(*EXO_4*)
let rec div2 = function 
[]-> []
|t::q-> if t mod 2 =0 then t/2::div2 q
else div2 q;;
div2 [2;4;8;5;8;9;5;4;7];;
(*EXO_5*)
let rec filter_map =fun f l ->match l with 
    []->[]
    |t::q -> match f t with 
        None-> filter_map f q
        |Some v -> v::filter_map f q;;
let paire = fun x -> 
if x mod 2 != 0 then  None
else Some x;;
filter_map paire [2;5;4;8;6;7;5;4];;
(*EXO_3*)
(*EXO_3*)
(*EXO_3*)