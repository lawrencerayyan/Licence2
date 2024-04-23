package test;



public class Machin
{
    public String m1 , m2 ;
    
   
    public Machin(String m1 , String m2)
    {
       this.m1 = m1 ;
       this.m2 = m2 ;
    }
    
        public String GetM1(){ return m1 ;}
        public String GetM2(){ return m2 ;}
        public void SetM1(String m1){this.m1=m1 ;}
        public void SetM2(String m2){this.m2=m2 ;}
       
    public Machin combiner (Machin x , Machin y ){
        Machin nouveau  = new Machin (x.m1+y.m1 , x.m2+y.m2 );
        return nouveau ;
    }
}
