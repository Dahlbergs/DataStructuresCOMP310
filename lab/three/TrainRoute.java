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

    private enum Direction {
	FORWARD,
	REARWARD
    }

    private Direction dir = Direction.FORWARD;

    private Train train;

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

    public void moveNextStation() {
	System.out.println("\nMoving Next Station");
	if(dir == Direction.FORWARD) {
	    if(currentStation == lastStation - 1) {
		dir = Direction.REARWARD;
		currentStation = lastStation - 1;
		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers");
		train.offloadPassengers();
		System.out.println("Boarding passengers");
		train.boardPassengers();
	    } else {
		System.out.println("Current Station No." + currentStation);
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
		
		System.out.println("Offloading passengers");
		train.offloadPassengers();
		System.out.println("Boarding passengers");
		train.boardPassengers();
	    } else {
		System.out.println("Current Station No." + currentStation);
		currentStation = currentStation - 1;
		System.out.println("Current Station No." + currentStation);

		train.setCurrentStation(trainStations.get(currentStation));
		
		System.out.println("Offloading passengers");
		train.offloadPassengers();
	
		train.boardPassengers();
	    }
	}
    }
    

    public void simulate() {
	
    }

    public void printContents() {
	for(int i = 0; i < trainStations.size(); i++) {
	    System.out.println(trainStations.get(i).getStationName());
	}
    }

    public static void main(String args[]) {
	TrainRoute route = new TrainRoute();

	

	for(int i = 0; i < route.numOfStations; i++) {
	    route.moveNextStation();
	}
	
    }
}
