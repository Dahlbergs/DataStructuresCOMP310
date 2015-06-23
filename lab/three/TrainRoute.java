/** The train route class represents a collection of train stations with a fixed order and 
    a train which ferries passengers between each station.
    @author Robert Blood, Samuel Dahlberg, Yves Sabato */

package lab.three;

import java.io.*;
import java.util.*;

public class TrainRoute {
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

    private ArrayList<TrainStation> trainStations;

    private int firstStation;
    private int currentStation;
    private int lastStation;

    //Testing, scope needs to change or needs an accessor
    public int numOfStations;

    /** Enumerates forward and rearward directional movement. */
    private enum Direction {
	FORWARD,
	REARWARD
    }

    private Direction dir = Direction.FORWARD;

    private Train train;

    /** Default constructor */
    public TrainRoute() {
	train = new Train();
	trainStations = new ArrayList<TrainStation>(DEFAULT_STATION_LIST.length);	

	for(int i = 0; i < DEFAULT_STATION_LIST.length; i++) {
	    TrainStation temp = new TrainStation(DEFAULT_STATION_LIST[i]); 
	    System.out.println("\n\n" + temp.getStationName() + ":");
	    temp.generateRandomPassengers();
	    trainStations.add(temp);
	} 


	numOfStations = trainStations.size();
	firstStation = 0;
	currentStation = firstStation;
	lastStation = trainStations.size();
    }

    /** Constructor which creates a list of stations using an array of station names */
    public TrainRoute(String[] stations) {
	train = new Train();
	trainStations = new ArrayList<TrainStation>(stations.length);

	for(int i = 0; i < stations.length; i++) {
	    trainStations.add(new TrainStation(stations[i]));
	}

	firstStation = 0;
	currentStation = 0;
	lastStation = trainStations.size();

	train.setCurrentStation(trainStations.get(currentStation));
	train.boardPassengers();
    }

    /** Allows the train to move to the next station and process boarding and 
	offloading passengers.  When the train reaches the end of the station list,
	Change direction and continue processing passengers.
    */
    public void moveNextStation() {
	System.out.println("\nMoving Next Station");
	
	if(dir == Direction.FORWARD) {
	    if(currentStation == lastStation - 1) {
		dir = Direction.REARWARD;
		currentStation = lastStation - 1;
		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers @ Station: " + currentStation);
		train.offloadPassengers();
		System.out.println("Boarding passengers");
		train.boardPassengers();
	    } else {
		System.out.println("Starting Station No. " + currentStation);
		currentStation = currentStation + 1;
		System.out.println("Current Station No." + currentStation);

		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers");
		train.offloadPassengers();
	
		train.boardPassengers();
	    }
	} else if(dir == Direction.REARWARD) {
	    if(currentStation == firstStation + 1) {
		dir = Direction.FORWARD;
		currentStation = firstStation + 1;
		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers @ Station: " + currentStation);
		train.offloadPassengers();
		System.out.println("Boarding passengers");
		train.boardPassengers();
	    } else {
		System.out.println("Starting Station No." + currentStation);
		currentStation = currentStation - 1;
		System.out.println("Current Station No." + currentStation);

		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers");
		train.offloadPassengers();
	
		train.boardPassengers();
	    }
	}

	trainStations.get(currentStation).generateRandomPassengers();
    }
    
    
    /** Runs the train process through all stations one time */
    public void simulate() {
	this.simulate(this.numOfStations);
	
    }

    /** Runs the simulation the number of times given.
	@param numStations Number of times to iterate */
    public void simulate(int numStations) {
	for(int i = 0; i < numStations; i++) {
	    this.moveNextStation();
	}
    }

    /** Prints name of all stations in the list */
    public void printContents() {
	for(int i = 0; i < trainStations.size(); i++) {
	    System.out.println(trainStations.get(i).getStationName());
	}
    }

    /** Test method */
    public static void main(String args[]) {
	TrainRoute route = new TrainRoute();

	for(int i = 0; i < route.numOfStations; i++) {
	    route.moveNextStation();
	}
	
    }
}
