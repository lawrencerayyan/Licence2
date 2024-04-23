package Liste_chainee;

class Maillon 
{
    private int info;
    private Maillon next;
    //private Maillon precedent;

    public Maillon(int val)
    {
        this.info = val;
        this.next = null;
        //this.precedent = null;
    }

    public Maillon(int val, Maillon next)
    {
        this.info = val;
        this.next = next;
        //this.precedent = null;
    }

    public Maillon getNext()
    {
        return next;
    }

    public int getInfo()
    {
        return info;
    }

    public void setNext(Maillon suiv)
    {
        next = suiv;
    }

    @Override
    public String toString()
    {
        return "->"+ this.info;
    }

}
