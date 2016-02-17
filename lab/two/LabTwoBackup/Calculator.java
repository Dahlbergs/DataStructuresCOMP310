package lab.two;

public class Calculator {
	
    private char[] operators = {'+', '-', '*', '/', '(', ')'};
    private char[] operands = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    
    private Stack<Character> inputStack= new Stack<Character>();
    private Stack<Integer> operandStack = new Stack<Integer>();
    private Stack<Character> operatorStack = new Stack<Character>();

    private Stack<Character> postfixStack  = new Stack<Character>();

    public Calculator() {

    }

    public void addInput(String input) {
	inputStack.push(input.charAt(0));
    // int len = expression.length();
    // char[] input = expression.toCharArray();
   
    // 	for (int i = 0; i < len; i++){
    		 
    // 		inputStack.push(input[i]);
    // 		System.out.println("input stack:" + inputStack.top());
    // 	}
    
    // 	parseInput();
    }

    public void parseInput() {        

	//System.out.println("parsing input stack:" + inputStack.top());

	while(!inputStack.isEmpty()) {
		
	    System.out.println("parsing input stack:" + inputStack.top());

	    if(isOperand(inputStack.top())) {
	    	
		operandStack.push(Character.getNumericValue(inputStack.pop()));
	    } 
	    else if(isOperator(inputStack.top())) {
	    	
		operatorStack.push(inputStack.pop());
	    }
	}
	
    }
    
    public void convertToPostfix() {
    	Stack<Character> operatorStack = new Stack<Character>();
    	String postfix = "";

    	while(!inputStack.isEmpty()) {
    	    Character nxtChar = inputStack.top();
	    
    	    switch(nxtChar) {
    	    case '1':
    	    case '2':
    	    case '3':
    	    case '4':
    	    case '5':
    	    case '6':
    	    case '7':
    	    case '8':
    	    case '9':
    	    case '0':
    		postfix = postfix + inputStack.pop();
    		break;
    	    case '+':
    	    case '-':
    	    case '*':
    	    case '/':
    		while(!operatorStack.isEmpty()
    		      && (getPrecedence(nxtChar) <= getPrecedence(operatorStack.top()))) {
		    {
			postfix = postfix + operatorStack.pop();
		    }
		}
		operatorStack.push(inputStack.pop());
		break;
	    case '(':
		operatorStack.push(inputStack.pop());
		break;	    
	    case ')':
		Character topOperator = operatorStack.pop();
		while(topOperator != '(') {		
		    postfix = postfix + topOperator;
		    topOperator = operatorStack.pop();
		}
		break;
	    default: 
		break;
		
	    }
	}
	
	while(!operatorStack.isEmpty()) {
	    Character topOp = operatorStack.pop();
	    postfix = postfix + topOp;
	}
	for(int i = postfix.length() - 1; i > 0; i--) {
	    postfixStack.push(postfix.charAt(i));    
	}
	
	}

    public Integer evaluatePostfix() {
	while(!postfixStack.isEmpty()) {
	    if(isOperand(postfixStack.top())) {
		int temp = Character.getNumericValue(postfixStack.pop());
		operandStack.push(temp);
	    } else if(isOperator(postfixStack.top())) {
		operatorStack.push(postfixStack.pop());

		while(operandStack.getCurrentSize() > 1) {
		    int temp = operandStack.pop();
		    int temp3 = operandStack.pop();
		    
		    switch(operatorStack.pop()) {
		    case '+':				
			operandStack.push(temp+temp3);
			System.out.println(operandStack.top());
			break;
		    case '-':
			operandStack.push(temp-temp3);
			System.out.println(operandStack.top());
			break;
		    case '*':
			operandStack.push(temp*temp3);
			System.out.println(operandStack.top());
			break;
		    case '/':
			operandStack.push(temp/temp3);
			System.out.println(operandStack.top());
			break;
		    default:
			System.out.println("Invalid Operator");
		    }
		}		
	    }
	    
	}
	return operandStack.pop();
    }
    public int getPrecedence(char operator){
	int temp = 0;
	switch(operator) {
	    case '+':
	    case '-':
	        temp = 0;
	    case '*':
	    case '/':
		temp = 1;
	    }

	return temp;
    }
    
    
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
	    System.out.println("processing operand stack:" + operandStack.top());
	    
	    
	    int temp = operandStack.pop();
	    System.out.println("operand 1: " + temp);
	    char temp2 = operatorStack.pop();
	    System.out.println("operator 1: " + temp2);
	    int temp3 = operandStack.pop();
	    System.out.println("operand 2: " + temp3);

	    switch(temp2) {
	    case '+':
	    	
	    	System.out.println("checking temp:" + temp);
	    	System.out.println("checking temp3:" + temp3);
	    	
		operandStack.push(temp+temp3);
		System.out.println(operandStack.top());
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
		System.out.println("Operand stack or solution is:" + operandStack.top());
		return operandStack.top();
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

    public void clearInputStack() {
	inputStack.clear();
    }

    public boolean popFromInputStack() {
	boolean success;
	if(!inputStack.isEmpty()) {
	    inputStack.pop();
	    success = true;
	} else {
	    System.out.println("Stack empty");
	    success = false;
    }
	return success;
    }
}
    




