package lab.two;
import java.util.*;

public static void main (String args[]){
	Scanner sc = new Scanner(System.in);
	//create command line args handling for calculator
	sc.(System.in);
	System.out.println("Enter your equation: ");
	System.out.println("EX: 123 + 100");

	String calcLine ="";

	i = 0;
	while(i < arg[].length - 1){
		calcLine += args[i];
	}

	calculator calcOut = new calculator();
	calcOut.sendTo(calcLine);
}