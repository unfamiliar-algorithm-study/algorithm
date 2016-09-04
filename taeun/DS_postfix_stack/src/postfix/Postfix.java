package postfix;

import stack.*;
import stackCustom.StackCustom;

public class Postfix {

	private Stack<?> stack;
	
	
	public String convertInfixToPostFix(String infixExpression) throws MemoryException{
		
		String[] infixExpressionArray = infixExpression.split(" ");
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < infixExpressionArray.length){
			String term = infixExpressionArray[i++];
			switch(term){
				case ")": case "}": case "]":
					sb.append(stack.pop()+" ");
					break;
				case "+": case "-": case "*": case "/":
					stack.push(term);
					break;
				case "(": case "{": case"[":
					break;
				default:
					sb.append(term+" ");
					break;
			}
		}
		return sb.toString();
	}

	
	public Integer evaluatePostfix(String expression) throws MemoryException{
		String[] expressionArray = expression.split(" ");
		
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i < expressionArray.length){
			String term = expressionArray[i++];

			Integer num1 = null, num2 = null;
			if(term.equals("+") || term.equals("-") || term.equals("*") || term.equals("/")){
				num1 = stack.pop();
				num2 = stack.pop();
			}
			
			Integer result = null;
			switch(term){
			case "+":
				result = num2 + num1;
				break;
			case "-":
				result = num2 - num1;
				break;
			case "*":
				result = num2 * num1;
				break;
			case "/":
				result = num2 / num1;
				break;
			default: 
				result = Integer.parseInt(term);
				break;
			}
			stack.push(result);
		}
		return stack.pop();
	}
}
