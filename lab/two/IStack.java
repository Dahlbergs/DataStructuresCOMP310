package lab.two;

/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood, Sam Dahlberg, Yves Sabato
 */

public interface IStack<T> {
	
    /** @return The number of elements in the stack*/
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
    public int getFrequencyOf(T aValue);
	
    /** searches stack for a given value
     * @param aValue value to be searched for
     * @return true of aValue was found in stack
     */
    public boolean find(T aValue);
}
