package lab.two;

import java.awt.*;
import javax.swing.*;

public class CalcGUI {
    public static final String[][] BUTTON_LAYOUT = {
	{"CLR", "DEL", "(", ")"},
	{"7", "8", "9", "+"},
	{"4", "5", "6", "-"},
	{"1", "2", "3", "*"},
	{"0", ".", "/", "="}
    };

    public static final Font BUTTON_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 20);

    public void init() {
	JTextField field = new JTextField(10);
	JPanel buttons = new JPanel(new GridLayout(BUTTON_LAYOUT.length, BUTTON_LAYOUT[0].length));
	field.setFont(BUTTON_FONT.deriveFont(Font.PLAIN));
	JPanel btnPanel = new JPanel(new GridLayout(BUTTON_LAYOUT.length,
						    BUTTON_LAYOUT[0].length));

	for(int i = 0; i < BUTTON_LAYOUT.length; i++) {
	    for(int j = 0; j < BUTTON_LAYOUT[i].length; j++) {
		JButton button = new JButton(BUTTON_LAYOUT[i][j]);
		button.setFont(BUTTON_FONT);
		buttons.add(button);			     
	    }
	}

	JPanel mainPanel = new JPanel(new BorderLayout());
	mainPanel.add(field, BorderLayout.PAGE_START);
	mainPanel.add(btnPanel, BorderLayout.CENTER);
	
	JFrame frame = new JFrame("Infix Calculator");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(mainPanel);
	frame.pack();
	//frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}
