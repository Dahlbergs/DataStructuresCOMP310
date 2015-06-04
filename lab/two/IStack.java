package lab.two;
/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood
 */
public interface IStack<X> {
	
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
	public int getFrequencyOf(X aValue);
	/** searches stack for a given value
	 * @param aValue value to be searched for
	 * @return true of aValue was found in stack
	 */
	public boolean find(X aValue);
	/** dumps contents of stack to the console **/
	public void dump();
}
