/*
 * 2016.9.5
 * 링크드 리스트를 이용한 덱구현 
 * 덱은 큐의 양쪽에서 enqueue, dequeue모두 가능한 자료구조이다.
 *
 * scroll : 입력제한 덱. 입력이 한쪽에서만 가능, 출력은 양쪽모두 가능 
 * shelf : 출력제한 덱. 출력이 한쪽에서만 가능, 입력은 양쪽모두 가능
 * 
 * */
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
		if(front == null && rear == null){ //맨 첫노드와 꼬리노드가 널이면 빈것으로 간주한다. 
			return true;
		}else{
			return false;
		}
	}
	
	public void addFront(String data){ //front에 enqueue  
		Node newNode = new Node(data);
		
		if(isEmpty()){ //빈 큐라면 프론트, 꼬리 모두 newNode를 가르키게한다. 
			front = newNode;
			rear = newNode;
			return;
		}
		newNode.rightLink = front; //빈큐가 아니라면, newNode의 rightLink는 처음노드를 가르키게 한다.
		front.leftLink = newNode; //front가 가르키고있던것(첫노드)의 leftLink는 newNode를 가르켜야한다. 
		front = newNode; //맨첫노드가 newNode로 바뀌었으니까 front는 newNode를 갈켜야함..
	}
	
	public void addLast(String data){ //rear에 enqueue하기 
		Node newNode = new Node(data);
		
		if(isEmpty()){ //비었을때 
			front = newNode;
			rear = newNode;
			return;
		}
		newNode.leftLink = rear; //안비었을때 (add first와 동일한개념) 
		rear.rightLink = newNode;
		rear = newNode;
	}
	
	public String deleteFront() throws MemoryException{ //front에서 dequeue 
		if(isEmpty()){ //비었으면 언더플뤄
			throw new MemoryException("under flow");
		}
		String data = front.data; //안비었으면 데이터 임시저장후  
		front = front.rightLink; //front를 우측 한칸옮기고 (삭제)
		front.leftLink = null;
		return data; //데이터 리턴. 
	}
	
	public String deleteLast() throws MemoryException{ //rear에서 dequeue
		if(isEmpty()){ //비었으면 언더플로 
			throw new MemoryException("under flow");
		}
		String data = rear.data; //안비었으면 데이터 임시저장후 
		rear = rear.leftLink; //rear를 좌이동 한칸 (삭재)
		rear.rightLink = null;
		return data;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		Node pointer = front; //포인터는 첫번째 노드를 갈킨다.
		while(pointer != null){ //포인더가 널이아닐때까지 돈다. 
			sb.append(pointer.data+" ");
			pointer = pointer.rightLink; //포인터 우측이동 
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
