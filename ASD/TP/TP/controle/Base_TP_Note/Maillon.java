package base_tp_note;



class Maillon 
{
    private int info;
    private Maillon next;

    public Maillon(int val)
    {
        this.info = val;
        this.next = null;
    }

    public Maillon(int val, Maillon next)
    {
        this.info = val;
        this.next = next;
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
