include DrawingType

let simple_triangle =
  let pi23 = 2.0 *. pi /. 3.0 in
  Forward 25.0 :: Turn pi23 ::
  Forward 25.0 :: Turn pi23 ::
  Forward 25.0 :: []

let draw = fun _ -> simple_triangle

include DrawingType
let simple_square =
  let angle = pi /. 2.0 in
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: []

let pentagone =
  let angle = 2.0 *. pi /. 5.0 in
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: Turn angle ::
  Forward 25.0 :: []

let rec polygone_aux = fun n -> fun angle ->
  if n=0 then []
  else Forward 25.0 :: Turn angle :: polygone_aux (n-1) angle

let  polygone n =
  let angle = 2.0*.pi /. float_of_int n in
  polygone_aux n angle

let rec square_spiral_aux = fun n -> fun d -> fun angle ->
  if n=0 then []
  else Forward d :: Turn angle :: square_spiral_aux (n-1) (d*.0.8) angle

let square_spiral  n d =
  let angle = pi /. 2.0 in
  square_spiral_aux n d angle

let rec spiral_log n d angle l =
  if n=0 then l
  else 
    let l2 = Turn (-.angle) :: Forward (-.d) :: l in
    let l3 = spiral_log (n-1) (0.8*.d) angle l2 in
    Forward d :: Turn angle :: l3

let draw  n = 
  let angle = 2.*.pi/.5. in
  let s1 = spiral_log 10 15. (-.angle) [] in 
  let s2 = spiral_log 10  20. angle s1 in 
  let s3 = spiral_log 10  25. (-.angle) s2 in 
  spiral_log 10  30. angle s3;;

let rec tree n d rho l =
      if n=0 then l
      else 
        let l2 = Turn (-.rho) :: Forward (-.d) :: l in
        let l3 = tree (n-1) (0.8*.d) rho l2 in
        let l4 = Forward d :: Turn rho :: l3 in
        let l5 = Turn (rho) :: Forward (-.d) :: l4 in
        let l6 = tree (n-1) (0.8*.d) rho l5 in
        Forward d :: Turn (-.rho) :: l6
        

    let draw n = 
      let s1 = tree n 10.0 (0.2) [] in s1
      