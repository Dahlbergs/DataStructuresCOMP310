package lab.one;

/** Represents an item at a grocery store which will be placed into
    a bag structure
    @author Sam Dahlberg, Robert Blood
*/

public class GroceryItem{
    
    
    private String name;
    
    /* Arbitrary scale from 0.0f to 1.0f */
    private double breakable;
    private double squishable;
    private double weight;
    
    /** Default constructor */
    public GroceryItem() {
	this.name = "default";
	this.breakable = 0.0;
	this.squishable = 0.0;
	this.weight = 0.0;
    }
    
    /** Constructor which sets name, breakibility, squishability and weight 
	@param name Item name
	@param breakable Item breakibility
	@param squishable Item squishibility
	@param weight Item weight
     */
    public GroceryItem(String name, double breakable, double squishable, double weight){
	setName(name);
	setBreakable(breakable);
	setSquishable(squishable);
	setWeight(weight);
    }
    
    /** Accessors for item parameters */
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

    /** Mutators for item parameters */
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

    public String toString() {
	System.out.println("Name: " + getName() + " " +
			           "Break: " + getBreakable() + " " + 
			           "Squish: " + getSquishable() + " " +
			           "Weight: " + getWeight());
	return "";
    }
}
