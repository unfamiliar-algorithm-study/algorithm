package stack;

public class Stack<T> {

	protected Node top;
	
	public Stack(){
		top = null;
	}
	
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void push(T data){
		Node newNode = new Node(data);
		if(isEmpty()){
			top = newNode;
			return;
		}
		newNode.link = top;
		top = newNode;
	}
	
	public T pop() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		T data = top.data;
		top = top.link;
		return data;
	}
	
	public T peek(){
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
	
	protected class Node{
		T data;
		Node link;
		
		protected Node(){
			this.data = null;
			this.link = null;
		}
		protected Node(T data){
			this.data = data;
			this.link = null;
		}
	}
	
}
