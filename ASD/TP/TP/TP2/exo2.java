package TP2;



public class exo2
{
    static int n1= 0; 
    static int n2 = 1 ; 
    static int n3=0;   
    
    public static void Fibonacci(int count)
    {
        
        if(count>0){
            n3 = n2 + n1 ;
            n1=n2;
            n2=n3;
            System.out.println(" "+ n3);
            Fibonacci(count-1);
        }
    }
    
    public static int Fibo_Terminal(int n, int res1, int res0) {
        int res= res1 + res0;
        if (n==0) {
            return res0;
        }
        return Fibo_Terminal(n-1, res, res1);
    }
   
}
