/** Train station driver class
    @author Robert Blood, Sam Dahlberg, Yves Sabato 
*/

package lab.three;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
	TrainRoute route = new TrainRoute();	

	System.out.println("=============== Starting train simulation ===============\n");

	while(true) {
	    System.out.println("Enter 1 to continue simulation, or 0 to end it\n");
	    Scanner keyboardIn = new Scanner(System.in);
	    int cont = 0;

	    switch(keyboardIn.nextInt()) {
	    case 1:
		route.simulate(1);
		break;
	    case 0:
		System.out.println("Ending Simulation");
		return;
	    default:
		System.out.println("Invalid option, ignoring entry");
		break;
	    }   
	}
    }
}
