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
