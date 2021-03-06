package sequentialstack;

public class Stack {
	private int top;
	private int stackSize;
	private String[] stackArray;
	
	public Stack(int stackSize){
		this.top = 0;
		this.stackSize = stackSize;
		this.stackArray = new String[stackSize];
	}
	
	public boolean isEmpty(){
		if(top == 0)
			return true;
		else
			return false;
		
	}
	
	public boolean isFull(){

		if(top == stackSize)
			return true;
		else
			return false;
	}
	
	
	public void push(String data){		
		if(!isFull())
			stackArray[top++] = data;
		else
			System.out.println("Stack is Full");	
	}
	
	public String pop(){
		if(!isEmpty())
			return stackArray[--top];
		else{
			System.out.println("Stack is Empty");
			return "false";
		}
	}

	public String toString(){
		String str = "[";
		if(!isEmpty()){
			for(int i = 0; i<stackSize -1; i++){
				str += pop() + ",";
			}
			str += pop() + "]";
			return str;
		}
		else{
			str = "Stack is Empty";
			return str;
		}
	}
}
