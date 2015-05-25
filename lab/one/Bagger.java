package lab.one;
import java.util.*;

/** Represents a grocery bagger who takes a cart of items and sorts into one or more bags
    based on breakibility, squishability and weight.
    @author Sam Dahlberg, Robert Blood */

public class Bagger {
    double bagWeight = 0.0;
    GroceryItem[] groceryList;
    boolean isSorted = false;

    public Bagger(GroceryItem[] groceryList) {
	this.groceryList = groceryList;
    }

    void sort() {
    	for(int i = 0; i < groceryList.length - 1; i++) {
    		//temp object to hold element[i] for swapping
    		GroceryItem temp = new GroceryItem(groceryList[i].getName(),
				  groceryList[i].getBreakable(),
				  groceryList[i].getSquishable(),
				  groceryList[i].getWeight());
	
    		if(groceryList[i].getWeight() < groceryList[i+1].getWeight()) {
    			//Swap elements
			    groceryList[i].setName(groceryList[i+1].getName());
			    groceryList[i].setBreakable(groceryList[i+1].getBreakable());
			    groceryList[i].setSquishable(groceryList[i+1].getSquishable());
			    groceryList[i].setWeight(groceryList[i+1].getWeight());
			    
			    groceryList[i+1].setName(temp.getName());
			    groceryList[i+1].setBreakable(temp.getBreakable());
			    groceryList[i+1].setSquishable(temp.getSquishable());
			    groceryList[i+1].setWeight(temp.getWeight());

    		}
    		else if(groceryList[i].getBreakable() > groceryList[i+1].getBreakable()){
    			//Swap elements
			    groceryList[i].setName(groceryList[i+1].getName());
			    groceryList[i].setBreakable(groceryList[i+1].getBreakable());
			    groceryList[i].setSquishable(groceryList[i+1].getSquishable());
			    groceryList[i].setWeight(groceryList[i+1].getWeight());
			    
			    groceryList[i+1].setName(temp.getName());
			    groceryList[i+1].setBreakable(temp.getBreakable());
			    groceryList[i+1].setSquishable(temp.getSquishable());
			    groceryList[i+1].setWeight(temp.getWeight());
    		}
    		else if(groceryList[i].getSquishable() > groceryList[i+1].getSquishable()){
    			//Swap elements
			    groceryList[i].setName(groceryList[i+1].getName());
			    groceryList[i].setBreakable(groceryList[i+1].getBreakable());
			    groceryList[i].setSquishable(groceryList[i+1].getSquishable());
			    groceryList[i].setWeight(groceryList[i+1].getWeight());
			    
			    groceryList[i+1].setName(temp.getName());
			    groceryList[i+1].setBreakable(temp.getBreakable());
			    groceryList[i+1].setSquishable(temp.getSquishable());
			    groceryList[i+1].setWeight(temp.getWeight());
    		}
		
	}
	isSorted = true;
    }

void bag() {
    if(!isSorted) {
		System.out.println("Attempted to bag unsorted items, exiting");
		return;
	    }
    
    System.out.println("Making bag and bagging items");
    LinkedBag<GroceryItem> temp = new LinkedBag<GroceryItem>();
    for(int i = 0; i < groceryList.length; i++) {
	temp.setBagWeight(groceryList[i].getWeight());
	if(!temp.isHeavy()) {
	    temp.add(groceryList[i]);
	} else {
	    System.out.println("Printing bag contents");
	    for(int j = 0; j < temp.getCurrentSize(); j++) {
		System.out.println("To string");
		GroceryItem[] niggers = temp.toArray();
		niggers[i].toString();
	    }
	
	}
    
    }
}

}
