package linkedstack;

public class Main {
	public static void main(String[] args){
		int inputSize = 100;
		Stack stack = new Stack();
		
		for(int i=0; i<inputSize; i++){
			stack.push(i+" ");
		}
		
		System.out.print(stack);
	}
}
