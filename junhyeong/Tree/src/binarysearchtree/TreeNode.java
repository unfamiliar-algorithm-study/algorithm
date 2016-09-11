package binarysearchtree;

public class TreeNode {
	public int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Object getData(){
		return data;
	}
}