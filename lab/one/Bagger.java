package lab.one;
import java.util.*;
/** @author Sam Dahlberg, Robert Blood */
public class Bagger {
    public Bagger(LinkedBag<GroceryItem> emptyBag, GroceryItem[] groceryList) {
		
	int i = 0;
	while(i < groceryList.length){
	    if(groceryList[i].getBreakable() > groceryList[i+1].getBreakable())
		{
		    //Element swap 
		    //Element i is stored in temp
		    GroceryItem temp = new GroceryItem(groceryList[i].getName(),
						       groceryList[i].getBreakable(),
						       groceryList[i].getSquishable(),
						       groceryList[i].getWeight());
		    //Element i transformed into i+1
		    groceryList[i].setName(groceryList[i+1].getName());
		    groceryList[i].setBreakable(groceryList[i+1].getBreakable());
		    groceryList[i].setSquishable(groceryList[i+1].getSquishable());
		    groceryList[i].setWeight(groceryList[i+1].getWeight());
		    //Element i+1 is filled with temp which is filled with i
		    groceryList[i+1].setName(temp.getName());
		    groceryList[i+1].setBreakable(temp.getBreakable());
		    groceryList[i+1].setSquishable(temp.getSquishable());
		    groceryList[i+1].setWeight(temp.getWeight());
					
		    System.out.println("Break: " + groceryList[i].getBreakable() + " " + 
				       "Squish: " + groceryList[i].getSquishable() + " " +
				       "Weight: " + groceryList[i].getWeight());
		    // Arrays.sort(groceryList);
		    // System.out.println(Arrays.asList(groceryList));
					 
					
		}
	    i++;
	}
    }
}
