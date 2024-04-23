package Avant_CC2;

class BaseDocumentaire
{
    private ArrayList<Document> documents = new ArrayList<Document>();
    private int maxSize;
    public BaseDocumentaire(ArrayList<Document> d,int ms) {}

    public void ajout( Document d  ) throws ListFullError

    {

        if ( this.documents.size( ) == maxSize ) throw new ListFullError("La liste est pleine");

        this.documents.add( d );

    }

    public ArrayList<Document> listeLivreAuteur( Auteur a )
    {
        ArrayList<Document> livresAuteur = new ArrayList<Document>();
        for ( int i = 0; i < this.documents.size(); i++  )
        {
            if (auteur.compare( this.documents.get(i), a) )livresAuteur.add( this.documents.get(i));
        }
        return livresAuteur.sort();
    }

    @override
    public String toString()
    {
        String r = "";
        for ( int i = 0; i < this.documents.size(); i++  ) { r+=this.documents.get(i).getTitle();}
        return r;
    }

}
