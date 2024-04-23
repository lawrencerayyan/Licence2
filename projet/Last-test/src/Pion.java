package src;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Pion extends JButton{
    private int row;
    private int col;
    private Graphique parent;

    public Pion(Graphique parent, int row, int col){
        this.parent = parent;
        this.row = row;
        this.col = col;

        super.setSize(60, 60);
        super.setBackground(parent.getColor()); // Définit l'arrière-plan à partir de la classe Graphique.
        super.setBorder(new LineBorder(Color.BLACK));

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Lorsque le bouton est cliqué, appelle la méthode onClick dans la classe Graphique.
                parent.onClick(row, col); 
            }
            
        });
    }
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public void setPiece(int pieceColor){
        if (pieceColor == 1){
            super.setIcon(new ImageIcon("../Last-test/photo/blackPiece.gif"));
        }
        else if (pieceColor == -1){
            super.setIcon(new ImageIcon("../Last-test/photo//whitePiece.png"));
        }
    }

    public void setHighlighted(boolean mode){
        if (mode){
            super.setBorder(new LineBorder(Color.WHITE));
        }
        else{
            super.setBorder(new LineBorder(Color.BLACK));
        }
    }
}
