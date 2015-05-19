package lab.one;
/** @author Sam Dahlberg, Robert Blood */
public class Bagger {
    public Bagger(LinkedBag<GroceryItem> emptyBag, GroceryItem[] groceryList) {
	int i;
	for(i = 0; i < groceryList.length; i++){
	    if(groceryList[i].getBreakable() > groceryList[i+1].getBreakable())
		{
		    //Element swap 
		    //Element i is stored in temp
		    GroceryItem temp = new GroceryItem(groceryList[i].getBreakable(),
						       groceryList[i].getSquishable(),
						       groceryList[i].getWeight());
		    //Element i transformed into i+1
		    groceryList[i].setBreakable(groceryList[i+1].getBreakable());
		    groceryList[i].setSquishable(groceryList[i+1].getSquishable());
		    groceryList[i].setWeight(groceryList[i+1].getWeight());
		    //Element i+1 is filled with temp which is filled with i
		    groceryList[i+1].setBreakable(temp.getBreakable());
		    groceryList[i+1].setSquishable(temp.getSquishable());
		    groceryList[i+1].setWeight(temp.getWeight());
		}
	}
    }
}
