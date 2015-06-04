package lab.two;

/** Implements the stack data structure 
    @author Robert Blood, Sam Dahlberg */

public class Stack<X> implements IStack<X> {
    // The first element in the stack.
    protected Node head;
    protected int numberOfNodes;
   
    public Stack(){
	head = null;
	numberOfNodes = 0;
    }
    
    //Encapsulates the data into a node of a linked list. 
    protected class Node {
	//Data to be stored in the stack.
	protected X data;
	// The next node in the list.
	protected Node next;
	
	//Default constructor
	protected Node(X aValue){
	    this(aValue, null);
	}
	
	//Creates a stack with two elements.
	protected Node(X aValue, Node nextNode){
	    setData(aValue);
	    setNextNode(nextNode);
	}

	protected X getData() {
	    return data;
	}
	protected void setData(X aValue) {
	   data = aValue;
	}
	protected Node getNextNode() {
	    return next;
	}
	protected void setNextNode(Node nextNode) {
	    next = nextNode;
	}
    }

    @Override
	public int getCurrentSize() {
	return numberOfNodes;
    }

    @Override
	public void push(X aValue) {
	Node newNode = new Node(aValue, head);
	numberOfNodes++;
    }

    @Override
	public X pop() {
	Node temp = head; 
	head.next = head;
	return temp.getData();
    }

    @Override
	public int getFrequencyOf(X aValue) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
	public boolean find(X aValue) {
	// TODO Auto-generated method stub
	return false;
    }
}
