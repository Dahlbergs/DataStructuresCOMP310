package lab.two;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {
	Calculator calc = new Calculator();
	// 1 + 2 * 2 -3 = 2
	calc.addElement('1');
	calc.addElement('+');
	calc.addElement('2');

	calc.processInput();
	calc.processStacks();
	
    }
}
