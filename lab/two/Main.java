package lab.two;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {
	Calculator calc = new Calculator();
	// (4*3)

	//calc.addInput('(');
	calc.addInput('2');
	calc.addInput('*');
	calc.addInput('3');	
	//calc.addInput(')');
	
	// calc.addInput('+');
	// calc.addInput('3');	
	
	

	// calc.addInput('*');
	// calc.addInput('(');
	// calc.addInput('2');
	// calc.addInput('+');
	// calc.addInput('8');
	// calc.addInput('+');
	// calc.addInput('(');
	// calc.addInput('2');
	// calc.addInput('+');
	// calc.addInput('2');
	// calc.addInput(')');
	// calc.addInput(')');

	calc.processInput();
    }
}
