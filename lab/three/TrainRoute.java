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
    private TrainStation firstStation;
    private TrainStation lastStation;

    public TrainRoute() {
	trainStations = new ArrayList<TrainStation>(DEFAULT_STATION_LIST.length);
	
	firstStation = new TrainStation(DEFAULT_STATION_LIST[0]);
        lastStation = new TrainStation(DEFAULT_STATION_LIST[DEFAULT_STATION_LIST.length - 1]);

	for(int i = 0; i < DEFAULT_STATION_LIST.length; i++) {
	    trainStations.add(new TrainStation(DEFAULT_STATION_LIST[i]));
	} 
    }

    public TrainRoute(String[] stations) {
	trainStations = new ArrayList<TrainStation>(stations.length);

	firstStation = new TrainStation(stations[0]);
        lastStation = new TrainStation(stations[stations.length - 1]);

	for(int i = 0; i < stations.length; i++) {
	    trainStations.add(new TrainStation(stations[i]));
	}
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
