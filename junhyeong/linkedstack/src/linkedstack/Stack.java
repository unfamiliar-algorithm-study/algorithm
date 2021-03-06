package linkedstack;

public class Stack {
	private Node top;
	
	public Stack(){
		top = null;
	}
	
	public void push(String data){
		Node newNode = new Node(data);
		newNode.link = top;
		top = newNode;
	}
	
	public String pop(){
		if(isEmpty()){
			String str = "END";
			return str;
		}
		top = top.link;
		return top.data;
	}
	
	public boolean isEmpty(){
		if(top == null)
			return true;
		else
			return false;
	}
	
	private class Node{
		String data;
		Node link;
		public Node(){
			
		}
		public Node(String data){
			this.data = data;
			this.link = null;
		}
	}
	
	public String toString(){
		String str = "[";
		if(!isEmpty()){
			while(top.link.link != null){
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
