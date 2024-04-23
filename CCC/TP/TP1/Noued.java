class Noeud {
    String car;
    int freq;
    Noeud filsg, filsd, pere;
    
    public Noeud(String car , int freq, Noeud filsg , Noeud filsd , Noeud pere){
        this.car = car ;
        this.freq = freq;
        this.filsg = filsg ; 
        this.filsd = filsd ; 
        this.pere = pere ; 
    }
}
    