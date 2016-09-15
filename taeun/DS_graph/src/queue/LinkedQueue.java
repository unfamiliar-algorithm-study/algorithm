/*
 * 2016.9.5
 * 링크드리스트를 이용한 큐구현 
 */
package queue;

import exception.MemoryException;

public class LinkedQueue<T> {

	private Node front;
	private Node rear;

	public LinkedQueue(){
		this.front = null;
		this.rear = null;
	}

	public boolean isEmpty(){ //프론트랑 꼬리가널이면 빈것으로 간주
		if(front == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void enQueue(T data){ //꼬리에 인
		Node newNode = new Node(data);
		
		if(isEmpty()){ //비었을때는 front와 rear가 가르키기만 하면된다.
			front = newNode;
			rear = newNode;
			return;
		}
		rear.link = newNode; //안비었으면 꼬리노드에 newNode연결 
		rear = newNode; //꼬리포인터는 newNode를 가르키게됨 
	}
	
	public T deQueue() throws MemoryException{ //프론트 데이터 디큐
		if(isEmpty()){ //비었으면 언더플로 
			throw new MemoryException("under flow");
		}
		T data = front.data; //프론트데이터 임시저장 
		front = front.link; //프론트포인터 우측한칸이동
		return data; //데이터 반환
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		Node pointer = front; //첫 노드를 가르키게하는 포인터변수
		
		System.out.println(pointer+"+"+rear);
		
		while(pointer!=null){ //계속돈다 
			sb.append(pointer.data+" ");
			pointer = pointer.link; //포인터를 이동한다 
		}
		return sb.toString();
	}
	
	private class Node{ //내부 프라이빗 노드 클래스다 캡슐화.프라이빗@!
		T data;
		Node link;
		Node(){
			this.data = null;
			this.link = null;
		}
		Node(T data){
			this.data = data;
			this.link = null;
		}
	}
}
