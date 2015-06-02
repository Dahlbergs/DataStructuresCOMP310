package lab.two;

public class Stack<X> implements IStack<X> {
	protected Node head;
	protected int numberOfNodes;
	
	public Stack(){
		numberOfNodes = 0;
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
	@Override
	public void dump() {
		// TODO Auto-generated method stub
	}

}
