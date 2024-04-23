package test;



public class Test
{
     // int visites =10 ;
    private int i;

    
    public Test()
    {
    }
    // public static void main (String [] data){
        // int visites = 5 ; 
        // System.out.println(visites + visites ) ;
    // }
    
    public Test(int i){
    this.i=i ;
    }
    
    public static void printStatic(Test t ) {
        System.out.println(t.i);
    }
    
    public void print(Test t ){
        System.out.println(t.i);
    }
    
    public static void main (String[] args) {
        Test t1 = new Test (3);
        Test.printStatic(t1);
        (new Test ()).print(t1);
    } 
}
