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

}

