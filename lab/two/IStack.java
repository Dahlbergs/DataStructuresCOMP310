package lab.two;

/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood, Sam Dahlberg, Yves Sabato
 */

public interface IStack<T> {
	
    /** @return Number of elements in the stack
    public int getCurrentSize();
    
    /** Push to front of the stack
     * @return The current stack size
     */
    public void push(T aValue);
    
    /** Pop first element off stack
     * @return The first element in the stack
     */
    public T pop();
	
    /** Indicate whether the stack is empty or not
	@return True if empty, else false.*/
    public boolean isEmpty();
}

