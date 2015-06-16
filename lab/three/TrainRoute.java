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
	    trainStations.add(new TrainStation(DEFAULT_STATION_LIST[i]));
	} 

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
	lastStation = trainStations.size();
    }

    public void moveNextStation() {
	if(dir == Direction.FORWARD) {
	    if(currentStation == lastStation) {
		dir = Direction.REARWARD;
		currentStation = lastStation - 1;
		train.setCurrentStation(trainStations.get(currentStation));
		
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
	route.printContents();
    }
}
