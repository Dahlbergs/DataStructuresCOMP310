package lab.three;

import java.io.*;

public class Passenger {
    
    private String name;
    private static String[] passengerManifest = {"Jon O'Reilly",
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
						 "Tucker Thompson"};
    private TrainStation originStation;
    private TrainStation destinationStation;

    static final String DEFAULT_NAME = "Bob";
    static final TrainStation DEFAULT_ORIGIN = new TrainStation();
    static final TrainStation DEFAULT_DESTINATION = new TrainStation();	

    public Passenger() {
	this.name = DEFAULT_NAME;
	this.originStation = DEFAULT_ORIGIN;
	this.destinationStation = DEFAULT_DESTINATION;
    }

    public Passenger(String name, TrainStation origin, TrainStation destination) {
	this.name = name;
	this.originStation = origin;
	this.destinationStation = destination;	
    }
    
    public static void main(String args[]) {
	File inputFile = null;
	String[] inputStrings = new String[100];

	if (0 < args.length) {
	    inputFile = new File(args[0]);
	} else {
	    System.out.println("Invalid Argument, Exiting");
	    return;
	}
	
	BufferedReader br = null;
	
	try {	    
	    String sCurrentLine;
	    
	    br = new BufferedReader(new FileReader(inputFile));
	    int strArrIndex = 0;

	    while ((sCurrentLine = br.readLine()) != null) {
		inputStrings[strArrIndex] = sCurrentLine;
		System.out.println(sCurrentLine);
		strArrIndex++;
	    }
	    
	} catch (IOException e) {
	    e.printStackTrace();
	} 
	
	finally {
	    try {
		if (br != null)br.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}
    }
}

    


