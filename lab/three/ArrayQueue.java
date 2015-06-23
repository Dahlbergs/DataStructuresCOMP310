/** Represents a queue that depends on a circular array as the data storage
    mechanism.
    @author Robert Blood, Sam Dahlberg, Yves Sabato
*/

package lab.three;

public class ArrayQueue<T> implements IQueue<T> {

    protected static final int DEFAULT_ARRAY_SIZE  = 100;
    protected int arraySize;

    protected int frontIndex;
    protected int backIndex;

    protected T[] queueArray;

    /** Default constructor */
    public ArrayQueue() {
	this(DEFAULT_ARRAY_SIZE);
    }

    /** Constructor with capacity*/
    public ArrayQueue(int initialCapacity) {
	@SuppressWarnings("unchecked")
	T[] tempArray = (T[]) new Object[initialCapacity + 1];
	queueArray = tempArray;
	frontIndex = 0;
	backIndex = initialCapacity;
    }
    
    /** Adds the given element to the back of the queue 
	@param anEntry The element to be added */
    public void enqueue(T anEntry) {
	ensureCapacity();
	backIndex = (backIndex + 1) % queueArray.length;
	queueArray[backIndex] = anEntry;
    }

    /** Removes the given element from the front of the queue
	@return The removed element */
    public T dequeue() {
	T front = null;

	if(!isEmpty()) {
	    front = queueArray[frontIndex];
	    queueArray[frontIndex] = null;
	    frontIndex = (frontIndex + 1) % queueArray.length;
	} else {
	    System.out.println("Queue Empty");
	}
	return front;
    }

    // /** Removes a entry from at a particular index and shifts elements to fill gap 
    // 	@param index The index of the underlying array to remove from
    // 	@return The element removed from the queue */
    // public T remove(int index) {
    // 	if(index 
    // 	T temp = 
    // }g

    /** @return A copy of the front element in the queue */
    public T front() {
	return queueArray[frontIndex];
    }

    /** @return A copy of the back element in the queue */
    public T back() {
	return queueArray[backIndex];
    }

    /** @return True if empty, else false */
    public boolean isEmpty() {
	return frontIndex == ((backIndex +1) % queueArray.length);
    }

    /** Ensures the queue has enough room for the next element. If the
	queue would be full, double the size */
    private void ensureCapacity() {
	if(frontIndex == ((backIndex + 2) % queueArray.length)) {
	    System.out.println("Doubling the size of the array");
	    T[] oldQueue = queueArray;
	    int oldSize = oldQueue.length;
	    
	    int newSize = oldSize * 2;
	    
	    @SuppressWarnings("unchecked")
	    T[] tempQueue = (T[]) new Object[newSize];
	    queueArray = tempQueue;
	    for (int i = 0; i < oldSize - 1; i++) {
		queueArray[i] = oldQueue[frontIndex];
		frontIndex = (frontIndex + 1) % oldSize;
	    }

	    arraySize = newSize;
	    frontIndex = 0;
	    backIndex = oldSize - 2;
	    
	}
    }

    /** Removes all elements from the queue */
    public void clear() {
	while(!isEmpty()) {
	    this.dequeue();
	}
    }

    /** @return The size of the array */
    public int getSize() {
	if(queueArray[frontIndex]  == null) {
	    return 0;
	}
	int size = Math.abs(Math.abs(arraySize - frontIndex) - Math.abs(arraySize - backIndex));
	return size;
    }

    public static void main(String args[]) {
	ArrayQueue<Integer> intQueue = new ArrayQueue<Integer>();
	
	Integer entry = 1;
	Integer entry2 = 2;
	Integer entry3 = 3;

	for(int i = 0; i < 150; i++ ) {	    
	    intQueue.enqueue(i);
	}

	for(int i = 0; i < 151; i++) {
	    System.out.println(intQueue.dequeue());
	    System.out.println("Size: " + intQueue.getSize());
	    
	}	
	
	intQueue.clear();		
	
    }
    
}
