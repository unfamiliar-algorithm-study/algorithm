package binarysearchtree;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int value;
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insertBST(25);
		bst.insertBST(65);
		bst.insertBST(23);
		bst.insertBST(68);
		bst.insertBST(21);
		bst.insertBST(74);
		bst.insertBST(36);
		bst.insertBST(9);
		bst.insertBST(12);
		bst.insertBST(27);
		bst.insertBST(82);

		while(true){
			System.out.println("Root = " + bst.getRoot());

		System.out.print("insert print case");
		
		Scanner sc = new Scanner(System.in);
		value = sc.nextInt();
		
		System.out.println("Binary Tree >>>");
		bst.printBST(value);
		
		System.out.println("Is There \"A\" ?>>> ");
		TreeNode p1 = bst.searchBST('A');
		
		if(p1!= null){
			System.out.println(p1.data + "탐색 성공");
		} else{
			System.out.println("탐색 실패");
		}
		
		System.out.println("Is There \"E\" ?>>> ");
		TreeNode p2 = bst.searchBST('E');
		
		if(p2!= null){
			System.out.println(p2.data + " 탐색 성공");
		} else{
			System.out.println("탐색 실패");
		}
		}
	}
}
