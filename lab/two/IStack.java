package lab.two;

/** An interface that defines proper operations for stack type data structures
 	@author Robert Blood, Sam Dahlberg, Yves Sabato */

public interface IStack<T> {
	
	public int getCurrentSize();
	
	/** push to the end of the stack
	 	@return the current stack size */
	public void push(T aValue);
	
	/** pop last elements off stack
	 	@return the last value of the stack */
	public T pop();
	
	/** get frequency of given value
	 	@param aValue to find frequency of
	 	@return number of occurrences */
	
	
	
	/** retrieve last element of the stack
	   	@return the last value of the stack or null
	 	if empty */
	public T peek();
	
	/** checks for empty stack 
	 	@returns true if stack is empty */
	public boolean isEmpty();
	
	/* remove all entries from stack */
	public void clear();
		
}

