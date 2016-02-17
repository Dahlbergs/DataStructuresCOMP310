/** Represents a train station with has a name, and a queue of passengers waiting to get on the train. 
    Also contains functionality to randomly generate passengers 
    @author Robert Blood, Sam Dahlberg, Yves Sabato
*/

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
						    "Connor \"The Condor\" Marks",
						    "Ancel Hernandez",
						    "Robert Blood",
						    "Alex Defrance",
						    "Sam Gleason",
						    "Marc Caristi",
						    "Sam Dahlberg",
						    "Kevin Reynolds",
						    "Nicole Nelson",
						    "Maximilian Vilot",
						    "Conor McGregor",
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
						    "Tucker Thompson",
						    "Dustin Poirier",
						    "Randy Couture",
						    "Bruce Buffer",
						    "Jose Aldo",
						    "Gabriel Gonzaga",
						    "Chuck Norris",
						    "Chuck Liddell",
						    "Dennis Siver",
						    "Lyoto Machida",
						    "Forrest Griffin"
    };
    
    private static final int MAX_CAPACITY = 10;    

    private String stationName;
    private ArrayQueue<Passenger> passengers = new ArrayQueue<Passenger>();

    /** Default constructor */
    public TrainStation() {
	this.stationName = "Default Station";
	//this.generateRandomPassengers();
    }

    /** Constructor assigns name to the train station. */
    public TrainStation(String name) {
	this.stationName = name;
	//this.generateRandomPassengers();
    }

    /** Boards a passenger from this train station and adds it onto the train. */
    public Passenger getPassengerFromStation() {
	if(!passengers.isEmpty()) {
	    return passengers.dequeue();
	}
	System.out.println("Train station: " + stationName + " is empty");
	return null;
    }

    /** @return If the station is empty, true, else false. */
    public boolean isStationEmpty() {
	return passengers.isEmpty();
    }

    /** Generates a random number of passengers with random names and destinations
	station using the default list of names and stations */
    public void generateRandomPassengers() {
	Random rand = new Random();
	int numberOfWaitingPassengers = rand.nextInt(MAX_CAPACITY);
	for(int i = 0; i <= numberOfWaitingPassengers; i++) {
	    generatePassenger();
	}
    }
    
    private void generatePassenger() {
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

    /** @return The name of the station*/
    public String getStationName() {
	   return this.stationName;
    }

    /**@param name The name to apply to the station */
    public void setStationName(String name) {
	   this.stationName = name;
    }

    /** Test method */
    public static void main(String args[]) {
	TrainStation station = new TrainStation("Station");
	station.generateRandomPassengers();
    }
}
