/**
 * 
 */
package tree;

import except.PkCustomExcept;

/**
 * @author yenos
 * @date 2016. 9. 14.
 * 바이너리 서치를 구현해보자!
 */
public class binarySearch {
	public class Node {
		int data;
		Node left;
		Node right;
	}

	Node startNode;

	public void insertNode(int data) {
		if (startNode == null) {
			Node node = new Node();
			node.data = data;

			startNode = node; // 최초 시작 시 노드의 값이 없을수있음으로.
		} else {
			// root가 존재할 경우다음데이터를 넣어준다.
			insertNode(data, startNode);
		}
	}

	public void insertNode(int data, Node node) {

		// 노드에 따라 달라질경우.
		// 데이터를 비
		if (data <= node.data) {
			// 들어갈 데이터가 작으면 왼쪽으로 이동 널이면 새로운것을 넣어주면 되는것이고, 널이 아니 해당노드로 다시 탐색에
			// 들어가면된다.
			if (node.left == null) {
				Node newNode = new Node();
				newNode.data = data;
				node.left = newNode;
			} else {
				insertNode(data, node.left);
			}
		} else {
			if (node.right == null) {
				Node newNode = new Node();
				newNode.data = data;
				node.right = newNode;
			} else {
				insertNode(data, node.right);
			}
		}
	}

	// 전위순위알고리즘
	// DLR
	public void preOrder(Node node) {
		if (node == null) {
		} else {
			System.out.print(node.data + "=>");
			preOrder(node.left);
			preOrder(node.right);
		}

	}

	// 중위순위알고리즘
	// LDR
	public void inOrder(Node node) {
		if (node == null) {
		} else {

			inOrder(node.left);
			System.out.print(node.data + "=>");
			inOrder(node.right);
		}
	}
	// 후위순위 알고리즘
	// LRD

	public void postOrder(Node node) {
		if (node == null) {

		} else {

			postOrder(node.left);
			postOrder(node.right);

			System.out.print(node.data + "=>");
		}
	}

	public void remove(int data) {
		
		boolean isChildLeft = false;
		// 시작노드가 존재한다면..
		if (startNode != null) {
			searchNode(data, startNode);

			System.out.println("child==>" + searchedChildNode.data);
			System.out.println("parent==>" + searchedParentdNode.data);

			// searchNode가 값이 없을떄의 예외처리가 피요함.

			//부모의 어느쪽에 달려있는지 판단.
			if (searchedParentdNode.left.data == searchedChildNode.data) {
				isChildLeft  = true;
			}				
			else if (searchedParentdNode.right.data == searchedChildNode.data) {
				isChildLeft  = false;
			}
			
			
			// 1. 만약 뒤에 연결된것이 없다면?
			// 그냥 현재 로드만 날리면된다.==> 부모의 왼쪽 혹은 오른쪽의 데이터를 찾아서 같은 녀석을 null 로만든다.
			if (searchedChildNode.left == null && searchedChildNode.right == null) {

				if(isChildLeft ){
					searchedParentdNode.left = null;
				}else{
					searchedParentdNode.right = null;
				}
				
			}
			//2. 만약 뒤에 연결된것이 있다면?
			// 2.1 부모의 어느쪽에 달렸는지 판단후 
			// 2.2 부모의 원래 달렸던부분에 뒤에 것을 붙여주면된다.
			
			//차일드에 한쪽에 매달려있을경우.
			// 왼쪽이 널이거나 오른쪾이 널이거나. ==>둘다 널일경우는 위에서 걸리니 걱정 ㄴㄴㄴ 
			else if(searchedChildNode.left==null || searchedChildNode.right==null){
				
				//왼쪽이 널이니? 
				// 널이면 오른쪽을 반환하고
				// 널이아니면 왼쪽을 반환한다.
				Node tmp = searchedChildNode.left == null ? searchedChildNode.right : searchedChildNode.left;
				
				//부모의 왼쪽인지 오른쪽인지 판단한후. 널이 아닌 한쪽(즉 존재하는 차일들에 달려있는 노드를 붙여준다.)
				if(isChildLeft ){
					searchedParentdNode.left = tmp;
				}else{
					searchedParentdNode.right = tmp;
				}
				
				
				
			}
			//둘다 널이 아닐경우 가득 찰경우.
			//이경우는 크기비교를 해서 is Left의 여부에따라 알맞게 붙여줘야한다.
			else{
//				if(searchedChildNode.left.data>)
				
				//차일드가 왼쪽에 잡혀있다? 
				//=> 부모보다 작다. =>오른쪽 손자 부모 에게 . 오른쪽손자의 왼쪽은 왼쪽 손자이도록. 
				if(isChildLeft ){
					//오른쪽 손자의 맨왼쪽에 왼쪽 손자가 붙어야하고.(왼쪽으로) => 오른쪾손자를올리면됨. 
//					searchedChildNode.left =
					//오른쪽 손자가 부모의 왼쪽에 붙는다.
					searchedParentdNode.left= searchedChildNode.right;
					//왼쪽손자는 오른쪽손자의 왼쪽후손 맨 아래에 붙어야한다.
					//검색을하고.
					searchLastLeft(searchedChildNode);
//					//오른쪽손자의 마지막의 왼쪽에 붙여놓는다.
					searchedLastLeftNode.left = searchedChildNode.left;
					
				}else{
					searchedParentdNode.right = searchedChildNode.right;
					
					searchLastLeft(searchedChildNode);
//					//오른쪽손자의 마지막의 왼쪽에 붙여놓는다.
					searchedLastLeftNode.left = searchedChildNode.left;
				}
				
			}
			
		} else {
			new PkCustomExcept("시작 노드가 없서여 ");			

		}
	}

	private Node searchedChildNode = new Node();
	private Node searchedParentdNode = new Node();

	public void searchNode(int data, Node node) {
		System.out.println(node.data);
		if (data < node.data) {
			if (node.left == null) {
			} else {
				searchedParentdNode = node;
				searchNode(data, node.left);
			}
		} else if (data > node.data) {
			if (node.right == null) {
			} else {
				searchedParentdNode = node;
				searchNode(data, node.right);
			}
		} else {
			searchedChildNode = node;
		}
	}

	private Node searchedLastLeftNode = new Node();
	
	public void searchLastLeft(Node node){
		if(node.left==null ){
			
			searchedLastLeftNode = node;
		}else{
			searchLastLeft(node);
		}
		
	}
}
