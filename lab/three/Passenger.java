/** Represents a passenger with a name and a destination station.  The passenger contains
    functionality to determine the whether the passenger has reached their destined station.
    @author Robert Blood, Samuel Dahlberg, Yves Sabato.
 */

package lab.three;

import java.io.*;

public class Passenger implements Comparable<TrainStation> {
    
    private String name;
    private TrainStation destinationStation;

    static final String DEFAULT_NAME = "Bob";
    static final TrainStation DEFAULT_DESTINATION = new TrainStation();	

    /** Default constructor */
    public Passenger() {
	this.name = DEFAULT_NAME;
	this.destinationStation = DEFAULT_DESTINATION;
    }

    /** Constructor which assigns name and destination station for the passenger*/
    public Passenger(String name, TrainStation destination) {
	this.name = name;
	this.destinationStation = destination;	
    }    

    /** @return The name of the passenger */
    public String getName() {
	return name;
    }

    /** Overrides the compareTo method in Comparable interface.  It compares
	the current passengers destination to the station parameter.
	@param station The station to compare destination to. 
    @return Returns 1 if the passed station is the destination, else 0. */
    public int compareTo(TrainStation station) {
	String dest = this.destinationStation.getStationName();
	String curr = station.getStationName();
	if(dest.equals(curr)) {
	    return 1;
	}
	else {
	    return 0;
	}
    }
    
    /** Prints the name and destination station of the current passenger*/
    public void printContents() {
	System.out.println("Name is: " + name);
	System.out.println("Destination station: " + destinationStation.getStationName());	
    }
    
    /** Test method */
    public static void main(String args[]) {
	TrainStation station = new TrainStation("StationOne");
	TrainStation station1 = new TrainStation("StationTwo");
	TrainStation station2 = new TrainStation("StationTwo");
	Passenger pass = new Passenger("Jim", station1);

	//Test compareTo function
	System.out.println(pass.compareTo(station));
	System.out.println(pass.compareTo(station2));
	System.out.println(pass.compareTo(station1));

	pass.printContents();

    }
}

    


