package lab.two;

public class Stack<T> implements IStack<T> {

    /**The first node in the stack */
    protected Node head;
    protected int numberOfNodes;

    public Stack(){
	numberOfNodes = 0;
    }	

    protected class Node {	   
	protected T data;
	/** The next node in the list*/
	protected Node next;		
	
	protected Node(T aValue){
	    this(aValue, null);
	}      	

	protected Node(T aValue, Node nextNode){
	    data = aValue;
	    next = nextNode;
	}

	protected T getData() {
	    return data;
	}
	       
	protected void setData(T aValue) {
	    data = aValue;

	}
		
	protected Node getNextNode() {
	    return next;
	}
		
	protected void setNextNode(Node nextNode) {
	    next = nextNode;
	}
	
    }
    
    public int getCurrentSize() {
	return numberOfNodes;
    }
    
	public void push(T aValue) {
	    Node newNode = new Node(aValue, head);
	    newNode.next = head;
	    head = newNode;
	    numberOfNodes++;
	}
    
	public T pop() {
	    if(!this.isEmpty()) {
	    Node temp = head; 
	    head = head.next;
	    numberOfNodes--;
	    return temp.getData();
	    } else {
		System.out.println("invalid pop");
		return null;
	    }
	}
	
    public boolean isEmpty() {
	if (getCurrentSize() > 0) {
	    return false;
	} else {
	    return true;
	}
    }

    public T top() {
	return head.getData();
    }
    

}

