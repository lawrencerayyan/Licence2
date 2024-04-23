package TP2;



public class exo5
{
    
        public static int recherche_dicho(int tab[], int f, int l, int val){
        if (l >= f){
            int mid = f + (l - f)/2;
            if (tab[mid] == val){
                return mid;
            }
            if (tab[mid] > val){
                //recherche dans le sous-tableau à gauche
                return recherche_dicho(tab, f, mid-1, val); 
            }else{
                //recherche dans le sous-tableau à droit
                return recherche_dicho(tab, mid+1, l, val); 
            }
        }
        return -1;
    }

    public static void main(String[] args ){
        int tab[] = {1, 2, 3, 4, 5, 6, 7};
        int val = 4;
        int l = tab.length-1;
        int res = recherche_dicho(tab,0,l,val);  
        if (res != -1)
            System.out.println("L'élément se trouve à l'index: " + res);
        else
            System.out.println("L'élément n'existe pas!");
    }

    // question 2 : tri par fusion

    private static void triFusion(int tableau[],int deb,int fin)
    {
        if (deb!=fin)
        {
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            fusion(tableau,deb,milieu,fin);
        }
    }

    private static void fusion(int tableau[],int deb1,int fin1,int fin2)
    {
        int deb2=fin1+1;

        //on recopie les éléments du début du tableau
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++)
        {
            table1[i-deb1]=tableau[i];
        }

        int compt1=deb1;
        int compt2=deb2;

        for(int i=deb1;i<=fin2;i++)
        {        
            if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
            {
                break; //tous les éléments ont donc été classés
            }
            else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
            {
                tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
            }
            else if (table1[compt1-deb1]<tableau[compt2])
            {
                tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
                compt1++;
            }
            else
            {
                tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
            }
        }
    }

    // question 3 : tri rapide 
    public static void triRapide(int tableau[])
    {
        int longueur=tableau.length;
        triRapide(tableau,0,longueur-1);
    }

    public static void echanger (int [] tab,int i,int j) {
        int temp = tab[i];
        tab[i]=tab[j];
        tab[j]=temp;
    }

    private static int partition(int tableau[],int deb,int fin)
    {
        int compt=deb;
        int pivot=tableau[deb];

        for(int i=deb+1;i<=fin;i++)
        {
            if (tableau[i]<pivot)
            {
                compt++;
                echanger(tableau,compt,i);
            }
        }
        echanger(tableau,deb,compt);
        return(compt);
    }

    private static void triRapide(int tableau[],int deb,int fin)
    {
        if(deb<fin)
        {
            int positionPivot = partition(tableau,deb,fin);
            triRapide(tableau,deb,positionPivot-1);
            triRapide(tableau,positionPivot+1,fin);
        }
    }

}
