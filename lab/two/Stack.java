package lab.two;

import two.IStack;
import two.Stack.Node;

public class Stack<T> implements IStack<T> {
    
    /**The first node in the stack */
    protected Node head;
    protected int numberOfNodes;
	
    public Stack(){
    	head = null;
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
		T temp = peek();		
		if (head != null)
			head = head.getNextNode();
			numberOfNodes--;
		
		return temp;
		
	/**Node temp = head; 
	head.next = head;
	numberOfNodes--;
	return temp.getData();*/
    }
	
	public T peek() {
		T temp = null;	
		if(head != null)
			temp = head.getData();
	
		return temp;		
	}
	
	public boolean isEmpty() {	
		return head == null;	
	}
	
	public void clear() {	
		head = null;
	}
}
