package test;


/**
 * Décrivez votre classe X ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class X
{
   
private double a = 2;
private double b = 5;

public X() {
}

public X(double a, double b) {
this.a = a;
this.b = b;
}

public X(final X x) {
this(x.a, x.b);
}

// Après les instructions suivantes, quelles seont les valeurs des attributs de x3 et x4?
X x1 = new X();
X x2 = new X(3, 7);
X x3 = new X(x1);
X x4 = new X(x2);
}

