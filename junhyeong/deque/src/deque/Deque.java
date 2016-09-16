package deque;

public class Deque {
	Node front;
	Node rear;
	
	public Deque(){
		front = null;
		rear = null;
	}
	
	public boolean isEmpty(){
		return(front==null);
	}
	
	public void insertFront(char item){
		Node node = new Node(item);
		if(isEmpty()){
			front = node;
			rear = node;
			node.rlink = null;
			node.llink = null;
		} else{
			node.rlink = front;
			node.llink = null;
			front.llink = node;
			front = node;
		}
	}
	
	public char deleteFront(){
		if(isEmpty()){
			System.out.println("Deque is empty");
			return 0;
		} else{
			char data = front.data;
			if(front.rlink == null){
				front = null;
				rear = null;
			} else{
				front = front.rlink;
				front.llink = null;
			}
			return data;
		}
	}
	
	public void insertRear(char item){
		Node node = new Node(item);
		if(isEmpty()){
			front = node;
			rear = node;
			node.rlink = null;
			node.llink = null;
		} else{
			node.llink = rear;
			node.rlink = null;
			rear.rlink = node;
			rear = node;
		}
	}
	
	public char deleteRear(){
		if(isEmpty()){
			System.out.println("Deque is empty");
			return 0;
		} else{
			char data = rear.data;
			if(rear.rlink == null){
				front = null;
				rear = null;
			} else{
				rear = rear.rlink;
				rear.llink = null;
			}
			return data;
		}
	}
	
	public void removeFront(){
		if(isEmpty()){
			System.out.println("Deque is empty");
		} else{
			if(front.rlink == null){
				front = null;
				rear = null;
			} else{
				front = front.rlink;
				front.llink = null;
			}
		}
	}
	
	public void removeRear(){
		if(isEmpty()){
			System.out.println("Deque is empty");
		} else{
			if(rear.rlink == null){
				front = null;
				rear = null;
			} else{
				rear = rear.rlink;
				rear.rlink = null;
			}
		}
	}
	
	public char peekRear(){
		if(isEmpty()){
			System.out.println("Deque is empty");
			return 0;
		} else{
			return rear.data;
		}
	}
	
	public void print(){
		if(isEmpty()){
			System.out.println("Deque is empty");
		} else{
			Node node = front;
			while(node != null){
				System.out.println(node.data + "");
				node = node.rlink;
			}
			System.out.println();
		}
	}
}
