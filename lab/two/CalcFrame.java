package lab.two;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcFrame {

	private JFrame frame;
	private JPanel panel;
	private JTextArea text;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcFrame window = new CalcFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Super Calculator");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		
//		panel = new JPanel(new FlowLayout());

//		JButton button1 = new JButton("1");
//		JButton button2 = new JButton("2");
//		JButton button3 = new JButton("3");
//		JButton button4 = new JButton("4");
//		JButton button5 = new JButton("5");
//		JButton button6 = new JButton("6");
//		JButton button7 = new JButton("7");
//		JButton button8 = new JButton("8");
//		JButton button9 = new JButton("9");
//		JButton button0 = new JButton("0");
//		
//		JButton buttonadd = new JButton("+");
//		JButton buttonsub = new JButton("-");
//		JButton buttonmulti = new JButton("*");
//		JButton buttondiv = new JButton("/");
//		JButton buttoneq = new JButton("=");
//		JButton button_lbrac = new JButton("(");
//		JButton button_rbrac = new JButton(")");
//		
//		JButton button_C = new JButton("C");
//		JButton button_Q = new JButton("Q");
//		JButton button_less_than = new JButton("<");
//		
	}
}
