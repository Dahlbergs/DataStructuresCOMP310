package lab.one; 

/**A grocery bag that extends LinkedBag to provide specialized functionaliy
   for processes involved in handling grocery bags. */
public final class GroceryBag<T> extends LinkedBag<T> {

    protected double bagWeight;

    /** Adds a specific handler if the Grocerybag entry is an instanceof a GroceryItem
	to ensure the bagweight gets decremented if an item is removed 
	@param anEntry A generic item to be put into the bag
	@return True if the action was succesful, false if not. */
    public boolean remove(T anEntry){
	boolean result = false;
	Node nodeN = getReferenceTo(anEntry);
	if(nodeN != null)
	    {
		nodeN.data = firstNode.data;
		firstNode = firstNode.next;
		numberOfEntries--;
		result = true;
	    }
	/** A profound but OOP defying piece of code. Do not use if you don't understand
	    exactly what is happening.  This adds handling if the generic type is assumed to be
	    a GroceryItem which has particular member accesors 
	    NOTE: Only works for a GroceryBag that contains GroceryItems */
	if(anEntry instanceof GroceryItem) {
	    /* Cast anEntry to a GroceryItem. Doesnt work otherwise */
	    GroceryItem temp = (GroceryItem) anEntry;
	    this.setBagWeight(this.getBagWeight() - temp.getWeight());
	}

    return result;
    }

    /** Adds a set weight call to ensure that the weight of the cleared bag is 
	zero when clear is called */
    public void clear() {
	while(!isEmpty()) //need check if empty method
	    {
		T temp = remove(); //Remove item arbitrarily
	    }
	
	setBagWeight(0.0); //Make doubly sure that bag has no weight
    }

    /** Heavy is defined as exceeding an arbitrary threshold defined in this class.
	@return Whether the bag is too heavy to accept new items or not */
    public boolean isHeavy(){
    	boolean heavy = false;
    	if(bagWeight >= 3.0){
	    heavy = true;
    	} 
	return heavy;
    }
    /** Gets the weight of the bag on the arbitrary scale
     @return The weight of the bag */
    public double getBagWeight(){
    	return bagWeight;
    }

    /** Increments the weight of the bag by the given value
	@param value How much to increment the weight by */
    public void addWeightToBag(double value) {
    	bagWeight += value;
    }

    /** Sets the bag weight to the given value
	@param value The value to set the bag weight too*/
    public void setBagWeight(double value) {
	bagWeight = value;
    }
}
