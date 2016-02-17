package lab.two;

import java.util.*;

public class Stack<T> implements IStack<T> {
	protected Node head;
	protected int numberOfNodes;
	
	public Stack(){
		numberOfNodes = 0;
	}
	
	public void toConsole(){
		T[] stringDump = toArray();
		for(int i = 0; i < stringDump.length; i++){
			System.out.println("Position " + i + "Contents: " + stringDump[i]);
		}
	}

	public T[] toArray(){
		Node currentNode = head;
		int index = 0;
		T[] goingTo = (T[]) new Object[numberOfNodes];
		
		while(index < numberOfNodes){
		    goingTo[index] = nextNode.data;
		    i++;
		    currentNode = currentNode.next;
		}
		return goingTo;
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
	@Override
	public int getCurrentSize() {
		return numberOfNodes;
	}
	@Override
	public void push(T aValue) {
		Node newNode = new Node(aValue, head);
		newNode.next = head;
		head = newNode;
		numberOfNodes++;
	}
	@Override
	public T pop() {
		Node temp = head; 
		head.next = head;
		numberOfNodes--;
		return temp.getData();
	}
	@Override
	    public  boolean isEmpty(){
		if(getCurrentize == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
