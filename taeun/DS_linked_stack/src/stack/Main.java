/*
 * 2016.9.1
 * 설명: 링크드리스트로 구현한 스택. 
 * input size:10000000 / 시간:29.284
 * */
package stack;

public class Main {

	public static void main(String[] args) throws MemoryException{
		
		
		System.out.println("---linked stack----");
		
		int inputSize = 10000000;
		Stack stack = new Stack();
		
		long start = System.currentTimeMillis();
		for(int i=0; i<inputSize; i++){
			stack.push(i+" ");
		}
		for(int i=0; i<inputSize; i++){
			stack.pop();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("input size:"+inputSize + " / 시간:"+ (end-start)/1000.0);
	}
}
