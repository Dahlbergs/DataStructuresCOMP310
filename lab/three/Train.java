package lab.three;

class Train {
   
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    private TrainRoute trainRoute;

    private TrainStation currentStation;
    private TrainStation nextStationl;

    public boolean boardPassengers(ArrayQueue<Passenger> stationPassengers) {
	while(!stationPassengers.isEmpty()) {
	    passengers.enqueue(stationPassengers.dequeue());
	}
	return true;
    }

    public boolean offloadPassengers() {
	return true;
    }
}
