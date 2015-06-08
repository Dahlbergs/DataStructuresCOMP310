package lab.two;

public class Calculator {
    private char[] paren = {'(', ')'};
    private char[] operators = {'+', '-', '*', '/'};
    private char[] operands = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Stack<Character> inputStack = new Stack<Character>();

    private String inputString = "";

    public Calculator() {}
	
    public void addInput(char element) {
	//System.out.println("Add element");
	inputStack.push(element);
    }

    public void stackToString() {
	while(!inputStack.isEmpty()) {
	    inputString = inputStack.pop() + inputString;
	}

	System.out.println(inputString);
    }

    public void processInput() {
	stackToString();	
	processParenthesis(inputString);
    }

    public String processParenthesis(String str) {
	String temp = "";
	String output = "";
	
	//Iterates through string looking for parenthesis
	System.out.println("Looking for parenthesis");
	for(int i = 0; i < str.length(); i++) {
	    //if we find an open one, break it into smaller expression	    
	    if(str.charAt(i) == '(' ) {
		System.out.println("Found open paren");
		//Iterate through new expression looking for closed parenthesis
		for(int j = i+1; j < str.length(); j++) {
		    //If we do not find a close one, add the element to a temp string and continue
		    if(str.charAt(j) != ')') {
			temp = temp + str.charAt(j);
		    } else {  //If we do find one, check that the new substring doesnt have any more parenthesis	
			//System.out.println(temp);
			processParenthesis(str.substring(j, str.length()));
			temp = processExpression(temp);
		    }
		}
	    }
	}	    	
	System.out.println(temp);
	return temp;
    }


    public String processExpression(String str) {
	//Assert that string is a valid expression

	//While the substring is not smaller than a single expression, evaluate the expression
	while(str.length() > 2) {	    
	    String potato = null;

	    char[] tempChar = new String(str.substring(2, str.length() - 1)).toCharArray();

	    switch(str.charAt(1)) {
	    case '+':
	        Integer add = 
		    Character.getNumericValue(str.charAt(0)) +
		    Character.getNumericValue(str.charAt(2));
		potato = add.toString() + new String(tempChar);
		break;
	    case '-':
	        Integer subtract = Character.getNumericValue(str.charAt(0)) -
		    Character.getNumericValue(str.charAt(2));
		potato = subtract.toString() + new String(tempChar);
		break;
	    case '*':
	        Integer multiply = Character.getNumericValue(str.charAt(0)) *
		    Character.getNumericValue(str.charAt(2));
		potato = multiply.toString() + new String(tempChar);
		break;
	    case '/':
		Integer divide = Character.getNumericValue(str.charAt(0)) /
		    Character.getNumericValue(str.charAt(2));
		potato = divide.toString() + new String(tempChar);
		break;
	default:
	    System.out.println("Invalid Expression");
	    System.exit(1);
	    }
	    if(potato != null && potato.length() > 2) {
		System.out.println(potato);
		processExpression(potato);
	    } else {
		return potato;
	    }
	}
	return null;
    }
}
   
