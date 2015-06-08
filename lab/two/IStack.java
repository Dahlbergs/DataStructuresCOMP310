<<<<<<< HEAD
package lab.two;

/** An interface that defines proper operations for stack type data structures
 	@author Robert Blood, Sam Dahlberg, Yves Sabato */

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
=======
package lab.two;

/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood, Sam Dahlberg, Yves Sabato
 */

public interface IStack<T> {
	
	public int getCurrentSize();
	/** push to the end of the stack
	 * @return the current stack size
	 */
	public void push(X aValue);
	/** pop last elements off stack
	 * @return the last value of the stack
	 */
	public X pop();
	/** get frequency of given value
	 * @param aValue to find frequency of
	 * @return number of occurrences
	 */

>>>>>>> parent of f9fb7e7... Bullshit
}
