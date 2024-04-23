package src;
import java.util.ArrayList;
import java.util.Random;

public class Moteur {


    /*
     * Renvoie une valeur aleatoire pour une position saisie .
     */
    public static Integer[] aleatoire(Board board){
        Random random=new Random();
        int coup = random.nextInt(board.getLegalMoves().size());
        return board.getLegalMoves().get(coup) ;
    }


    /*
     * Fait une évaluation de la position actuelle du tableau,
     * renvoyant un entier représentant le score.
     */
    public static int evaluate(Board board) {
        int score = 0;
        int color = board.getTurn();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int piece = board.getPiece(i, j);

                // Ajoute un point si la pièce est de la même couleur, soustrait sinon :
                score += piece * color;

            }
        }
        return score;
    }


    /*
     * Renvoie une valeur heuristique pour une position saisie, par rapport à la
     * couleur de maximisation.
     */
    public static int minimax(Board board, int depth, int maximizingColor) {
        if (depth == 0) {
            return evaluate(board); // Renvoie l'évaluation du nœud final.
        }

        Board b = board.copy();
        int value;

        // Si c'est au tour de la couleur entrée (maximisation) de se déplacer.
        if (maximizingColor == b.getTurn()) {
            value = -100000;
            ArrayList<Integer[]> legals = b.getLegalMoves();
            // Jouez tous les coups possibles et donnez au joueur suivant la couleur qui
            // maximise..
            for (int i = 0; i < legals.size(); i++) {
                Integer[] move = legals.get(i);
                b.playMove(move);
                value = Math.max(value, minimax(b, depth - 1, -maximizingColor));
            }
            return value;
        }

        // Si c'est au tour (minimisant) de l'adversaire de se déplacer.
        else {
            value = 100000;
            ArrayList<Integer[]> legals = b.getLegalMoves();
            // Jouez tous les coups possibles et donnez au joueur suivant la couleur qui
            // maximise.
            for (int i = 0; i < legals.size(); i++) {
                Integer[] move = legals.get(i);
                b.playMove(move);
                value = Math.min(value, minimax(b, depth - 1, -maximizingColor));
            }
            return value;
        }
    }

    /*
     * Utilise la fonction minimax pour déterminer le meilleur coup pour
     * l'ordinateur.
     */
    public static Integer[] meilleurCoup(Board board) {
        Board b = board.copy();
        Integer[] meilleurCoup = new Integer[2]; // pour stocker les coordonnées de meilleursCoup

        int max = -10000;
        int maximizingColor = board.getTurn();

        ArrayList<Integer[]> legals = b.getLegalMoves();
        
            for (int i = 0; i < legals.size(); i++) {
                // Jouez chaque coup légal.
                Integer[] move = legals.get(i);
                b.playMove(move[0], move[1]);

                // Effectuez l'appel minimax et mettez à jour les variables en conséquence.
                if (minimax(board, 5, maximizingColor) > max) {
                    meilleurCoup[0] = move[0];
                    meilleurCoup[1] = move[1];
                    //Si le score obtenu est supérieur au score maximum actuel, elle met à jour les coordonnées du meilleur coup (meilleurCoup[0] = move[0]; meilleurCoup[1] = move[1];) et met à jour le score maximum (max = b.count(maximizingColor);)
                    max = b.count(maximizingColor);
                }

                // Annulez le mouvement afin que la même position soit utilisée pour le
                // mouvement suivant.
                b.annuler();
            }
        

        return meilleurCoup;
    }

}