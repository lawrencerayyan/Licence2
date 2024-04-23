package Avant_CC2;

class Auteur implements Comparator
{
    private String name;
    private Date birthdate;
    public Auteur(String  name, Date bdate );
    public String getName() { return this.name; }
    public Date getBirthdate() { return this.birthdate; }
    public boolean compare ( Auteur a ) { return compare(this,  a); } // définie dans un comparator
}