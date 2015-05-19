package lab.one;

public final class LinkedBag<T> implements IBag<T> {
    private Node firstNode;
    private int numberOfEntries;
    
    public LinkedBag() {
	firstNode = null;
	numberOfEntries = 0;
	//end of default constructor
    }
    
    private class Node {
	private T data;
	private Node next;

	private Node(T dataPortion) {
	    this(dataPortion, null);
	    //end constructor for Node
	}

	private Node(T dataPortion, Node nextNode) {
	    data = dataPortion;
	    next = nextNode;
	    //end constructor
	}

	private T getData() {
	    return data;
	}//get data

	private void setData(T newData) {
	    data = newData;
	}//set data

	private Node getNextNode() {
	    return next;
	}//get next node

	private void setNextNode(Node nextNode) {
	    next = nextNode;
	}//set next node

    }//end of Node

    public int getCurrentSize() {
	return numberOfEntries;
    }

    public boolean add(T newEntry) {
	//Adds to begining of Node chain
	Node newNode = new Node(newEntry);
	newNode.next = firstNode;
	firstNode = newNode;
	numberOfEntries++;
	return true;
    }//end of add

    public T[] toArray() {
	/**This retrieves the contents of the bag */
	@SuppressWarnings("unchecked")
	    T[] result = (T[])new Object[numberOfEntries];
	int index = 0;
	Node currentNode = firstNode;
	while ((index < numberOfEntries) && (currentNode != null))
	    {
		result[index] = currentNode.data;
		index++;
		currentNode = currentNode.next;
	    }
	return result;
    }//end of array

    public int getFrequencyOf(T anEntry){
	int frequency = 0;
	int loopCounter = 0;
	Node currentNode = firstNode;
	while((loopCounter < numberOfEntries) && (currentNode != null)){
	    if(anEntry.equals(currentNode.data))
		frequency++;
	    loopCounter++;
	    currentNode = currentNode.next;
	}
	return frequency;
    }//end of get frequency

    public boolean contains(T anEntry){
	boolean found = false;
	Node currentNode = firstNode;
	while(!found && (currentNode != null))
	    {
		if(anEntry.equals(currentNode.data))
		    {
			found = true;
		    }
		else
		    {
			currentNode = currentNode.next;
		    }
	    }
	return found;
    }//end of contains

    private Node getReferenceTo(T anEntry){
	boolean found = false;
	Node currentNode = firstNode;
	while(!found && (currentNode != null))
	    {
		if(anEntry.equals(currentNode.data))
		    {
			found = true;
		    }
		else
		    {
			currentNode = currentNode.next;
		    }
	    }
	return currentNode;
    }//end get reference to

    public T remove() {
	T result = null;
	if(numberOfEntries > 0) {
	    result = firstNode.getData();
	    firstNode = firstNode.next;
	    numberOfEntries--;
	}

	return result;
    }

    public boolean remove(T anEntry){
	boolean result = false;
	Node nodeN = getReferenceTo(anEntry);
	if(nodeN != null)
	    {
		nodeN.data = firstNode.data;
		firstNode = firstNode.next;
		numberOfEntries--;
		result = true;
	    }
	return result;
    }//end of remove 
    
    public void clear() {
	while(!isEmpty()) //need check if empty method
	    {
		remove();//need blanket bag wipe
	    }
    }//end of clear

    public boolean isEmpty() {
	boolean empty = false;
	if(getCurrentSize() == 0) {
	    empty = true;
	}
	return empty;
    }
}

