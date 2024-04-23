package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphique extends JFrame implements ActionListener {
    private final int WIDTH = 700;
    private final int HEIGHT = 700;
    private JMenuBar menuBar;
    private JMenu file, game, subMenu;
    private JMenuItem quit, reset, newPlayer, newAI, newAIFacile, save, load;
    private Color bg = new Color(45, 174, 82);
    private Timer timer = new Timer(300, this);;

    private Pion[][] buttonGrid = new Pion[8][8];
    private JPanel buttonPannel = new JPanel();
    private Board board = new Board();
    private boolean playingAgainstAI = false;
    private boolean playingAgainstAIFacile = false;

    public Graphique(Board board) {
        this.board = board;
        // Initialiser les cases dans le bouton Grille
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttonGrid[i][j] = new Pion(this, i, j);
            }
        }
        buttonPannel.setLayout(new GridLayout(8, 8)); // Définissez la disposition du panneau.
        refreshGrid();
        setupMenu();

        // Préférences pour l'interface graphique.
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/photo/othello.png")));
        this.setTitle("Othello");
        this.add(buttonPannel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        this.setLocation(400, 100);
        this.setSize(WIDTH, HEIGHT);
    }

    public void setupMenu() {
        file = new JMenu("File");
        subMenu = new JMenu("New");
        newPlayer = new JMenuItem("Game vs Human");
        newPlayer.addActionListener(this);
        newAI = new JMenuItem("Game vs AI");
        newAI.addActionListener(this);
        newAIFacile = new JMenuItem("Game vs AI Facile");
        newAIFacile.addActionListener(this);
        subMenu.add(newPlayer);
        subMenu.add(newAI);
        subMenu.add(newAIFacile);
        quit = new JMenuItem("Quitter");
        quit.addActionListener(this);
        file.add(subMenu);
        file.add(quit);

        game = new JMenu("Game");
        save = new JMenuItem("Save");
        save.addActionListener(this);
        load = new JMenuItem("Load");
        load.addActionListener(this);
        reset = new JMenuItem("Reset");
        reset.addActionListener(this);

        game.add(reset);
        game.add(save);
        game.add(load);

        menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(game);
        this.setJMenuBar(menuBar);
    }

    public Color getColor() {
        return bg;
    }

    public void refreshGrid() {
        buttonPannel.removeAll();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pion t = new Pion(this, i, j);
                // Si la case est un mouvement légal, mettez-la en surbrillance :
                t.setHighlighted(board.estLegal(i, j));
                // Définissez la case correspondante de l'image sur la bonne pièce
                t.setPiece(board.getPiece(i, j));
                buttonGrid[i][j] = t;
                buttonPannel.add(t);
            }
        }

        // Nécessité de mettre à jour l'interface utilisateur de l'arborescence des
        // composants pour que les modifications prennent effet
        SwingUtilities.updateComponentTreeUI(this);

        // Si le jeu est terminé :
        if (board.gameOver() != 0) {
            timer.setRepeats(false);
            // Afficher le message de qui gagne.
            int text1 = board.count(-1);
            int text2 = board.count(1);
            toString();
            // JOptionPane.showMessageDialog(null, text1, text, text2, null);
            // JOptionPane.showMessageDialog(null, text2);
            String text = board.gameOver() == 1
                    ? "Black wins! " + " \n" + "le Score de player Noir : " + text2 + " \n"
                            + "le Score de player Blanc : " + text1 + " \n"
                    : "White wins! " + " \n" + "le Score de player Noir : " + text2 + " \n"
                            + "le Score de player Blanc :" + text1 + " \n";
            JOptionPane.showMessageDialog(this, text, "Game Over", JOptionPane.INFORMATION_MESSAGE);

            return; // Quitter la fonction
        }
    }

    public void moteurMove() {
        Integer[] meilleurCoup = Moteur.meilleurCoup(board);
        // System.out.println("Moteur score: " + Moteur.evaluate(board));
        board.playMove(meilleurCoup);
        refreshGrid();

    }

    public void moteurMoveNaif() {

        Integer[] meilleurCoup = Moteur.aleatoire(board);
        // board.getLegalMoves();
        // JOptionPane.showMessageDialog(null, board.getLegalMoves());
        board.playMove(meilleurCoup);
        refreshGrid();
    }

    public void onClick(int row, int col) {
        // Si le carré sélectionné est légal :
        if (board.estLegal(row, col)) {
            // int x = Moteur.minimax(board, 5, 1);
            // System.out.println("MinMax Joueur" + x);
            board.playMove(row, col);
            refreshGrid();

            // Si l'utilisateur est dans une partie contre l'IA :
            if (playingAgainstAI) {
                // Dites à l'IA de faire un mouvement :
                timer.setRepeats(false);
                // int y = Moteur.minimax(board, 5, 1);
                // System.out.println("MinMax Ordi" + y);
                timer.start();
            }
            if (playingAgainstAIFacile) {
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public void run() {
        this.setVisible(true);
    }

    public void run(Board board) {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            System.exit(0);
        }

        if (e.getSource() == reset || e.getSource() == newPlayer) {
            board.reset();
            refreshGrid();
            playingAgainstAI = false;
            playingAgainstAIFacile = false;
        }

        if (e.getSource() == save) {
            String m = JOptionPane.showInputDialog("chose a name of your folder");
            Saves.save(m, board);
        }

        if (e.getSource() == load) {
            GameLoader.loadGameFromFile("");
        }

        if (e.getSource() == timer) {
            if (playingAgainstAI) {
                moteurMove();
            } else if (playingAgainstAIFacile) {
                moteurMoveNaif();
            }
            if (board.getTurn() != 1) {
                timer.start();
            }
        }

        if (e.getSource() == newAIFacile) {
            board.reset();
            refreshGrid();
            playingAgainstAI = false;
            playingAgainstAIFacile = true;
        }

        if (e.getSource() == newAI) {
            board.reset();
            refreshGrid();
            playingAgainstAI = true;
            playingAgainstAIFacile = false;
        }

    }
}
