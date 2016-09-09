/*
 * 2016.9.5
 * 1차원 배열을 이용한 큐구현 
 * */
package queue;

import exception.MemoryException;

public class SequentialQueue {

	private int front;
	private int rear;
	private int queueSize;
	private String[] queueArray;
	
	public SequentialQueue(int queueSize, String[] queueArray){
		this.front = -1; //front 와 rear모두 -1을 갈키구있다.
		this.rear = -1;
		this.queueSize = queueSize;
		this.queueArray = queueArray;
	}
	
	public boolean isEmpty(){
		if(front == rear){ //둘이 똑같은 인덱스이면 빈것으로 간주 
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(rear == queueSize -1){ //rear가 큐사이즈보다 하나작으면 꽉찻다.
			return true;
		}else{
			return false;
		}
	}
	
	public void enQueue(String data) throws MemoryException{
		if(isFull()){
			throw new MemoryException("over flow");
		}
		queueArray[++rear] = data; //rear인덱스를 한칸 우측이동하고 거기에 데이터를 인큐한다.
	}
	
	public String deQueue() throws MemoryException{
		if(isEmpty()){
			throw new MemoryException("under flow");
		}
		return queueArray[++front]; //front를 한칸 옮기고 그데이터를 디큐한다. 리턴. 
	}
	
	@Override 
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=front+1 ; i <= rear; i++){ //front~rear까지 출력한다. 
			sb.append(queueArray[i]);
		}
		return sb.toString();
	}
}
