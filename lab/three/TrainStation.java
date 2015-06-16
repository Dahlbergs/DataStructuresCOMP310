package lab.three;

import java.util.Random;

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
    
    private static final String[] PASSENGER_LIST = {"Jon O'Reilly",
						    "Connor Marks",
						    "Ancel Hernandez",
						    "Robert Blood",
						    "Alex Defrance",
						    "Sam Gleason",
						    "Marc Caristi",
						    "Sam Dahlberg",
						    "Kevin Reynolds",
						    "Nicole Nelson",
						    "Danny Levin",
						    "Erika Thornes",
						    "Jon Smith",
						    "Kenny Campbell",
						    "Richard Murphy",
						    "Chelsea Watson",
						    "Bernard Price",
						    "Dan Kelly",
						    "Mark Hamill",
						    "Jimmy Phan",
						    "Michael Hawk",
						    "Tim Marshall",
						    "Homer Simpson",
						    "Peter Griffin",
						    "Margaret Thatcher",
						    "David Ortiz",
						    "Meghan Stevens",
						    "Jamie Porter",
						    "Jesse James",
						    "Tucker Thompson" };
    
    private static final int MAX_CAPACITY = 10;    

    private String stationName;
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();
    
    public TrainStation() {
	this.stationName = "Default Station";
    }

    public TrainStation(String name) {
	this.stationName = name;
    }

    public Passenger getPassengerFromStation() {
	if(!passengers.isEmpty()) {
	    return passengers.dequeue();
	}
	System.out.println("Train station: " + stationName + " is empty");
	return null;
    }

    public boolean isStationEmpty() {
	return passengers.isEmpty();
    }
    
    public void generatePassenger() {
	Random rand = new Random();
	int randPassenger = rand.nextInt(PASSENGER_LIST.length);
	String passengerName = (PASSENGER_LIST[randPassenger]);
	
	int randStation = new Random().nextInt(DEFAULT_STATION_LIST.length);
	String stationName =(DEFAULT_STATION_LIST[randStation]);
	TrainStation destStation = new TrainStation(stationName);
	Passenger temp = new Passenger(passengerName, destStation);

	temp.printContents();
	passengers.enqueue(temp);
    }

    // public String generateStation(){
    //     int iGen1 = new Random().nextInt(DEFAULT_STATION_LIST.length);
    //     String randomDestination = (DEFAULT_STATION_LIST[iGen1]);
    // }

    public String getStationName() {
	   return this.stationName;
    }

    public void setStationName(String name) {
	   this.stationName = name;
    }

    public static void main(String args[]) {
	TrainStation station = new TrainStation();
	for(int i = 0; i <= 5; i++) {
	station.generatePassenger();
	}
	
    }
}
