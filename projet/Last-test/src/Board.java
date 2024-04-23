package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Board implements Serializable {
    private int[][] table;
    // -1 represente Blanc
    // 1 represente Noir
    private int turn = 1; // Noir commence la partie
    private ArrayList<int[][]> history; // utilisé pour annuler le déplacement et faire de copie
    private int[][] offsets = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, // carré Adjacent
            { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } // carré Diagonal
    };

    /*
     * "https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println"
     */
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\033[0;97m";
    private static final String ANSI_BLACK = "\033[0;90m";

    private String player = ANSI_WHITE + "W " + ANSI_RESET; // Human Player
    private String AI = ANSI_BLACK + "B " + ANSI_RESET;
    private String emptySpace = "  ";

    public Board() {
        table = new int[8][8]; // le tableau est de 8 x 8
        // Initialize les case avec les position de début

        table[(table.length / 2) - 1][(table.length / 2)] = -1;
        table[(table.length / 2)][(table.length / 2) - 1] = -1;
        table[(table.length / 2) - 1][(table.length / 2) - 1] = 1;
        table[(table.length / 2)][(table.length / 2)] = 1;

        // table[3][4] = -1;
        // table[4][3] = -1;
        // table[3][3] = 1;
        // table[4][4] = 1;

        history = new ArrayList<int[][]>();
        savePosition(table); // Ajouter la position du tableau initial à l'history
    }

    /*
     * Ajouter un copie du tableau indiquer au tableau de l'history
     * on l'utilise à chaque coup jouer
     */
    public void savePosition(int[][] position) {
        int[][] indiquer = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                indiquer[i][j] = position[i][j];
            }
        }
        history.add(indiquer);
    }

    /*
     * Renvoie la pièce au carré spécifié.
     */
    public int getPiece(int row, int col) {
        return table[row][col];
    }

    /*
     * Définit le carré de la grille avec la couleur de pièce spécifiée.
     */
    public void setPiece(int pieceColor, int row, int col) {
        if (table[row][col] == 0) {
            table[row][col] = pieceColor;
        }
    }

    /*
     * Renvoie le turn actuel.
     */
    public int getTurn() {
        return turn;
    }

    /*
     * Définit turn actuel à l'entier saisi.
     */
    public void setTurn(int monTour) {
        turn = monTour;
    }

    /*
     * Définit la position sur la grille saisie.
     */
    public void setPosition(int[][] grid) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.table[i][j] = grid[i][j];
            }
        }
    }

    /*
     * Retourner la piéce (changer de couleur).
     */
    public void flip(int row, int col) {
        table[row][col] *= -1;
    }

    /*
     * Renvoie true si la case indiquée se trouve dans le tableau, false sinon.
     */
    public boolean dansLeTableau(int row, int col) {
        return (row >= 0 && row <= 7) && (col >= 0 && col <= 7);
    }

    /*
     * Renvoie vrai si la case indiquée est vide, sinon faux.
     */
    public boolean estVide(int row, int col) {
        return table[row][col] == 0;
    }

    /*
     * Modifie le tour en cours pour représenter le joueur suivant.
     * Si le joueur suivant n'a aucun mouvement légal, le jeu revient au joueur
     * actuel.
     */
    public void incrementTurn() {
        turn *= -1;
        if (getLegalMoves().size() == 0) {
            turn *= -1;
        }
    }

    /*
     * Renvoie toutes les cases du plateau qui ont été occupées.
     */
    public boolean estRempli() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (table[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Renvoie le nombre de pièces de la couleur spécifiée.
     */
    public int count(int color) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (table[i][j] == color) {
                    num++;
                }
            }
        }
        return num;
    }

    /*
     * Renvoie 1 si les noirs gagnent à la position actuelle.
     * Renvoie -1 si les blancs gagnent à la position actuelle.
     * Renvoie 0 si la partie n'est pas terminée.
     */
    public int gameOver() {
        // Lorsque toutes les cases sont occupées.
        if (estRempli()) {
            // si Il y a plus de pièces blanches que de pièces noires
            if (count(-1) > count(1)) {
                return -1;
            }
            // Il y a plus de pièces noires que de pièces blanches
            return 1;
        }
        // Si les deux joueurs ne peuvent pas bouger :
        if (getLegalMoves().size() == 0) {
            turn *= -1;
            if (getLegalMoves().size() == 0) {
                turn *= -1;
                // Compter la majorité
                if (count(-1) > count(1)) {
                    return -1;
                }
                return 1;
            }
        }
        return 0;
    }

    /*
     * Vérifie si l'un des carrés directement adjacents ou en diagonale
     * d'un carré spécifié contient une couleur spécifiée.
     */
    public boolean LeVoisineContient(int target, int row, int col) {
        for (int[] offset : offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if (dansLeTableau(newRow, newCol) && table[newRow][newCol] == target) {
                return true;
            }
        }
        return false;
    }

    /*
     * Renvoie une liste de tous les coups légaux possibles pour le joueur actuel.
     * Chaque mouvement légal sera un tableau d'entiers d'une longueur de 2 pour
     * contenir la ligne et la colonne.
     * Une ArrayList est utilisée car le nombre de mouvements légaux possibles
     * change avec la position.
     */
    public ArrayList<Integer[]> getLegalMoves() {
        ArrayList<Integer[]> legalMoves = new ArrayList<Integer[]>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (estVide(i, j) && LeVoisineContient(-turn, i, j)) {
                    // Carré possible identifié, parcourez maintenant les lignes, les cols et les
                    // diagonales pour vérifier si c'est légal
                    for (int[] offset : offsets) {
                        int newRow = i + offset[0];
                        int newCol = j + offset[1];
                        // Continuez dans le sens du décalage jusqu'à ce qu'un carreau de la même
                        // couleur soit atteint.
                        while (dansLeTableau(newRow, newCol) && table[newRow][newCol] == -turn) {
                            newRow += offset[0];
                            newCol += offset[1];
                        }
                        if (dansLeTableau(newRow, newCol) && table[newRow][newCol] == turn) {
                            if ((newRow == i && Math.abs(newCol - j) > 1) || // Dans la même ligne ?
                                    (newCol == j && Math.abs(newRow - i) > 1) || // Dans le même col?
                                    (Math.abs(newCol - j) > 1 && Math.abs(newRow - i) > 1)) { // Diagonal?
                                legalMoves.add(new Integer[] { i, j });
                                break; // Considérons maintenant la case suivante.
                            }
                        }
                    }
                }
            }
        }
        return legalMoves;
    }

    /*
     * Renvoie true si le mouvement spécifié est légal, false sinon.
     */
    public boolean estLegal(int row, int col) {
        ArrayList<Integer[]> legals = this.getLegalMoves();
        Integer[] move = { row, col };
        for (Integer[] legalMove : legals) {
            if (Arrays.equals(move, legalMove)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Place une pièce sur la case spécifiée si le coup est légal.
     * Retourne les pièces correspondantes qui doivent être retournées.
     * Incrémente le compteur de tours et met à jour l'historique des positions.
     */
    public void playMove(int row, int col) {
        if (this.estLegal(row, col)) {
            this.setPiece(turn, row, col);
            // Identifiez dans quelles cases les pièces doivent être retournées.
            for (int[] offset : offsets) {
                int newRow = row + offset[0];
                int newCol = col + offset[1];
                int count = 1;
                while (dansLeTableau(newRow, newCol) && table[newRow][newCol] == -turn) {
                    newRow += offset[0];
                    newCol += offset[1];
                    count++;
                }
                if (dansLeTableau(newRow, newCol) && table[newRow][newCol] == turn) {
                    // Ligne flippable identifiée, maintenant revenir en arrière et retourner toutes
                    // les pièces de l'adversaire
                    for (int i = 1; i < count; i++) {
                        this.flip(newRow - offset[0] * i, newCol - offset[1] * i);
                    }
                }
            }
            turn *= -1;
            savePosition(table);
            // System.out.println(this); // pour afficher dans le terminal 
        }

    }

    public void playMove(Integer[] move) {
        playMove(move[0], move[1]);
    }

    /*
     * Réinitialise la carte et le compteur de tours.
     */
    public void reset() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = 0;
            }
        }
        table[(table.length / 2) - 1][(table.length / 2)] = -1;
        table[(table.length / 2)][(table.length / 2) - 1] = -1;
        table[(table.length / 2) - 1][(table.length / 2) - 1] = 1;
        table[(table.length / 2)][(table.length / 2)] = 1;

        // table[3][4] = -1;
        // table[4][3] = -1;
        // table[3][3] = 1;
        // table[4][4] = 1;

        turn = 1;
    }

    /*
     * Annule le mouvement précédent pour l'IA.
     */
    public void annuler() {

        history.remove(history.size() - 1);
        setPosition(history.get(history.size() - 1));

        turn *= -1;

    }

    /*
     * Renvoie un nouvel objet plateau avec la même position.
     */
    public Board copy() {
        Board b = new Board();
        b.setPosition(table);
        b.setTurn(turn);
        b.savePosition(table);
        return b;
    }

    /*
     * Renvoie une représentation sous forme de chaîne imprimable du tableau.
     */
    public String toString() {
        String out = "   ";

        for (int i = 0; i < 8; i++) {
            out += (ANSI_RED + "| " + ANSI_YELLOW + i + " " + ANSI_RESET);
        }

        out += "\n   ---------------------------------\n";
        for (int i = 0; i < 8; i++) {
            out += ANSI_YELLOW + i + ANSI_RESET + "  ";
            for (int j = 0; j < 8; j++) {

                out += "| ";

                if (table[i][j] == 1) {
                    out += AI; // Piece Noir
                } else if (table[i][j] == -1) {
                    out += player; // Piece Blanc
                } else {
                    out += emptySpace;
                }
            }
            out += "|";

            out += "\n   ---------------------------------\n";
        }
        return out;
    }
}