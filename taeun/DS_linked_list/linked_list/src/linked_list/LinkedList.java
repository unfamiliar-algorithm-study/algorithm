package linked_list;

public class LinkedList {
	
	private Node head;
	
	public LinkedList(){
		this.head = null;
	}
	
	public boolean isEmpty(){
		if(head==null){
			return true;
		}else{
			return false;
		}
	}
	
	public void addFirstNode(String data){
		Node newNode = new Node(data);
		
		if(isEmpty()){
			head = newNode;
			return;
		}
		newNode.link = head;
		head = newNode;
	}
	
	public void addMiddleNode(String findData, String inputData){
		Node newNode = new Node(inputData);
		if(isEmpty()){
			head = newNode;
			return;
		}

		Node findNode = searchNode(findData);
		newNode.link = findNode.link;
		findNode.link = newNode;
	}

	public void addLastNode(String inputData){
		Node newNode = new Node(inputData);
		if(isEmpty()){
			head = newNode;
			return;
		}
		
		Node pointer = head;
		while(pointer.link != null){
			pointer = pointer.link;
		}
		pointer.link = newNode;
	}
	
	public void deleteNode(String data){
		Node preNode = searchPreNode(data);
		if(preNode == null){
			return;
		}else if(preNode == head){
			head = head.link;
		}else{
			preNode.link = preNode.link.link;
		}
	}
	
	public Node searchPreNode(String data){
		if(isEmpty()){
			return null;
		}
		Node pointer = head;
		Node prePointer = pointer;
		
		while(pointer != null){
			if(pointer.data.equals(data)){
				return prePointer;
			}
			prePointer = pointer;
			pointer = pointer.link;
		}
		return prePointer;
	}
	
	public Node searchNode(String data){
		if(isEmpty()){
			return null;
		}
		
		Node pointer = head;
		while(pointer != null){
			if(pointer.data.equals(data)){
				return pointer;
			}
			pointer = pointer.link;
		}
		return pointer;
	}
	
	@Override
	public String toString(){
		if(isEmpty()){
			return "-";
		}
		
		StringBuilder sb = new StringBuilder();
		Node pointer = head;
		while(pointer != null){
			sb.append(pointer.data+" ");
			pointer = pointer.link;
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
