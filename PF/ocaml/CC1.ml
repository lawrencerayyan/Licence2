(*suite fibonnaci f(n+1) = f(n)+1/n+1*)
            let rec  f n = if n = 0 then 0.
            else f(n-1)+.(1./.float_of_int(n))

             let f x y = exp(x*.log(float_of_int (y)))

            let rec un_sur_trois = function
            |[]->[]
            |x::y::z::t -> x::(un_sur_trois t)
            |x::t -> [x]

            let rec pairing = function
              | [] | [] -> []
              | x::y::t -> (x,y) :: (pairing t)

            (* f(n + 1) = cos( f(n) ) - sin( f(n - 1)) *)

          let rec f1 = function
            |0-> (0.,-1.) (* -1 car pas utilisé*)
            |1 -> (0.,0.)
            |n -> let (fn_1,fn_2) = f1 (n-1) in
                  let fn = (cos fn_1) -.(sin fn_2) in
                (fn,fn_1)
