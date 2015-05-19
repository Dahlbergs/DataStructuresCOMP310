package lab.one;

/** Represents an item at a grocery store which will be placed into
    a bag structure
    @author Sam Dahlberg, Robert Blood
*/

public class GroceryItem{
    /* Arbitrary scale from 0.0f to 1.0f */
    private double breakable;
    private double squishable;
    private double weight;
    public GroceryItem() {
	/* default constructor */
	this.breakable = 0.0;
	this.squishable = 0.0;
	this.weight = 0.0;
    }
    
    public GroceryItem(double breakable, double squishable, double weight){
	/* constructor */
	this.breakable = breakable;
	this.squishable = squishable;
	this.weight = weight;
    
    }
    
    //Sets and Gets
    public double getBreakable() {
	return breakable;
    }
   
    public double getSquishable() {
	return squishable;
    }
    public double getWeight() {
	return weight;
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
