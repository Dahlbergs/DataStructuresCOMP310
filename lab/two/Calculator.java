package lab.two;

public class Calculator {

    private char[] operators = {'+', '-', '*', '/', '(', ')'};
    private char[] operands = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Stack<Character> inputStack= new Stack<Character>();
    private Stack<Integer> operandStack = new Stack<Integer>();
    private Stack<Character> operatorStack = new Stack<Character>();

    private String input;

    public Calculator() {

    }

    public void addInput(char element) {
	System.out.println("Add element");
	inputStack.push(element);
    }

    public void parseInput() {        
	Character[] elementTuple = new Character[3];
	
	int temp = 0;

	while(!inputStack.isEmpty()) {
	    if(isOperand(inputStack.top())) {
		operandStack.push(Character.getNumericValue(inputStack.pop()));
	    } else if(isOperator(inputStack.top())) {
		operatorStack.push(inputStack.pop());
	    }
	}

	//System.out.println("Checking operandStack");
	while(!operandStack.isEmpty()) {
	    System.out.println(operandStack.pop());
	}

	//System.out.println("Checking operatorStack");
	while(!operatorStack.isEmpty()) {
	    System.out.println(operatorStack.pop());
	}
    }
    
    public void convertToPostfix() {
	Stack<Character> postfix = new Stack<Character>();

	while(!inputStack.isEmpty()) {
	    if(temp.isOperand()){
		postfix.push(temp());		
	    } else { 
		switch(inputStack.top()) {
		case '+':
		case '-':
		case '*':
		case '/':
		    postfix.push(inputStack.top());
		    postfix.push(inputStack.top());
		    break;
		default: 
		    System.out.println("Invalid operator");
		}
	    }
	}
    }

    public void evaluatePostfix() {
	Stack<Character> valueStack = new Stack<Character>();
	
	while(inputStack.getCurrentSize() > 1) {
	    Character temp = inputStack.pop();

	    if(temp.isOperand()) {
		valueStack.push(temp);
	    } else {
		switch(temp) {
		case '+':
		    int a = Character.toNumericValue(valueStack.pop());
		    int b = Character.toNumericValue(valueStack.pop());
		    valueStack.push(valueStack.pop() + valueStack.pop()); 
		    break;
		case '-':
		    valueStack.push(valueStack.pop() + valueStack.pop());
		    break;
		case '*':
		    valueStack.push(valueStack.pop() + valueStack.pop()); 
		    break;
		case '/':
		    valueStack.push(valueStack.pop() + valueStack.pop()); 
		    break;
		default:
		    System.out.println("Invalid operator");
		}
		
	    }

	    System.out.println(inputStack.top());
	}
    }

    public void processStacks() {
	while(operandStack.getCurrentSize() > 3) {
	    int temp = Character.getNumericValue(operandStack.pop());
	    char temp2 = operatorStack.pop();
	    int temp3 = Character.getNumericValue(operandStack.pop());
	    
	    switch(temp2) {
	    case '+':
		operandStack.push(temp + temp3);
		System.out.println(operandStack.top());
		break;
	    case '-':
		operandStack.push(temp - temp3);
		break;
	    case '*':
		operandStack.push(temp * temp3);
		break;
	    case '/':
		operandStack.push(temp / temp3);
		break;
	    default:
		System.out.println("Invalid Operator");
	    }   
	}
	System.out.println(operandStack.top());	
    }

    public boolean isOperand(char character) {
	for(int i = 0; i < operands.length; i++) {
	    if(operands[i] == character) {
		return true;
	    }
	}
	return false;
    }

    public boolean isOperator(char character) {
	for(int i = 0; i < operators.length; i++) {
	    if(operators[i] == character) {
		return true;
	    }
	}
	return false;
    }

    
}
    




