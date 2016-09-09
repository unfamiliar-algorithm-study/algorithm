package queue;

import exception.MemoryException;

public class SequentialQueue {

	private int front;
	private int rear;
	private int queueSize;
	private String[] queueArray;
	
	public SequentialQueue(int queueSize, String[] queueArray){
		this.front = -1;
		this.rear = -1;
		this.queueSize = queueSize;
		this.queueArray = queueArray;
	}
	
	public boolean isEmpty(){
		if(front == rear){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(rear == queueSize -1){
			return true;
		}else{
			return false;
		}
	}
	
	public void enQueue(String data) throws MemoryException{
		if(isFull()){
			throw new MemoryException("over flow");
		}
		queueArray[++rear] = data;
	}
	
	public String deQueue() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		return queueArray[++front];
	}
	
	@Override 
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=front+1 ; i <= rear; i++){
			sb.append(queueArray[i]);
		}
		return sb.toString();
	}
}
