package lab.two;

public class Calculator {
	
    private char[] operators = {'+', '-', '*', '/', '(', ')'};
    private char[] operands = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
   
    private Stack<Integer> operandStack = new Stack<Integer>();
    private Stack<Character> operatorStack = new Stack<Character>();

    public Calculator() {}
    
  
    public int parseInput(String expression) {
    	
    	int len = expression.length();
    	char[] input = expression.toCharArray();
    	
    	for (int i = 0; i < len; i++){
    	
    		if (input[i] == '('){
                operatorStack.push(input[i]); // add open bracket to operator stack
                }
            else if (input[i] == ')'){ // if close bracket has higher value precedence than the operator already in stack AND also if it's not an open bracket then evaluate.
                while (!operatorStack.isEmpty() &&  precendence_check(operatorStack.peek()) >= precendence_check(input[i]) && input[i] == ')' && operatorStack.peek() != '('){              
                    if (!processStacks()){
                    	return Integer.MAX_VALUE;   	
                    }
                    if (!operatorStack.isEmpty())
                        operatorStack.pop(); // if operator stack is not empty, remove operator just used.
                }
            }
            else if (input[i] >= '0' && input[i] <= '9'){	
            	operandStack.push(Character.getNumericValue(input[i]));
            }
            else if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/'){
            	
                while (!operatorStack.isEmpty() && precendence_check(operatorStack.peek()) >= precendence_check(input[i])){   
                	if (!processStacks()){
                    	return Integer.MAX_VALUE;   	
                    }
                }
                
                operatorStack.push(input[i]);
            }
     
    	
    	}
    	
    	while (!operatorStack.isEmpty())
    		if (!processStacks()){
            	return Integer.MAX_VALUE;   	
            }
    	
    	return operandStack.pop();
    }
    
    /** method checks for operator precendence order and returns assigned number order.
     *  
     */
    public static int precendence_check(char operation){
    	
        int temp = 0;
        
        if (operation == '(' || operation == ')')
            temp = 0;
        else  if (operation == '*' || operation == '/')
            temp = 3;
        else  if (operation == '+' || operation == '-')
            temp = 2;  
        else
        	temp = 1;
        
        return temp;
        
    }
 
    /** method evaluates expressions in both operator and operand stacks 
     * using stack methods pushing evaluated expressions back to operand stack
     */
    public boolean processStacks() {
    	
	    int temp = operandStack.pop();
	    char temp2 = operatorStack.pop();
	    int temp3 = operandStack.pop();
	    
	    if (temp == 0){
	    	return false;
	    }
	    
	    switch(temp2) {

	    case '+':  	
		operandStack.push(temp3+temp);
		System.out.println(operandStack.peek());
		break;
	    case '-':
		operandStack.push(temp3-temp);
		break;
	    case '*':
		operandStack.push(temp3*temp);
		break;
	    case '/':
		operandStack.push(temp3/temp);
		break;
	    default:
		System.out.println("Invalid Operator");
	    }   
	
		System.out.println("Operand stack or solution is:" + operandStack.peek());
		return true;

    }

    // method will check character in defined char operand array    
    public boolean isOperand(char character) {
	for(int i = 0; i < operands.length; i++) {
	    if(operands[i] == character) {
		return true;
	    }
	}
	return false;
    }

 // method will check character in defined char operator array 
    public boolean isOperator(char character) {
	for(int i = 0; i < operators.length; i++) {
	    if(operators[i] == character) {
		return true;
	    }
	}
	return false;
    }
    
    
}
    




