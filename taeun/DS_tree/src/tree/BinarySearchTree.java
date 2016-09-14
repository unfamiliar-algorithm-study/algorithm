package tree;

/**
  * @FileName : BinarySearchTree.java
  * @Date : 2016. 9. 15. 
  * @author : ChoiTaeEun
  * @description : 재귀를 이용한 이진탐색트리의 삽입 삭제 중위,후위,전위순회 구현 (..하...어려워;;)  
  */
public class BinarySearchTree {

	private Node root;
	
	public boolean isEmpty(){
		if(root == null){
			return true;
		}else{
			return false;
		}
	}

	public void add(Integer data){
		root = add(root, data); //리턴된 루트트리를 루트에갖다붙인다. 
	}
	
	public Node add(Node root ,Integer data){ 
		
		Node newNode = new Node(data);
		
		if(root == null){ //받은 트리의 루트가 널이면 그냥 새로운 노드 리턴.
			return newNode;
		}else if(root.data > data){  //현재 루트노드보다 값이 작으면 왼쪽에 붙인다.
			root.leftLink = add(root.leftLink, data);
			return root;
		}else{ //현재 루트노드보다 값이 크면 오른쪽에 붙인다.
			root.rightLink = add(root.rightLink, data);
			return root;
		}
		
	}
	
	public void delete(Integer data) throws Exception{
		
		Node pointer = search(data); //삭제할 노드의 포인터 
		Node prePointer = searchPre(data); //삭제할 노드의 부모 포인터 
		
		if(pointer.leftLink == null && pointer.rightLink == null){ //말단 노드일때 
			
			if(prePointer.leftLink == pointer){ //부모의 왼쪽에 달려있는경우   
				prePointer.leftLink = null;
			}else{ //부모의 오른쪽에 달려있는경우 
				prePointer.rightLink = null;
			}
			
		}else if(pointer.leftLink == null || pointer.rightLink == null){ //자식이 하나있는노드 일때 
			
			if(prePointer.leftLink == pointer && pointer.rightLink == null){ //부모의 왼쪽에달려있음 & 왼쪽자식만 있음 
				prePointer.leftLink = pointer.leftLink;
			}else if(prePointer.leftLink == pointer && pointer.leftLink == null){ //부모의 왼쪽에달려있음 & 오른쪽자식만 있음
				prePointer.leftLink = pointer.rightLink;
			}else if(prePointer.rightLink == pointer && pointer.rightLink == null){ //부모의 오른쪽에 달려있음 & 왼쪽자식만 있음
				prePointer.rightLink = pointer.leftLink;
			}else if(prePointer.rightLink == pointer && pointer.leftLink == null){ //부모의 오른쪽에 달려있음 & 오른쪽자식만 있음
				prePointer.rightLink = pointer.rightLink;
			}
			
		}else{ //자식이 둘인경우
			
			Node childMinNode = getMinNode(pointer.rightLink); //오른쪽 부트리에서 가장 작은노드 찾기 (지울노드의 후보노드찾기)
			
			int tmpData = childMinNode.data; 
			delete(childMinNode.data); //후보노드(는무조건 자식이 없거나 하나만있음) 을 다시 삭제.
			pointer.data = tmpData; //하고나서 원래지우려던곳의 데이터를 후보노드로 체인지
		}
	}
	
	public Node getMinNode(Node root){ //후보노드찾기 
		if(root.leftLink == null){ //왼쪽자식이 더이상없으면 자신을 리턴 
			return root;
		}else{ //있으면 계속쭊쭉 왼쪽으로(가장 작은거 찾으려구) 
			return getMinNode(root.leftLink);
		}
		
	}
	
	public Node search(Integer data) throws Exception{ //데이터 서치 메소드
		return search(root, data);
	}
	
	private Node search(Node root, Integer data) throws Exception{

		if(root == null || root.data == data){ //루트가 널일때 or 못찾은경우 or 루트가 데이터인경우. 
			return root;
		}else if(root.data > data){ //찾으려는 데이터가 더 큰경우 
			return search(root.leftLink, data); //왼쪽으로 내려감 
		}else if(root.data < data){ //찾으려는 데이터가 더 작은경우 
			return search(root.rightLink, data); //오른쪽으로 내려감 
		}else{
			throw new Exception("unknown exception");
		}
		
	}
	
	public Node searchPre(Integer data) throws Exception{ //찾으려는 데이터의 직전 부모노드 찾기 
		return searchPre(root, data);
	}
	
	private Node searchPre(Node root, Integer data) throws Exception{
		
		if(root == null || root.data == data){ //루트가 널일때 or 찾는데이터가 없을때 or 루트가 찾는값일때.
			return null; //부모는 널.
		}

		if(root.leftLink.data == data || root.rightLink.data == data){  //찾는노드의 자식중에 찾는값이 있을때 
			return root; //자신(부모)를 리턴.
		}else{ // 아니면 
			if(root.data > data){ //데이터가 자신보다 작을때 
				return searchPre(root.leftLink, data); //왼쪽으로 내려감 
			}else if(root.data < data){ //데이터가 자신보다 클때 
				return searchPre(root.rightLink, data); //오른쪽으로 내려감
			}else{
				throw new Exception("unknown exception");
			}
		}
	}
	
	public void preOrder(){ //전위순회
		preOrder(root);
	}
	
	private void preOrder(Node node){  
		if(node != null){ 
			System.out.print(node.data+" "); //자기를찍고 
			preOrder(node.leftLink); //왼쪽으로 내려감 
			preOrder(node.rightLink); //오른쪽으로 내려감 
		}
	}

	public void inOrder(){ //중위순회
		inOrder(root);
	}
	
	private void inOrder(Node node){  
		if(node != null){
			inOrder(node.leftLink);
			System.out.print(node.data+" ");
			inOrder(node.rightLink);
		}
	}
	
	public void postOrder(){ //후위순회
		postOrder(root);
	}
	
	private void postOrder(Node node){ 
		if(node != null){
			postOrder(node.leftLink);
			postOrder(node.rightLink);
			System.out.print(node.data+" ");
		}
	}
	
	private class Node{
		Integer data;
		Node leftLink;
		Node rightLink;
		
		Node(){
			this.data = null;
			this.leftLink = null;
			this.rightLink = null;
		}
		
		Node(Integer data){
			this.data = data;
			this.leftLink = null;
			this.rightLink = null;
		}
	}
}
