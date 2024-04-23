
(*EXO3*)
let rec rebour = fun x -> 
    if x=0 then [0]
   else x ::  rebour (x-1);;

  (*EXO4*)
  let rec compteur_aux = fun n i ->
    if n<1 then []
   else  if i=n then [n][]
    else i :: compteur_aux n (i+1);;
let compteur = fun x ->compteur_aux x 1;;
(*EXO5*)
let head = fun x -> match x with 
    [] -> -1 
    | a :: c -> a ;;
(*EXO6*)
    let tail = fun x -> match x with 
    [] -> []
    |t :: q -> q ;;
(*EXO7*)
let head_opt = fun x ->match x with 
    []-> None 
    | t :: q -> Some t ;;
(*EXO8*)
let tail_opt = fun x ->match x with 
    []-> None 
    | t :: q -> Some q ;;
(*EXO9*)
let rec cmp_firsts_aux = fun f n i-> 
 if n<1 then []
else if n=i then [f i]
 else  f i :: cmp_firsts_aux f n (i+1);;

 let cmp_firsts = fun f x -> cmp_firsts_aux f x 1;;

(*EXO10*)
 let rec compteur_aux = fun n i ->
    if n<1 then []
   else  if i=n then [n]
    else i :: compteur_aux n (i+1);;
let compteur = fun x ->compteur_aux x 1;;

let rec cmp_firsts_aux = fun f n i-> 
 if n<1 then []
else if n=i then [f i]
 else  f i :: cmp_firsts_aux f n (i+1);;

 let cmp_firsts = fun f x -> cmp_firsts_aux f x 1;;
 
 let cmp_all = fun x -> cmp_firsts compteur x;;

 (*EXO11*)
 let is_letter = fun x -> 
    let f = int_of_char x in
    if f >=65 && f<= 90 || f>=97 && f<=122 then true
    else false;;


    let is_capital = fun x -> 
    let f = int_of_char x in
    if f >=65 && f<= 90  then true
    else false;;

let to_lower_case = fun x ->
    if is_lettre x then 
        if is_capital x then
        let f = int_of_char x + 32 in
        let s = char_of_int f in s
        else " "^x
    else '_';;




let rec check_letter_aux =  fun s -> fun l
let l = String.length s in
  if l = 0 then false
  else
    if not (is_letter s.[0]) then false
    else
      if l = 1 then true
      else check_letter_aux  (String.sub s 1 (l-1));;
let check_letter = fun x ->check_letter_aux x ;;
//////////
let caml_of_spilt = fun s -> 
if not(check_letter s )then ""
else check_letter_capital(s);;
let rec check_letter_capital =  fun s ->
let l = String.length s in
    if not (is_capital s.[0]) then s.[0]
    else
      if l = 1 then  to_lower_case(s.[1])
      else check_letter_capital  (String.sub s 1 (l-1));;



      let to_lower_case = fun x ->
          let f = int_of_char x + 32 in
          let s = char_of_int f in s;;
          
          " "^String_of_char
////////////code 13 
let rec caml_to_split_aux = fun s -> fun i->
 if i >= String.length s then ""
else if is_capital (String.get s i) && i = 0 then Char.escaped (to_lower_case (String.get s i)) ^ caml_to_split_aux s (i+1)
else if is_capital (String.get s i) then " " ^ Char.escaped (to_lower_case (String.get s i)) ^ caml_to_split_aux s (i+1)
else Char.escaped (String.get s i) ^ caml_to_split_aux s (i+1)


let caml_to_split = fun s ->
 if check_letter s then caml_to_split_aux s 0
 else "";;

 //////// code 14

 

let rec caml_to_split_list_aux = fun s -> fun i -> fun l ->
if i >= String.length s then l::[]
else if is_capital (String.get s i) && i = 0 then caml_to_split_list_aux s (i+1) (Char.escaped (to_lower_case (String.get s i)))
else if is_capital (String.get s i) then l::caml_to_split_list_aux s (i+1) (Char.escaped (to_lower_case (String.get s i)))
else caml_to_split_list_aux s (i+1) (l ^ Char.escaped (String.get s i));;

let caml_to_split_list = fun s ->
if s = "" || check_letter s = false then []
else caml_to_split_list_aux s 0 "" ;;
