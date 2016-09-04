package stack;

public class Stack {

	private Node top;
	
	public Stack(){
		top=null;
	}
	
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void push(String data){
		Node newNode = new Node(data);
		if(isEmpty()){
			top = newNode;
			return;
		}
		newNode.link = top;
		top = newNode;
	}
	
	public String pop() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		String data = top.data;
		top = top.link;
		return data;
	}
	
	public String peek(){
		if(isEmpty()){
			return null;
		}
		return top.data;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		Node pointer = top;
		while(pointer != null){
			sb.append(pointer.data+" ");
			pointer = pointer.link;
		}
		return sb.toString();
	}
	
	private class Node{
		String data;
		Node link;
		
		Node(){
			this.data = null;
			this.link = null;
		}
		Node(String data){
			this.data = data;
			this.link = null;
		}
	}
}
