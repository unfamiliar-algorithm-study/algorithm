/*
 * 2016.9.2
 * 설명: 링크드리스트로 구현한 스택을 이용한 postfix 연산 프로그램
 * 
 * 
 * */
package postfix;

import stack.MemoryException;

public class Main {
	
	public static void main(String[] args) throws MemoryException{

		Postfix postfix = new Postfix();
		
		String infixString = "( ( 30 + 5 ) / 5 )";
		String postfixString = postfix.convertInfixToPostFix(infixString);
		Integer evaluatedPostfixValue = postfix.evaluatePostfix(postfixString);

		System.out.println(infixString);
		System.out.println(postfixString);
		System.out.println(evaluatedPostfixValue);
		
	}

}
