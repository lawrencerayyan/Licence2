type expr =
    Number of int
  | Variable of string
  | Minus of expr
  | Add of expr * expr
  | Multiply of expr * expr
val ex : expr
val string_of_expr : expr -> string
val ex : expr
val eval_simple : expr -> int
val ex : expr
val eval_complex : expr -> expr
val find_space : string -> int -> int
val toknize_aux : string -> int -> int -> string list
val toknize : string -> int -> string list list
val is_space : char -> bool
val caml_to_split_list_aux : string -> int -> string -> string list
val tokenize : string -> int -> string list
val toknize : string -> int -> int -> string
val toknize_2 : string -> int -> int -> string list
val toknize_aux : string -> int -> string list
val is_capital : char -> bool
val caml_to_split_list_aux : string -> int -> string -> string list
val tokenize_aux : string -> int -> string list
