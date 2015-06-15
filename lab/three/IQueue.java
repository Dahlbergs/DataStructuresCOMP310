/** 
    Declares an interface for the queue ADT.  
    @author Robert Blood, Sam Dahlberg, Yves Sabato

*/

package lab.three;

public interface IQueue<T> {
    
    /** Adds an entry to the back of the queue.
	@param anEntry Data to be enqueued.
     */
    public void enqueue(T anEntry);

    /** Pops the first element in the queue.
	@return The first entry. */
    public T dequeue();

    /** @return A copy of the first entry in the queue. */
    public T front();

    /** @return If the queue is empty, true, else false. */
    public boolean isEmpty();

    /** Removes all elements from the queue. */
    public void clear();

    /** @return The number of elements in the queue. */
    public int getSize();
}
