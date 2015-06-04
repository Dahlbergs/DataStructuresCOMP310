package lab.two;

public class Calculator {

    private  enum Operand {
	ADD ('+'),
	SUBTRACT('-'),
        MULTIPLY('*'),
        DIVISION('*'),
	OPEN_PAREN('('),
        CLOSE_PAREN(')');

	private final char operand;
        Operand(char operand) {
	    this.operand = operand;
	}
    }

    private enum  Operator {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9);

	private final int operator;
        Operator(int operator) {
	    this.operator = operator;
	}
    }

    private Stack<Character> inputStack= new Stack<Character>();
    private String input;

    public Calculator() {

    }

    public void processInput(String str) {
	char[] charArray = str.toCharArray();

	Object previousElement;
	Object currentElement;

	for(int i = 0; i < str.length(); i++) {
	    currentElement = str.toCharArray()[i];
	    
	    //Needs tweaking
	    if(isOperand(str.toCharArray()[0])) {
		currentElement = (Operand) str.toCharArray()[0];
	    } else if (isOperator(str.toCharArray()[0])) {
		currentElement = (Operator) str.toCharArray()[0];
	    }

	    if(currentElement instanceof Operand && previousElement instanceof Operand) {
		System.out.println("Invalid syntax, operand followed by operand");
		System.exit(0);
	    } else if(currentElement instanceof Operator && previousElement instanceof Operator) {
		System.out.println("Invalid syntax, operator followed by operator");
		System.exit(0);
	    }

	}	
    }

    public boolean isOperand(char character) {
	if ((Operand) character instanceof Operand) {
	    return true;
	}

	return false;
    }

    // public boolean isOperator(char character) {

    // }

    // public boolean isWhiteSpace(char character) {
    
    // }public float add(int one, int two) {
	return one + two;
    }

    public float subtract(int one, int two) {
	return one - two;
    }

    public float multply(int one, int two) {
	return one * two;
    }

    public float divide(int one, int two) {
	return one / two;
    }



}
