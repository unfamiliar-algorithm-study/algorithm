package stack;

public class Stack {

	private int top;
	private int stackSize;
	private String[] stackArray;
	
	public Stack(int stackSize, String[] stackArray){
		this.top = -1;
		this.stackSize = stackSize;
		this.stackArray = stackArray;
	}

	public boolean isEmpty(){
		if(top==-1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(top==stackSize-1){
			return true;
		}else{
			return false;
		}
	}
	
	public void push(String data) throws MemoryException{
		
		if(isFull()){
			throw new MemoryException("over flow");
		}
		stackArray[++top] = data;
	}
	
	public String pop() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		return stackArray[top--];
	}
	
	public String peek(){
		if(isEmpty()){
			return null;
		}
		return stackArray[top];
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		
		int pointer = top;
		while(pointer != -1){
			sb.append(stackArray[pointer--]+" ");
		}
		return sb.toString();
	}
}
