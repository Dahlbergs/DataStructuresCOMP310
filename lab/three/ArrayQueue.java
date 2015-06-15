/** 
    Represents a queue that depends on a circular array as the data storage
    mechanism.
    @author Robert Blood, Sam Dahlberg, Yves Sabato
*/

package lab.three;

public class ArrayQueue<T> implements IQueue<T> {

    private static final int DEFAULT_ARRAY_SIZE  = 100;
    private int arraySize;

    private int frontIndex;
    private int backIndex;

    private T[] queueArray;

    public ArrayQueue() {
	this(DEFAULT_ARRAY_SIZE);
    }

    public ArrayQueue(int initialCapacity) {
	@SuppressWarnings("unchecked")
	T[] tempArray = (T[]) new Object[initialCapacity + 1];
	queueArray = tempArray;
	frontIndex = 0;
	backIndex = initialCapacity;
    }
    
    public void enqueue(T anEntry) {
	ensureCapacity();
	backIndex = (backIndex + 1) % queueArray.length;
	queueArray[backIndex] = anEntry;
    }

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

    public T front() {
	return queueArray[frontIndex];
    }

    public T back() {
	return queueArray[backIndex];
    }

    public boolean isEmpty() {
	return frontIndex == ((backIndex +1) % queueArray.length);
    }

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

    public void clear() {
	while(!isEmpty()) {
	    this.dequeue();
	}
    }

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
