package lab.two;

/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood
 */
public interface IStack<T> {
	
	public int getCurrentSize();
	/** push to the end of the stack
	 * @return the current stack size
	 */
	public void push(T aValue);
	/** pop last elements off stack
	 * @return the last value of the stack
	 */
	public T pop();
	/** get frequency of given value
	 * @param aValue to find frequency of
	 * @return number of occurrences
	 */
	public boolean isEmpty();

	public T[] toArray();
}
