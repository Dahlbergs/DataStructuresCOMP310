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

<<<<<<< HEAD
    public void generatePassenger() {
        int iGen2 = new Random().nextInt(passengerManifest.length);
	    String randomPassenger = (passengerManifest[iGen2]);
    }

    public void generateStation(){
        int iGen1 = new Random().nextInt(DEFAULT_STATION_LIST.length);
        String randomDestination = (DEFAULT_STATION_LIST[iGen1]);
    }

=======
>>>>>>> 0d9d145339fb6dba340e3178d62c079be3f47b5a
    public String getStationName() {
	   return this.stationName;
    }

    public void setStationName(String name) {
	   this.stationName = name;
    }

    public TicketGenerator(generatePassenger().getPassenger(), generateStation().getStationName(), generateStation().getStationName()){
        String Passenger = generatePassenger().getPassenger();
        String Boarding = generateStation().getStationName();
        String Destination = generateStation().getStationName();
    }

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

    //creates random passenger/source/destination itinerary





    while(i > 10){
        TicketGenerator temp = new TicketGenerator(randomPassenger, randomBoard, randomDestination);
        i++;
        System.out.println(temp);
    }
}
