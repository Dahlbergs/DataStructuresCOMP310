package lab.one;

/** Represents an item at a grocery store which will be placed into
    a bag structure
    @author Sam Dahlberg, Robert Blood
*/

public class GroceryItem{
    /* Arbitrary scale from 0.0f to 1.0f */
    
    private String name;
    private double breakable;
    private double squishable;
    private double weight;
    public GroceryItem() {
	/* default constructor */
	this.name = "default";
	this.breakable = 0.0;
	this.squishable = 0.0;
	this.weight = 0.0;
    }
    
    public GroceryItem(String name, double breakable, double squishable, double weight){
	/* constructor */
	this.name = name;
	this.breakable = breakable;
	this.squishable = squishable;
	this.weight = weight;
    
    }
    
    //Sets and Gets
    
    
    public String getName() {
	return name;
    }

    public double getBreakable() {
	return breakable;
    }
   
    public double getSquishable() {
	return squishable;
    }
    public double getWeight() {
	return weight;
    }
    public void setName(String value) {
        name = value;
    }
    public void setBreakable(double value) {
	breakable = value;
    }
    public void setSquishable(double value) {
	squishable = value;
    }
    public void setWeight(double value) {
	weight = value;
    }
}
