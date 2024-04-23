package Avant_CC2;


class ExpressionBinaire
{
    private int x;
    private int y;
    private Operator op;

    public ExpressionBinaire( int x, int y , Operator op )
    {
        this.x = x;
        this.y = y;
        this.op = op;
    }

    public int getValue() { return this.op.calcul( this.x, this.y ); }

    @override
    public String toString()
    {
        String r = "";
        r += this.x.toString();
        r += " ";
        r += this.op.getChar();
        r += " ";
        r += this.y.toString();
        return r;
    }
}