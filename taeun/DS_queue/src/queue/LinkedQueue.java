package queue;

import exception.MemoryException;

public class LinkedQueue {

	private Node front;
	private Node rear;

	public LinkedQueue(){
		this.front = null;
		this.rear = null;
	}

	public boolean isEmpty(){
		if(front == null && rear == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void enQueue(String data){
		Node newNode = new Node(data);
		
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		rear.link = newNode;
		rear = newNode;
	}
	
	public String deQueue() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		
		String data = front.data;
		front = front.link;
		return data;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		
		Node pointer = front;
		while(true){
			sb.append(pointer.data+" ");
			pointer = pointer.link;
			
			if(pointer == rear){
				break;
			}
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
