package lab.two;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcUI {

	JFrame frame = new JFrame("ICalculator");
	JPanel panel = new JPanel(new FlowLayout());
	
	JTextArea text = new JTextArea(1,20);

	
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	
	JButton buttonadd = new JButton("+");
	JButton buttonsub = new JButton("-");
	JButton buttonmulti = new JButton("*");
	JButton buttondiv = new JButton("/");
	JButton buttoneq = new JButton("=");
	JButton button_lbrac = new JButton("(");
	JButton button_rbrac = new JButton(")");
	
	JButton button_C = new JButton("C");
	JButton button_Q = new JButton("Q");
	JButton button_less_than = new JButton("<");



	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame.setVisible(true);
		frame.setSize(200,220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		panel.add(text);
		panel.add(button_C);
		panel.add(button_less_than);
		panel.add(button_Q);
		panel.add(buttondiv);
		
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonmulti);
		
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonsub);
	
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(buttonadd);
	
		panel.add(button0);	
		panel.add(button_lbrac);
		panel.add(button_rbrac);
		panel.add(buttoneq);
							
	}
}
