package base_tp_note;

public class Node
{
    private int info;
    private Node left;
    private Node right;

    public Node(int val)
    {
        this.info = val;
        this.left = null;
        this.right = null;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }

    public int getInfo()
    {
        return info;
    }

    public void  setInfo(int i)
    {
        info = i;
    }
    
    public void setLeft(Node l)
    {
        left = l;
    }

    public void setRight(Node r)
    {
        right = r;
    }
      
    @Override
    public String toString()
    {
        return "->" + this.info;
    }
    
}
