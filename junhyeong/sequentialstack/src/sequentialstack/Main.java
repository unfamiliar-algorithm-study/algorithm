package sequentialstack;

public class Main {
	public static void main(String[] args){
		int stackSize = 100;
		Stack stack = new Stack(stackSize);
		
		for(int i=0; i<stackSize; i++){
			stack.push(i+" ");
		}
		System.out.print(stack);
	}

}
