<<<<<<< HEAD
package lab.two;
import java.util.*;

public class Stack<X> implements IStack<X> {
	protected Node head;
	protected int numberOfNodes;
	
	public Stack(){
		numberOfNodes = 0;
	}
	
	public void toConsole(){
		X[] stringDump = toArray();
		for(int i = 0; i < stringDump.length; i++){
			System.out.println("Position " + i + "Contents: " + stringDump[i]);
		}
	}

	public X[] toArray(){
		Node currentNode = head;
		int index = 0;
		X[] goingTo = X[]new Object[numberOfNodes];
		for(index < numberOfNodes){
			goingTo[index] = nextNode.data;
			i++;
			currentNode = currentNode.next;
		}
		return goingTo;
	}

	protected class Node {
		
		protected X data;
		/** The next node in the list*/
		protected Node next;
		
		protected Node(X aValue){
			this(aValue, null);
		}
		
		protected Node(X aValue, Node nextNode){
			data = aValue;
			next = nextNode;
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
		newNode.next = head;
		head = newNode;
		numberOfNodes++;
	}
	@Override
	public X pop() {
		Node temp = head; 
		head.next = head;
		numberOfNodes--;
		return temp.getData();
	}
	@Override boolean isEmpty(){
		if(getCurrentize == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
=======
<<<<<<< HEAD
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

>>>>>>> 9804771ee2bbc9fd7f703a83cae08238192e2d1f
