package lab.one;
import java.util.*;

public class Main {
    public static void main(String args[]){
	
	/** User enters random integers which correspond to various 
	 * groceries and their attributes. 
	 * The program them bags them as efficiently as possible.
	 * @author Sam Dahlberg, Robert Blood
	 */
	
	GroceryItem milk = new GroceryItem("Milk", 0.0, 0.2, 1.0);
	GroceryItem bread = new GroceryItem("Bread", 0.0, 1.0, 0.1);
	GroceryItem eggs = new GroceryItem("Eggs", 0.8, 0.0, 0.4);
	GroceryItem sugar = new GroceryItem("Sugar", 0.0, 0.0, 0.8);
	GroceryItem tomato = new GroceryItem("Tomato", 0.0, 0.8, 0.2);
	GroceryItem butter = new GroceryItem("Butter", 0.0, 0.3, 0.4);
	GroceryItem chips = new GroceryItem("Chips", 1.0, 0.0, 0.1);
	GroceryItem cheese = new GroceryItem("Cheese", 0.0, 0.0, 0.5);
    	
	GroceryItem[] shoppingBag = {milk, bread, eggs, sugar, tomato, butter, chips, cheese};
    	
	LinkedBag<GroceryItem> emptybag = new LinkedBag<GroceryItem>();
    	
	Bagger temp = new Bagger(shoppingBag);
    	
    	
    	
	/*System.out.println("Milk B/S " + milk.getBreakable() + " " + milk.getSquishable());
	  System.out.println("Bread B/S " + bread.getBreakable() +" " + bread.getSquishable());
	  System.out.println("Eggs B/S  " + eggs.getBreakable() + " " + eggs.getSquishable());
	  System.out.println("Sugar B/S " + sugar.getBreakable() + " " + sugar.getSquishable());
    
	  /*		int n;
	  String groceryTest = "Potatoe, Chips, Soda";
	  Scanner sc = new Scanner(System.in);
		
	  System.out.println("This is Lab One");
	  System.out.println("Enter an integer: ");
	  n = sc.nextInt();
	  System.out.println("You entered: " + n);
	  System.out.println("This is: " + groceryTest);*/
		
		
	//sc.close();
    	
    }
}
