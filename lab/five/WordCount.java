import java.util.Scanner;
import java.io.*;

public class WordCount {
 
  private Hashtable table;

  public WordCount(String fileName, int tableSize) {
    this.table = new Hashtable(tableSize);
    // now load the words from the file
    try {
      load(fileName);
    } catch (IOException e) {
      System.out.println("Error: could not load file " + fileName);
      System.exit(0);
    }
  }

  // this function loads the words into the internal hashtable
  private void load(String fileName) throws IOException {
    Scanner in = new Scanner(new File(fileName));
    while (in.hasNext()) {
      String word = in.next();
      // convert the word into lower cases
      // so the count of words does not consider the cases
      word = word.toLowerCase();
      this.table.insert(word);
    }
    in.close();
  }

  public Hashtable getHashtable() {
    return this.table;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    // ask the user to enter the text file name
    System.out.print("Enter the name of the file to count words: ");
    String fileName = in.nextLine().trim();

    System.out.print("Enter the size of the hashtable: ");
    int size = in.nextInt();
    System.out.println();

    // construct the word counter to count
    WordCount wc = new WordCount(fileName, size);
    Hashtable table = wc.getHashtable();
    table.display();

    // print statistics
    System.out.println();
    System.out.println("Table Size:   " + table.getSize());
    System.out.println("Collisions:   " + table.getNumCollisions());
    System.out.println("Used Entries: " + table.getUsedEntries());
    System.out.println("Average Chain Length: " + table.getAverageChainLength());
    System.out.println("Longest chain Length: " + table.getWorstChainLength());
  }

}

