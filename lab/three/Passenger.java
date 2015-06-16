package lab.three;

import java.io.*;

public class Passenger implements Comparable<TrainStation> {
    
    private String name;
    private TrainStation destinationStation;

    static final String DEFAULT_NAME = "Bob";
    static final TrainStation DEFAULT_DESTINATION = new TrainStation();	

    public Passenger() {
	this.name = DEFAULT_NAME;
	this.destinationStation = DEFAULT_DESTINATION;
    }

    public Passenger(String name, TrainStation destination) {
	this.name = name;
	this.destinationStation = destination;	
    }    

    public String getName() {
	return name;
    }

    public int compareTo(TrainStation station) {
	String dest = this.destinationStation.getStationName();
	String curr = station.getStationName();
	if(dest.equals(curr)) {
	    return 1;
	}
	else {
	    return 0;
	}
    }
    
    public static void main(String args[]) {
	TrainStation station = new TrainStation("StationOne");
	TrainStation station1 = new TrainStation("StationTwo");
	Passenger pass = new Passenger("Jim", station1);

	System.out.println(pass.compareTo(station));
	System.out.println(pass.compareTo(station1));

    }
}

    


