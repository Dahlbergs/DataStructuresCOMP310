package lab.one;

public class LinkedBag<T> implements IBag<T> {
    protected Node firstNode;
    protected int numberOfEntries;

    /** Default constructor*/
    public LinkedBag() {
	firstNode = null;
	numberOfEntries = 0;
	//end of default constructor
    }
    
    /** Private class which represents a single node in the linked list
	implementation */
    protected class Node {
	protected T data;
	protected Node next;
	
	/** Constructor which takes a single generic item T and set's it as the first node 
	 @param dataPortion The item to be contained in the Node*/       
	protected Node(T dataPortion) {
	    this(dataPortion, null);
	    //end constructor for Node
	}
	
	/** Constructor which adds the first node to the front of the list and sets
	    the next node the the given value
	    @param dataPortion The data to be given to the first node
	    @param nextNode The node that is next in the linked list */
	protected Node(T dataPortion, Node nextNode) {
	    data = dataPortion;
	    next = nextNode;
	    //end constructor
	}
	
	/** Gets the value of the data conatined in the node
	    @return The data stored in the node */
	protected T getData() {
	    return data;
	}//get data
	
	/** Sets the data in the current node
	    @param newData The data which replaces the old data in the node */
	protected void setData(T newData) {
	    data = newData;
	}//set data
	
	/** Gets the next node in the Linked List
	    @return The next node in the list */
	protected Node getNextNode() {
	    return next;
	}//get next node
	
	/** Sets the next node in the list
	    @param nextNode The node to be set to NextNode in the chain */
	protected void setNextNode(Node nextNode) {
	    next = nextNode;
	}//set next node

    }//end of Node

    /** Gets the current size of the LinkedBag
	@return The size of the bag. */
    public int getCurrentSize() {
	return numberOfEntries;
    }

    /** Adds a new node to the chain which contains the data of generic type T
	@param newEntry The data to be stored in a new node
	@return True if data was succesfuly added */
    public boolean add(T newEntry) {
	//Adds to begining of Node chain
	Node newNode = new Node(newEntry);
	newNode.next = firstNode;
	firstNode = newNode;
	numberOfEntries++;
	return true;
    }//end of add

    /** Gathers all nodes and adds all pieces of data into a contigous array
	@return An arrau of all pieces of data stored in the LinkedBag */
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

    /** Measures the number of times an item is present in the LinkedList 
	@param anEntry The piece of data to be checked
	@return The number of times that piece of data is present in the chain*/
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

    /** Indicates whether a particular piece of data is present in the chain
	@param anEntry The piece of data to test against
	@return True if the data is present, false if not */
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

    /** Gets a refernce to the node specified
	@param anEntry The node to get the data for
	@return The node reference for the specified entry */
    protected Node getReferenceTo(T anEntry){
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

    /** Arbitrarily removes a node from the chain, most efficient method is to remove the last
	entry.
	@return Returns the entry removed from the chain */
    public T remove() {
	T result = null;
	if(numberOfEntries > 0) {
	    result = firstNode.getData();
	    firstNode = firstNode.next;
	    numberOfEntries--;
	}

	return result;
    }

    /** Removes a specific entry from the chain
	@param anEntry The entry/node to be removed
	@return True if item was removed succesfully, false if not*/
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
    
    /** Removes all items from the LinkedBag, regardless of data */
    public void clear() {
	while(!isEmpty()) //need check if empty method
	    {
		T temp = remove();//need blanket bag wipe
	    }
    }//end of clear

    /** Tells if the bag contains an item or not
	@return True if no items, false if there are items */
    public boolean isEmpty() {
	boolean empty = false;
	if(getCurrentSize() == 0) {
	    empty = true;
	}
	return empty;
    }
    
}

