
// the hash table implementation
// it uses the seperate chaining strategy to handle collision
public class Hashtable {

  private Node[] entries;

  // statistics about the hashtable
  private int collisions;

  // construct the hashtable with the given size of entries
  public Hashtable(int size) {
    this.entries = new Node[size];
    this.collisions = 0;
  }

  // insert a word into this hashtable
  // if the word already exists in the hashtable, increase its count
  // the word is case sensitive.
  public void insert(String word) {
    int code = hashcode(word);

    Node node = entries[code];
    if (node != null) {
      this.collisions ++;
    }
    // now search in the chaining to check if the word
    // already exists
    while (node != null && !word.equals(node.getKey())) {
      node = node.getNext();
    }

    if (node != null) {
      node.increase(); // increase count of existing word
    } else {
      // add a new node into the chain for new word
      entries[code] = new Node(word, entries[code]);
    }
  }

  // calculate the hashcode of the word
  private int hashcode(String word) {
    int code = 0;
    // use the sum of unicode value of each character
    for (int i = 0; i < word.length(); i++) {
      code += (int)word.charAt(i);
    }

    code = code % entries.length;
    if (code < 0) {
      code += entries.length;
    }
    return code;
  }

  // display the words and their counts in the hashtable
  // hash table does not maintain the words in any particular order
  public void display() {
    for (Node node : entries) {
      while (node != null) {
        System.out.printf("%15s\t%d\n", node.getKey(), node.getValue());
        node = node.getNext();
      }
    }
  }


  // some method for statistics
  public int getNumCollisions() {
    return this.collisions;
  }

  // return the number of used entries in the hashtable
  public int getUsedEntries() {
    int count = 0;
    for (Node entry : entries) {
      if (entry != null) {
        count ++;
      }
    }
    return count;
  }

  // return the average length of the chains 
  public double getAverageChainLength() {
    double count = 0;
    // count the total number of nodes in the table
    for (Node node : entries) {
      while (node != null) {
        count = count + 1;
        node = node.getNext();
      }
    }
    int used = getUsedEntries();
    if (used > 0) {
      return count / used;
    }
    return 0;
  }

  // return the length of the longest chain in the table
  public int getWorstChainLength() {
    int worst = 0;
    for (Node node : entries) {
      int length = 0;
      // calculate the length of this current chain
      while (node != null) {
        length ++;
        node = node.getNext();
      }
      if (length > worst) {
        worst = length;
      }
    }
    return worst;
  }

  // return the number of entries in this hashtable
  public int getSize() {
    return entries.length;
  }
}


// the node class for the hash table
class Node {
  private String key; // word
  private int value;  // count of the word
  private Node next;  // next node in the chain

  public Node(String key, Node next) {
    this.key = key;
    this.value = 1;
    this.next = next;
  }

  // increase the count of this word
  public void increase() {
    this.value ++;
  }

  // accessors
  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }
}

