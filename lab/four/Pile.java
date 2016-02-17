/**
   A doubly linked list which must contain Cards or a subclass thereof
   @author Robert Blood, Samuel Dahlberg, Yves Sabato
*/


package lab.four;

public class Pile<T extends Card> {
    protected Node firstNode;
    protected Node lastNode;
    protected int listSize = 0;
    
    protected class Node {	
	protected T data;
	protected Node next;
	protected Node previous;
	
	protected Node(T aValue, Node nextNode, Node previousNode) {
	    data = aValue;
	    next = nextNode;
	    previous = previousNode;
	}
    }//End node class

    /** Adds a new entry to the end of the list 
	@param newEntry The entry to be added
	@return True if add was successful, else false */
    public boolean add(T newEntry) {
	if(getLength() == 0) {
	    firstNode = new Node(newEntry, null, null);
	    lastNode = firstNode;
	    listSize++;
	    // System.out.println("Succesfully added card");
	    return true;
	} else {
	    Node tempNode = new Node(newEntry, null, lastNode);
	    lastNode.next = tempNode;
	    lastNode = tempNode;
	    listSize++;
	    // System.out.println("Succesfully added card");
	    return true;
	}
    }

    /** Adds a new entry to the given position of the list, shifting the existing entry to the right
	@param newPosition Where in the list to add the entry
	@param newEntry The entry to be added
	@return True if add was successful, else false */
    public boolean add(int newPosition, T newEntry) {
	if(newPosition > getLength() + 1) {
	    // System.out.println("Invalid position");
	    return false;
	} else if(newPosition == 0) {
	    firstNode.previous = new Node(newEntry, firstNode, null);
	    firstNode = firstNode.previous;
	    // System.out.println("Succesfully added card");
	    listSize++;
	    return true;
	} else if(newPosition == getLength() + 1) {
	    lastNode.next = new Node(newEntry, null, lastNode);
	    lastNode = lastNode.next;
	    // System.out.println("Successfully added card");
	    return true;
	    
	} else if(newPosition == getLength()) {
	    Node tempNode = new Node(newEntry, null, null);
	    tempNode.next = lastNode;
	    tempNode.previous = lastNode.previous;
	    lastNode.previous.next = tempNode;
	    lastNode.previous = tempNode;
	    	    
	    // System.out.println("Successfully added card");
	    listSize++;
	    return true;
	} else {
	    Node tempNode = firstNode;
	    
	    for(int i = 0; i < getLength(); i++) {
		if(i == newPosition) {
		    tempNode.previous.next = new Node(newEntry, tempNode, tempNode.previous);
		    // System.out.println("Succesfully added card");		    
		    listSize++;
		    return true;		    
		} else {
		    tempNode = tempNode.next;
		}
	    }

	}	
	// System.out.println("Invalid operation");
	return false;
    }

    /** Removes and returns the last node from the chain
	@param givenPosition The position to remove from
	@return the entry removed from the chain */
    public T remove(int givenPosition) {
	Node tempNode = firstNode;

	if(givenPosition > getLength()) {
	    throw new IndexOutOfBoundsException();	    
	} else if(givenPosition == getLength()) {
	    tempNode = lastNode;
	    lastNode = lastNode.previous;
	    lastNode.next = null;	    
	    // System.out.println("Succesfully removed entry");
	    listSize--;
	    return tempNode.data;
	} else if(givenPosition == 0) {
	    tempNode = firstNode;
	    firstNode = firstNode.next;
	    firstNode.previous = null;
	    // System.out.println("Succesfully removed entry");
	    listSize--;
	    return tempNode.data;
	} else {	    
	    for(int i = 0; i <= givenPosition; i++) {
		if(i == givenPosition) {
		    tempNode.previous.next = tempNode.next;
		    tempNode.next.previous = tempNode.previous;
		    // System.out.println("Succesfully removed card");		    
		    listSize--;
		    return tempNode.data;		    
		} else {
		    tempNode = tempNode.next;
		}
	    }	    	    
	}
	
	return lastNode.data;
    }
    
    /** Removes all entries in the list */
    public void clear() {
	firstNode = null;
	lastNode = null;
	listSize = 0;
    }

    /** Replaces the entry at a given position with the entry specified 
	@param givenPostion Where in the list the item to be replaced is
	@param anEntry The entry to replace with
	@return True if replace was successful, else false */
    public boolean replace(int givenPosition, T anEntry) {
	remove(givenPosition);
	add(givenPosition, anEntry);
	
	return true;
    }

    /** Gets a copy of the entry at the given position 
	@param givenPosition The position of the entry to get a copy of
	@return The copy of the entry */
    public T getEntry(int givenPosition) {
	Node tempNode = firstNode;

	if(givenPosition > getLength()){
	    throw new IndexOutOfBoundsException();
	} else {
	    // System.out.println("getEntry::getLength() " + getLength());
	    for(int i = 0; i < getLength(); i++) {
		if(i == givenPosition) {
		    // System.out.println("givenPosition " + givenPosition);
		    // System.out.println("tempNode.data " + tempNode.data);
		    return tempNode.data;
		} 		
		tempNode = tempNode.next;
	    }
	}

	return null;
    }

    // public boolean swap(int indexOne, int indexTwo) {
    // 	if(indexOne > getLength() || indexTwo > getLength()) {
    // 	    System.out.println("Invalid indices");
    // 	    return false;
    // 	} else {
    // 	    T tempCard = getEntry(indexOne);
    // 	    T tempCard2 = getEntry(indexTwo);

    // 	    replace(indexOne, tempCard2);
    // 	    replace(indexTwo, tempCard);
	    
    // 	    System.out.println("Successful swap");
    // 	    return true;
    // 	}
    // }
    
    
    // /** Indicates whether the given entry exists in the list */
    // public boolean contains(T anEntry) {
    // 	return false;
    // }

    /** Gets the length of the linked list */
    public int getLength() {	
	return listSize;
    }

    /** Checks if the list is empty or not */
    public boolean isEmpty() {
	if(listSize == 0) {
	    return true;
	}
	return false;
    }

    // /** Compiles all the data into an array format and gives access to the array */
    // public T[] toArray() {
    // 	return null;
    // }

    public void printContents() {	
	for(int i = 0; i < getLength(); i++) {
	    System.out.println(getEntry(i).toString());
	}
    }

    

    public static void main(String[] args) {
	Card card = new Card(Suit.HEARTS, Face.TEN);
	Card card2 = new Card(Suit.DIAMONDS, Face.FIVE);
	Card card3 = new Card(Suit.SPADES, Face.QUEEN);
	Card card4 = new Card(Suit.CLUBS, Face.JACK);
	Card card5 =  new Card(Suit.DIAMONDS, Face.KING);
	
	Pile<Card> cardPile = new Pile<Card>();
	cardPile.add(card);
	cardPile.add(card2);
	cardPile.add(0, card3);
      	cardPile.add(cardPile.getLength(), card4);

	cardPile.remove(1);

	cardPile.replace(0, card5);
	
	cardPile.printContents();
    }
}
