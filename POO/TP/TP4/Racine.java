package TP4;






public class Racine
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private double precision;
    Racine(double precision)
    {
        this.precision = precision;
    }

    double racine(double operande)throws NegatifException 
    {
        double solution, carre, a, b;
        a = 0;
        b = operande;
        if (b<0){
            throw new NegatifException ();
        }
        solution = (a + b) / 2;
        while (b - a > precision)
        {
            carre = solution * solution;
            if (carre > operande) b = solution;
            else a = solution;
            solution = (a + b) / 2;
        }
        return solution;
    }

    double getPrecision() { return precision; }

    void setPrecision(double precision) { this.precision = precision; } 
}
