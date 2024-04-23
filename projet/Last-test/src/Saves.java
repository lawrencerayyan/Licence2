package src;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saves {

  public static void save(String fileName, Board board) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"));
      oos.writeObject(board);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}