package TP1;


public class PC
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public String nom ;
    public int NDM ;
    public int annee; 
    public float[] IP ;
    public String nom_salle;

    /**
     * Constructeur d'objets de classe PC
     */
    public PC(String nom ,int NDM ,int annee,float[] IP,String nom_salle )
    {
        // initialisation des variables d'instance
       this.nom = nom ;
       this.NDM = NDM ;
       this.annee = annee ;
       this.IP = IP ;
       this.nom_salle = nom_salle ;
    }

    
}
