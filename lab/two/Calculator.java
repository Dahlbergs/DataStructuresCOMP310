package lab.two;

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
    
    	//parseInput();
    }
   
  //A method to determine operator precedence.
    public static int prec(char op){
        int temp = 0;
        if (op == '(' || op == ')')
            temp = 0;
        else  if (op == '*' || op == '/')
            temp = 3;
        else  if (op == '+' || op == '-')
            temp = 2;  
        else
        	temp = 1;
        return temp;
    }
  
    
    public int parseInput(String expression) {
    	
    	int len = expression.length();
    	char[] input = expression.toCharArray();
    	
    	for (int i = 0; i < len; i++){
    	
    		if (input[i] == '('){
                operatorStack.push(input[i]); // add open bracket to operator stack
                }
            else if (input[i] == ')'){ // if close bracket has higher value precedence than the operator already in stack AND also if it's not an open bracket then evaluate.
                while (!operatorStack.isEmpty() &&  prec(operatorStack.peek()) >= prec(input[i]) && input[i] == ')' && operatorStack.peek() != '('){              
                    processStacks();
                    if (!operatorStack.isEmpty())
                        operatorStack.pop(); // if operator stack is not empty, remove operator just used.
                }
            }
            else if (input[i] >= '0' && input[i] <= '9'){	
            	operandStack.push(Character.getNumericValue(input[i]));
            }
            else if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/'){
            	
                while (!operatorStack.isEmpty() &&prec(operatorStack.peek()) >= prec(input[i])){   
                    processStacks();
                }
                
                operatorStack.push(input[i]);
            }
     
    	
    	}
    	
    	while (!operatorStack.isEmpty())
    		processStacks();
    	
    	return operandStack.pop();
    }
    
    
    

//    public void parseInput() {        
//
//    System.out.println("parsing input stack:" + inputStack.peek());
//
//	while(!inputStack.isEmpty()) {
//		
//	    if(isOperand(inputStack.peek())) {
//	    	
//		operandStack.push(Character.getNumericValue(inputStack.pop()));
//	    } 
//	    else if(isOperator(inputStack.peek())) {
//	    	
//		operatorStack.push(inputStack.pop());
//	    }
//	}
//	
//    }
    
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
    

    public void processStacks() {
    	
		System.out.println("processing operand stack:" + operandStack.peek());
	    int temp = operandStack.pop();
	    char temp2 = operatorStack.pop();
	    int temp3 = operandStack.pop();
	    
	    switch(temp2) {
	    case '+':  	
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
	    	if (temp3 == 0) throw new UnsupportedOperationException ("Cannot divide by zer");
		operandStack.push(temp/temp3);
		break;
	    default:
		System.out.println("Invalid Operator");
	    }   
	
		System.out.println("Operand stack or solution is:" + operandStack.peek());
		//return operandStack.peek();
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
    




