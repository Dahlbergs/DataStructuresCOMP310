package lab.two;

import youtube_calculator.Stack;

public class Calculator {
	
    private char[] operators = {'+', '-', '*', '/', '(', ')'};
    private char[] operands = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    
    private Stack<Character> inputStack= new Stack<Character>();
    private Stack<Integer> operandStack = new Stack<Integer>();
    private Stack<Character> operatorStack = new Stack<Character>();

    public Calculator() {

    }

    public void addInput(String expression) {
    
    int len = expression.length();
    char[] input = expression.toCharArray();
   
    	for (int i = 0; i < len; i++){
    		 
    		inputStack.push(input[i]);
    		System.out.println("input stack:" + inputStack.peek());
    	}
    
    	parseInput();
    }

    public void parseInput() {        

    System.out.println("parsing input stack:" + inputStack.peek());

	while(!inputStack.isEmpty()) {
		
	    if(isOperand(inputStack.peek())) {
	    	
		operandStack.push(Character.getNumericValue(inputStack.pop()));
	    } 
	    else if(isOperator(inputStack.peek())) {
	    	
		operatorStack.push(inputStack.pop());
	    }
	}
	
    }
    
//    public void convertToPostfix() {
//	Stack<Character> postfix = new Stack<Character>();
//
//	while(!inputStack.isEmpty()) {
//	    if(temp.isOperand()){
//		postfix.push(temp());		
//	    } else { 
//		switch(inputStack.top()) {
//		case '+':
//		case '-':
//		case '*':
//		case '/':
//		    postfix.push(inputStack.top());
//		    postfix.push(inputStack.top());
//		    break;
//		default: 
//		    System.out.println("Invalid operator");
//		}
//	    }
//	}
//    }

//    public void evaluatePostfix() {
//	Stack<Character> valueStack = new Stack<Character>();
//	
//	while(inputStack.getCurrentSize() > 1) {
//	    Character temp = inputStack.pop();
//
//	    if(temp.isOperand()) {
//		valueStack.push(temp);
//	    } else {
//		switch(temp) {
//		case '+':
//		    int a = Character.toNumericValue(valueStack.pop());
//		    int b = Character.toNumericValue(valueStack.pop());
//		    valueStack.push(valueStack.pop() + valueStack.pop()); 
//		    break;
//		case '-':
//		    valueStack.push(valueStack.pop() + valueStack.pop());
//		    break;
//		case '*':
//		    valueStack.push(valueStack.pop() + valueStack.pop()); 
//		    break;
//		case '/':
//		    valueStack.push(valueStack.pop() + valueStack.pop()); 
//		    break;
//		default:
//		    System.out.println("Invalid operator");
//		}
//		
//	    }
//
//	    System.out.println(inputStack.top());
//	}
//    }

    public int processStacks() {
    	
	while(operandStack.getCurrentSize() > 1) {
		System.out.println("processing operand stack:" + operandStack.peek());
	    int temp = Character.getNumericValue(operandStack.pop());
	    char temp2 = operatorStack.pop();
	    int temp3 = Character.getNumericValue(operandStack.pop());
	    
	    switch(temp2) {
	    case '+':
	    	
	    	System.out.println("checking temp:" + temp);
	    	System.out.println("checking temp3:" + temp3);
	    	
		operandStack.push(temp+temp3);
		System.out.println(operandStack.peek());
		break;
	    case '-':
		operandStack.push(temp-temp3);
		break;
	    case '*':
		operandStack.push(temp*temp3);
		break;
	    case '/':
		operandStack.push(temp/temp3);
		break;
	    default:
		System.out.println("Invalid Operator");
	    }   
	}
		System.out.println("Operand stack or solution is:" + operandStack.peek());
		return operatorStack.peek();
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
    




