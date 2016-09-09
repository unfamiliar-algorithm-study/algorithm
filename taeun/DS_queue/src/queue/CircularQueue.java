package queue;

import exception.MemoryException;

public class CircularQueue {
	
	private int front;
	private int rear;
	private int queueSize;
	private String[] circularQueueArray;
	
	public CircularQueue(int queueSize, String[] circularQueueArray){
		this.front = 0;
		this.rear = 0;
		this.queueSize = queueSize;
		this.circularQueueArray = circularQueueArray;
	}
	
	public boolean isEmpty(){
		if(front == rear){
			return true;
		}else{
			return false;
		}
	}

	public boolean isFull(){
		if(front == ((rear + 1) % queueSize)){
			return true;
		}else{
			return false;
		}
	}
	
	public void enQueue(String data) throws MemoryException{
		if(isFull()){
			throw new MemoryException("over flow");
		}
		rear = ((rear + 1) % queueSize);
		circularQueueArray[rear] = data;
	}
	
	public String deQueue() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		front = ((front + 1) % queueSize);
		String data = circularQueueArray[front];
		return data;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		
		StringBuilder sb = new StringBuilder();
		
		int i=1;
		int pointer= (front + 1) % queueSize;

		while(true){
			
			pointer = (front + i) % queueSize;
			sb.append(circularQueueArray[pointer] + " ");
			i++;
			if(pointer == rear){
				break;
			}
		}
		return sb.toString();
	}
	
}
