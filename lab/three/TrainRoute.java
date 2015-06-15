package lab.three;

import java.io.*;

public class TrainRoute {

    public static void main(String args[]) {
	File inFile = null;
	
	if (0 < args.length) {
	    inFile = new File(args[0]);
	} else {
	    System.out.println("Invalid Argument, Exiting");
	    return;
	}
	
	BufferedReader br = null;
	
	try {	    
	    String sCurrentLine;
	    
	    br = new BufferedReader(new FileReader(inFile));
	    
	    while ((sCurrentLine = br.readLine()) != null) {
		System.out.println(sCurrentLine);
	    }
	    
	} 

	catch (IOException e) {
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
