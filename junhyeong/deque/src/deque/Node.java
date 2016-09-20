package deque;

public class Node {
	char data;
	Node llink;
	Node rlink;
	
	public Node(){
		this.llink = null;
		this.rlink = null;
	}
	
	public Node(char data){
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}
}
