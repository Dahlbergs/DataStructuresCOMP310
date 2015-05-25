package lab.one;
import java.util.*;

public class Main {
    public static void main(String args[]){
	
	/** User enters random integers which correspond to various 
	 * groceries and their attributes. 
	 * The program them bags them as efficiently as possible.
	 * @author Sam Dahlberg, Robert Blood
	 */
	
	// GroceryItem milk = new GroceryItem("Milk", 0.0, 0.2, 1.0);
	// GroceryItem bread = new GroceryItem("Bread", 0.0, 1.0, 0.1);
	// GroceryItem eggs = new GroceryItem("Eggs", 0.8, 0.0, 0.4);
	// GroceryItem sugar = new GroceryItem("Sugar", 0.0, 0.0, 0.8);
	// GroceryItem tomato = new GroceryItem("Tomato", 0.0, 0.8, 0.2);
	// GroceryItem butter = new GroceryItem("Butter", 0.0, 0.3, 0.4);
	// GroceryItem chips = new GroceryItem("Chips", 1.0, 0.0, 0.1);
	// GroceryItem cheese = new GroceryItem("Cheese", 0.0, 0.0, 0.5);
    	
	GroceryItem milk = new GroceryItem("Milk", 0.0, 0.2, 1.5);
	GroceryItem bread = new GroceryItem("Bread", 0.0, 1.0, 1.0);
	GroceryItem eggs = new GroceryItem("Eggs", 0.8, 0.0, 1.);
	GroceryItem sugar = new GroceryItem("Sugar", 0.0, 0.0, 1.8);
	
	GroceryItem tomato = new GroceryItem("Tomato", 0.0, 0.8, 1.2);
	GroceryItem butter = new GroceryItem("Butter", 0.0, 0.3, 1.4);
	GroceryItem chips = new GroceryItem("Chips", 1.0, 0.0, 1.1);
	GroceryItem cheese = new GroceryItem("Cheese", 0.0, 0.0, 1.5);

	GroceryItem pickled_pigs_feet = new GroceryItem("Pickled Pigs Feet", 0.2, 0.1, 0.5);
	GroceryItem bacon = new GroceryItem("Bacon", 0.0, 0.0, 0.3);
	GroceryItem crackers = new GroceryItem("Crackers", 0.9, 0.9, 0.2);
	GroceryItem onions = new GroceryItem("Onions", 0.1, 0.5, 0.5);
	
	

	GroceryItem[] shoppingBag = {milk, bread, eggs, sugar,
				     tomato, butter, chips, cheese,
				     pickled_pigs_feet, bacon, crackers, onions};
    	
	Bagger temp = new Bagger(shoppingBag);
	
	/** Sorts the array using element swap and then bags the items accordingly while
	    maintaing a weight threshold */
	temp.sort();
	temp.bag();
        
    	
	
	
    	
    }
}
