package lab.one;

/** An interface that defines appropriate operations on a bag type data struct.
    @author Sam Dahlberg
*/
public interface IBag<T> {

    /** @return The integer number of items in the bag. */
    public int getCurrentSize();  
    
    /** @return True if bag is empty, else false */
    public boolean add(T newEntry);
    
    /** Removes an unspecfied item from the bag 
	@return The removed item or null */
    public T remove();
    
    /** Removes a single occurance of the specified item from the bag
	@param anItem The item to be removed.
	@return The item that was removed or null; */
    public boolean remove(T anItem);

    /** Removes all items from the bag */
    public void clear();
    
    /** Counts the number of specifed items in the bag.
	@param anItem The item to be counted.
	@return The integer number of specifed items. */
    public int getFrequencyOf(T anItem);
    
    /** Tests if the specified item is present in the bag.
	@param anItem The item to be tested.
	@return True if the item is present, else false. */
    public boolean contains(T anItem);
    
    /** Collects all entries in the bag into an array.
	@return A new array allocated with all the items in the bag,
	        or an empty array if no items are present. */
    public T[] toArray();

}
