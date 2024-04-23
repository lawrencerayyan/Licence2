package src;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

public class GameLoader {

  public static void loadGameFromFile(String filePath) {

    String x = JOptionPane.showInputDialog("Entrer le nom du fichier : ");
    // Scanner scanner3 = new Scanner(System.in);
    String fileName = x; // On demande le nom du fichier
    JOptionPane.showMessageDialog(null, "Chargement en cours...");

    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".txt"));
      Board board3 = (Board) ois.readObject(); // On charge la partie
      JOptionPane.showMessageDialog(null, "Chargement terminé");
      Graphique game = new Graphique(board3);
      game.run(); 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erreur : Fichier introuvable ou inexistant");

    }
  }

}