package Avant_CC2;

class Addition implements Operator
{
    public char getChar() { return '+'; }
    public int calcul( int x, int y ) { return x + y; }
}
