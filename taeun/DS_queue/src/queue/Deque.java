package queue;

import java.awt.Font;

import exception.MemoryException;

public class Deque {

	private Node front;
	private Node rear;
	
	public Deque(){
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
	
	public void addFront(String data){
		Node newNode = new Node(data);
		
		if(isEmpty()){
			front = newNode;
			rear = newNode;
			return;
		}
		newNode.rightLink = front;
		front.leftLink = newNode;
		front = newNode;
	}
	
	public void addLast(String data){
		Node newNode = new Node(data);
		
		if(isEmpty()){
			front = newNode;
			rear = newNode;
			return;
		}
		newNode.leftLink = rear;
		rear.rightLink = newNode;
		rear = newNode;
	}
	
	public String deleteFront() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		String data = front.data;
		front = front.rightLink;
		front.leftLink = null;
		return data;
	}
	
	public String deleteLast() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		String data = rear.data;
		rear = rear.leftLink;
		rear.rightLink = null;
		return data;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		Node pointer = front;
		while(pointer != null){
			sb.append(pointer.data+" ");
			pointer = pointer.rightLink;
		}
		return sb.toString();
	}
	
	private class Node{
		
		String data;
		Node leftLink;
		Node rightLink;
		
		Node(){
			this.data = null;
			this.leftLink = null;
			this.rightLink = null;
		}
		
		Node(String data){
			this.data = data;
			this.leftLink = null;
			this.rightLink = null;
		}
	}
}
