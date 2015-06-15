package lab.three;

public class TrainStation {
    private static final String DEFAULT_STATION_NAME = "Default Station";
    private static final int MAX_CAPACITY = 10;
    
    private String stationName;
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    
    public TrainStation() {
	this.stationName = DEFAULT_STATION_NAME;
    }

    public TrainStation(String name, double[] schedule) {
	this.stationName = name;
    }

    public void generatePassengers() {
	
    }

    public String getStationName() {
	return this.stationName;
    }

    public void setStationName(String name) {
	this.stationName = name;
    }
}
