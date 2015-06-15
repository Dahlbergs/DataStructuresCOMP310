package lab.three;

public class TrainStation {
    private static final String[] DEFAULT_STATION_LIST = {"North Station",
						  "South Station",
						  "New York Station",
						  "Philidelphia Station",
						  "Washington D.C. Station",
						  "Baltimore Station",
						  "Richmond Station",
						  "Louisville Station",
						  "Savannah Station",
						  "Jacksonville Station"};


    //private static final String DEFAULT_STATION_NAME = "Default Station";
    private static final int MAX_CAPACITY = 10;    

    private String stationName;
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    
    public TrainStation() {
	this.stationName = "Default Station";
    }

    public TrainStation(String name) {
	this.stationName = name;
    }

    public String getStationName() {
	return this.stationName;
    }

    public void setStationName(String name) {
	this.stationName = name;
    }
}
