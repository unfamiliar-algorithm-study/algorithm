package binarysearchtree;

public class BinarySearchTree {
	private TreeNode root;
	private int count = 0;
	
	public int getRoot(){
		
		TreeNode temp = root.left.left;
		return temp.data;
	}
	
	public TreeNode insertKey(TreeNode root, int data){
		TreeNode parent = root;
		TreeNode newNode = new TreeNode(data);
		
		if(parent == null){
			
			return newNode;
		}else if(parent.data > newNode.data){
			parent.left = insertKey(parent.left, data);
			
			return parent;
		}else if(parent.data < newNode.data){
			parent.right = insertKey(parent.right, data);
			
			return parent;
		}else{
			
			return parent;
		}
	}
	
	public void insertBST(int data){
		root = insertKey(root, data);
	}
	
	public TreeNode searchBST(int data){
		TreeNode parent = root;
		while(parent!= null){
			if(data < parent.data) 
				parent = parent.left;
			else if(data > parent.data)
				parent = parent.right;
			else
				return parent;
		}
		return parent;
	}
	
	public void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public void preorder(TreeNode root){
		if(root != null){
			System.out.print(root.data + " ");
			inorder(root.left);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			inorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void printBST(int number){
		
		switch(number){
		case 1:
			preorder(root);
			System.out.println();
			break;
		case 2:
			inorder(root);
			System.out.println();
			break;
		case 3:
			postorder(root);
			System.out.println();
			break;
		}
	}
	
	public boolean delete(int keyData){
		TreeNode current = root;
		TreeNode parent = current;
		
		while(current.data != keyData)
		{
			if(current == null)
				//해당 데이터 가지는 노드 없으므로 삭제 종료
				return false;
			
			parent = current;
			if(keyData < current.data)
				current = current.left;
			else
				current = current.right;
			
		}
		
		//키값을 가지는 노드의 자식노드가 존재 하지 않을때
		if(current.left== null && current.right== null){
			if(current == root)
				//현재 노드가 루트일때 트리 삭제
				root = null;
			else if(current == parent.left)
				parent.left= null;
			else
				parent.right= null;
		}
		
		//왼쪽 자식 노드가 존재할 때
		else if(current.right== null){
			if(current == root)
				root = current.left;
			
			else if(current == parent.left)
				parent.left= current.left;
			
			else
				parent.right= current.left;
		}
		
		//오른쪽 자식 노드가 존재할 때
		else if(current.left == null){
			if(current == root)
				root = current.right;
			
			else if(current == parent.left)
				parent.left= current.right;
			
			else
				parent.right= current.right;
		}
		
		//자식이 두 곳 다 존재할때
		else{
			TreeNode candidate = getMinNode(current);
			
			if(current == root)
				root = candidate;
			else if(current == parent.left)
				parent.left = candidate;
			else
				parent.right= candidate;
			
			candidate.left= current.left;
		}
		return true;
	}
	private TreeNode getMinNode(TreeNode deleteNode){
		TreeNode candidateParent = deleteNode;
		TreeNode candidate = candidateParent.right;
		
		//삭제노드 오른쪽 자식의 왼쪽 자손 찾기
		while(candidate.left!= null){
			candidateParent = candidate;
			candidate = candidate.left;
		}
		
		//후보노드가 삭제노드 오른쪽 자식의 왼쪽 자손일 때
		if(candidate != deleteNode.right){
			//candidateParent.rightChild.leftChild 
			//!= candidateParent.rightChild
			candidateParent.left = candidate.right;
			candidate.right = deleteNode.right;
		}
		
		return candidate;
	}
}
