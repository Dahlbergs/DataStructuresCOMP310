package lab.three;

class Train {
   
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    // private ArrayQueue<Passenger> departing = new ArrayQueue<Passenger>();

    private TrainStation currentStation;
    // private TrainStation nextStation;

    private static final int MAX_CAPACITY = 100;

    /** Default constructor */
    public Train() {
		
    }

    // public boolean boardPassengers(ArrayQueue<Passenger> stationPassengers) {
    // 	while(!stationPassengers.isEmpty()) {
    // 	    passengers.enqueue(stationPassengers.dequeue());
    // 	}
    // 	return true;
    // }

    public void setCurrentStation(TrainStation station) {
	this.currentStation = station;
    }

    public boolean boardPassengers() {	
	while(!currentStation.isStationEmpty()) {	    
	    passengers.enqueue(currentStation.getPassengerFromStation());
	}
	return true;
    }

    public boolean offloadPassengers() {
	for(int i = 0; i < passengers.getSize(); i++) {
	    if(passengers.front().compareTo(currentStation) == 1) {
		Passenger temp = passengers.dequeue();
		System.out.println("Passenger: " + temp.getName() + " is departing at station: " +
				   currentStation);
	    } else {
		passengers.enqueue(passengers.dequeue());
		System.out.println("Searching through passengers");
	    }
	}		
	return true;
    }

    public static void main(String args[]) {
	
    }

	
}
