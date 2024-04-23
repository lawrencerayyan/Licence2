val pi : float
val pi2 : float
val pi3 : float
val pi4 : float
type point = float * float
type geom =
  DrawingType.geom =
    Forward of float
  | Turn of float
  | Text of string
type path = geom list
val string_of_point : point -> string
val string_of_geom : geom -> string
val string_of_path : path -> string
val simple_triangle : geom list
val draw : 'a -> geom list
val pi : float
val pi2 : float
val pi3 : float
val pi4 : float
type point = float * float
type geom =
  DrawingType.geom =
    Forward of float
  | Turn of float
  | Text of string
type path = geom/2 list
val string_of_point : point -> string
val string_of_geom : geom/2 -> string
val string_of_path : path -> string
val simple_square : geom/2 list
val pentagone : geom/2 list
val polygone_aux : int -> float -> geom/2 list
val polygone : int -> geom/2 list
val square_spiral_aux : int -> float -> float -> geom/2 list
val square_spiral : int -> float -> geom/2 list
