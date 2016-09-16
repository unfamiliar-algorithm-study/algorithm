package main;

import tree.BinarySearchTree;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.add(8);
		bst.add(3);
		bst.add(2);
		bst.add(5);
		bst.add(10);
		bst.add(14);
		bst.add(11);
		bst.add(16);
		
		
		bst.preOrder();
		
		bst.delete(8);
		System.out.println();
		bst.preOrder();
		
		
		bst.delete(14);
		System.out.println();
		bst.preOrder();
	}
}
