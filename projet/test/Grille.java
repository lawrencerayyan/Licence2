
/**
 * Décrivez votre classe Grill ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.Scanner;
public class Grille
{
    public static final int WIDTH= 8 ; 
    public static final int HEIGHT= 8 ; 
    public static final int BLACK = 1 ;
    public static final int WHITE = 2 ;
    public static final int NONE = 0 ;

     static Scanner s = new Scanner(System.in) ;
    

    private static int [][] grille_jeu ;
    private int [][] grille_calcule ;
    
    public Grille()
    {
           
        }
    
    
    public static void main(String[]args){
    
    Grille j = new Grille();
    
   // int n = s.nextInt();

    j.CreateGrille_jeu();
    affichage(grille_jeu);

   /* boolean p1Turn = true;
    while(n > 0) {
        int x = s.nextInt();
        int y = s.nextInt();
        boolean ans = false;
        if(p1Turn) {
            ans = s.move(BLACK, x, y);
        }
        else {
            ans = s.move(WHITE, x, y);
        }
        if(ans) {
            s.print();
            p1Turn = !p1Turn;
            n--;
        }
        else {
            System.out.println(ans);
        }
    }*/

    }    
        
        
    /**
     * la grille de jeu
     */
    public  void CreateGrille_jeu(){
    grille_jeu = new int [HEIGHT][WIDTH];
        for(int i = 0 ; i < HEIGHT ; i++ ){
            for(int j = 0 ; j < WIDTH; j++){
                // inisalsier toute les case à vide
                grille_jeu[i][j] = NONE ;
            }x 
        }
        // insialiser les case de milieu comme demander 
        grille_jeu[3][3] = BLACK; 
        grille_jeu[3][4] = WHITE;
        grille_jeu[4][3] = WHITE;
        grille_jeu[4][4] = BLACK;

    }
    
    /**
     * la grille où on fait le calcule pour le IA
     */
    public void CreateGrille_calcule(){
    grille_jeu = new int [HEIGHT][WIDTH];
        for(int i = 0 ; i < HEIGHT ; i++ ){
            for(int j = 0 ; j < WIDTH; j++){
                grille_jeu[i][j] = NONE ;
            }
        }

        grille_jeu[3][3] = BLACK; 
        grille_jeu[3][4] = WHITE;
        grille_jeu[4][3] = WHITE;
        grille_jeu[4][4] = BLACK;

    }
    
    /**
     * on affiche l'arene
     */
     public static void affichage(int arene[][]) {
        for (int i = 0; i < arene.length; i++) {
            for (int j = 0; j < arene.length; j++) {
                if (i == 0 && j == 0) System.out.print("   ");
                else if (i == 0 && j < 10) System.out.print(j + "  ");
                else if (i == 0 && j > 9) System.out.print(j + " ");
                else if (j == 0 && i > 0) {
                    if (i < 10) System.out.print(i + "  ");
                    else if (i > 9) System.out.print(i + " ");
                } else if (j < 11) System.out.print(arene[i][j] + "  ");
                else if (j > 9) System.out.print(arene[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /*public static void print(int board) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    /*public boolean move(int symbol, int x, int y){
        if(x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] != 0){
            return false;
        }
        boolean movePossible = false;
        for(int i = 0; i < xDir.length; i++){
            int xStep = xDir[i];
            int yStep = yDir[i];
            int currentX = x + xStep;
            int currentY = y + yStep;
            int count = 0;
            // count of opponent's pieces encountered 
            while(currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8){
                // Empty cell 
                if(board[currentX][currentY] == 0){
                    break;
                }
                else if(board[currentX][currentY] != symbol){
                    currentX += xStep;
                    currentY += yStep;
                    count++;
                }
                else{
                    // conversion is possible 
                    if(count > 0){
                        movePossible = true;
                        int convertX = currentX - xStep;
                        int convertY = currentY - yStep;
                        while(convertX != x || convertY != y){
                            board[convertX][convertY] = symbol;
                            convertX = convertX - xStep;
                            convertY = convertY - yStep;
                        }
                    }
                    break;
                }
            }
        }
        if(movePossible){
            board[x][y] =symbol;
        }
        return movePossible;
    }*/
}
