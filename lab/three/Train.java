/** Represents a train holding passengers traveling between stations 
    @author Robert Blood, Samuel Dahlberg, Yves Sabato */


package lab.three;

class Train {
   
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    private TrainStation currentStation;
    private static final int MAX_CAPACITY = 100;

    /** Default constructor */
    public Train() {
		
    }

    /** Sets the station that the train is currently stationed at.
	@param station The station to set the train to. */
    public void setCurrentStation(TrainStation station) {
	this.currentStation = station;
    }
    
    /** Removes passengers from the current station queue and puts them on the train. 
	@return If successful, return true, else return false. */
    public boolean boardPassengers() {	
	while(!currentStation.isStationEmpty()) {	    
	    
	    passengers.enqueue(currentStation.getPassengerFromStation());
	    System.out.println("Boarding Passenger: " + passengers.back().getName());
	}
	System.out.println("\nDone boarding \n");
	return true;
    }

    /** Offloads all the passengers from the train whose destination station is the current
	station
	@return If successful, return true, else return false. */
    public boolean offloadPassengers() {
	//System.out.println("Offloading at station: " + currentStation.getStationName());
	for(int i = 0; i < passengers.getSize(); i++) {
	    if(passengers.front().compareTo(currentStation) == 1) {
		Passenger temp = passengers.dequeue();
		System.out.println("Passenger: " + temp.getName() + " is departing at station: " +
				   currentStation.getStationName());
	    } else {
		passengers.enqueue(passengers.dequeue());
		//System.out.println("Searching through passengers");
	    }
	}		
	return true;
    }

    /** Main method for testing the class. */
    public static void main(String args[]) {
	
    }

	
}
