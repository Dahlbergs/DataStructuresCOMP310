package lab.two;

/** An interface that defines proper operatins for stack type data structures
 * @author Robert Blood, Sam Dahlberg
 */
public interface IStack<X> {
    

    /** Gets the size of the stack 
	@return the current stack size */
    public int getCurrentSize();
    
    /** Adds a value to the front of the stack
	@param aValue The value to be added */
	public void push(X aValue); 
    
    /** Removes the firest element off the stack
     * @return the first value in the stack */
    public X pop();

    /** get frequency of given value
     * @param aValue to find frequency of
     * @return number of occurrences*/

    public int getFrequencyOf(X aValue);

    /** searches stack for a given value
     * @param aValue value to be searched for
     * @return true of aValue was found in stack*/
    public boolean find(X aValue);

}
