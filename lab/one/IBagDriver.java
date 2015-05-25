package lab.one;
import java.util.*;


public class IBagDriver {
	public static void main(String args[]){
		
	/** User enters random integers which correspond to various 
	 * groceries and their attributes. 
	 * The program them bags them as efficiently as possible.
	 * @author Sam Dahlberg, Robert Blood
	 */

		System.out.println("Welcome to IBag where we neatly place your items"
			+ " safely in order.\n");
		GroceryItem[] content = { new GroceryItem("milk", 0.0, 0.2, 1.0),
								new GroceryItem("bread",0.0, 1.0, 0.1),
    	                        new GroceryItem("eggs", 0.8, 0.0, 0.4),
    							new GroceryItem("sugar", 0.0, 0.0, 0.8),
    							new GroceryItem("tomato", 0.0, 0.8, 0.2),
    							new GroceryItem("butter", 0.0, 0.3, 0.4),
    							new GroceryItem("chips", 1.0, 0.0, 0.1),
    							new GroceryItem("chesse", 0.0, 0.0, 0.5)};
        
        IBag<GroceryItem> ibag = new LinkedBag<GroceryItem>();
        System.out.println("Your ibag contains the following items(s): ");
        testAdd(ibag, content);       
        
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Did you get everything you were looking for?(y/n)\n");
        if(scan.next().equalsIgnoreCase("y")){
        	System.out.println("It was a pleasure to serve you, BYE!\n");
        }
        else{
        	System.out.println("What do you want to do -- (remove/clear/verify)"
        			+ " your bag?\n");
        	String action = scan.next();
        		if(action.equalsIgnoreCase("remove")){
        			System.out.println("Which Item do you want to remove?\n");
        			String item = scan.next();
        			if (!testremove(ibag, content, item)){
        				System.out.println("Your bag was unable to remove:" + item);	
        			}    			
        		}
        		else if(action.equalsIgnoreCase("verify")){
        			System.out.println("What item do you think you missed?\n");
        			String item = scan.next();
        			if (!testcontains(ibag, content, item)){
        				System.out.println("Your bag does not contain: " + item);	
        			}
        		}
        		else{     			
        		System.out.println("Are you sure you want to empty your ibag?(Y/N)\n");
    			String item = scan.next();
    				if (item.equalsIgnoreCase("y")){
    					testclear(ibag);
    				}
    				else{
    					System.out.println("Thank you for using ibag!");
    				}
        	}
        		displayBag(ibag);
        }
       scan.close();
      
        //Bagger temp = new Bagger(ibag, content);
    
	}// end main
		
	
	private static boolean testcontains(IBag<GroceryItem> ibag, GroceryItem[] content, String verify_item)
	{		
		for (int index = 0; index < content.length; index++){
			if (content[index].getName().equals(verify_item)){
				System.out.println("Your ibag already has " + content[index].getName());
				return ibag.contains(content[index]);
			}	
		}
		return false;
	} 
	
	private static boolean testremove(IBag<GroceryItem> ibag, GroceryItem[] content, String remove_item)
	{		
		for (int index = 0; index < content.length; index++){
			if (content[index].getName().equals(remove_item)){
				System.out.println("Your ibag no longer contains any " + content[index].getName());
				return ibag.remove(content[index]);
			}			
		}	return false;
	} 
	
	private static void testclear(IBag<GroceryItem> ibag)
	{		
		ibag.clear();	

	} 
	
	
	private static void displayBag(IBag<GroceryItem> ibag){
	Object[] bagArray = ibag.toArray();
		for (int index = 0; index < bagArray.length; index++){
			GroceryItem Item = (GroceryItem) bagArray[index];
			System.out.print(Item.getName() + " ");
		}
	System.out.println("\nYou have " + ibagSize(ibag) 
			+ " total items in your ibag.\n");
	} 

	private static void testAdd(IBag<GroceryItem> ibag,
	GroceryItem[] content)
	{
	for (int index = 0; index < content.length; index++)
	{
	ibag.add(content[index]);
	} // end for
	System.out.println();
	displayBag(ibag);
	} 
	
	private static int ibagSize(IBag<GroceryItem> ibag){
		return ibag.getCurrentSize();
	}
	
	
}