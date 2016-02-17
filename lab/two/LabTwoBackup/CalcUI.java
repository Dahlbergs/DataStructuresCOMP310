package lab.two;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//Would be easier with arrays in general.
public class CalcUI implements ActionListener {

    Calculator calc = new Calculator();
	
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
		
		frame.setSize(230, 230);
		frame.setResizable(false);
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
	
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		
		buttonadd.addActionListener(this);
		buttonsub.addActionListener(this);
		buttondiv.addActionListener(this);
		buttonmulti.addActionListener(this);
		
		button_lbrac.addActionListener(this);
		button_rbrac.addActionListener(this);
		buttoneq.addActionListener(this);
		button_C.addActionListener(this);
		button_Q.addActionListener(this);
		button_less_than.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	    //String elementString;
	    int value_solution = 0;
	    Object element = e.getSource();
	    //	Calculator calc = new Calculator();
		
		if (element==button1){			
			calc.addInput("1");
			text.append("1");
		}
		else if (element==button2){			
			calc.addInput("2");
			text.append("2");
		}
		else if (element==button3){
			calc.addInput("3");
			text.append("3");
		}
		else if (element==button4){	
			calc.addInput("4");
			text.append("4");
		}
		else if (element==button5){
			calc.addInput("5");
			text.append("5");
		}
		else if (element==button6){
			calc.addInput("6");
			text.append("6");
		}
		else if (element==button7){	
			calc.addInput("7");
			text.append("7");
		}
		else if (element==button8){	
			calc.addInput("8");
			text.append("8");
		}
		else if (element==button9){	
			calc.addInput("9");
			text.append("9");
		}
		else if (element==button0){			
			calc.addInput("0");
			text.append("0");
		}
		else if (element==buttonadd){			
		        calc.addInput("+");
		        text.append("+");
		} else if (element==buttonsub){			
			calc.addInput("-");
			text.append("-");
		} else if (element==buttonmulti){			
			calc.addInput("*");
			text.append("*");
		} else if (element==buttondiv){			
		    calc.addInput("/");
		    text.append("/");
		} else if (element==button_lbrac){			
		    calc.addInput("(");
		    text.append("(");
		} else if (element==button_rbrac){			
		    calc.addInput(")");
		    text.append(")");
		} else if (element==button_C){			
		    calc.clearInputStack();		    
		    text.setText("");
		} else if (element==button_less_than){			
		    if(calc.popFromInputStack()) {
			String temp = "";
			String txt = text.getText();
			if(txt.length() >= 1) {
			temp = txt.substring(0, txt.length() - 1);
			text.setText(temp);
			}			
		    }	     
		    
		}
		else if (element==buttoneq){
		    //calc.parseInput();
		    //elementString = text.getText();
		    //System.out.println("text is:" + elementString);
		    //calc.addInput(elementString);
		    //print_solution(calc.processStacks());
		    calc.convertToPostfix();
		    int temp = calc.evaluatePostfix();
		    text.setText(temp);
		}
	}
		
		public void print_solution(int aValue){
			text.setText("");
			text.setText(Integer.toString(aValue));
				
	}
}
