package graph;

public class LinkedQueue {
	private class Node{
		
		private int data;
		private Node nextNode;
	
		Node(int data){
			this.data = data;
			this.nextNode = null;
		}
	}
	
	// 큐는 front노드와 rear노드를 가진다.
	private Node front;
	private Node rear;
	
	public LinkedQueue(){
		this.front = null;
		this.rear = null;
	}
	
	// 큐가 비어있는지 확인
	public boolean isEmpty(){
		return (front==null);
	}
	
	// item을 큐의 rear에 넣는다
	public void enQueue(int item){
		Node newNode = new Node(item);
		
		if(isEmpty()){
			front = newNode;
			rear = newNode;
			return;
		}
		rear.nextNode = newNode; 
		rear = newNode;
	}
	
	public int deQueue() { 
		if(isEmpty()){ 
			System.out.println("사이즈 초과");
		}
		int data = front.data; 
		front = front.nextNode; 
		
		if(front == null){
			//front를 제거하는데 front가 null이면 rear도 제거한다.
			rear = null;
		}
		
		return data; 
	}
	

}
