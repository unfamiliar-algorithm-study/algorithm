package linked_list;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		System.out.println("----linked list----");
		System.out.println("addfirst _ / addmiddle _ _ / addlast _ / delete _ / print / quit");
		
		
		
		
		LinkedList list = new LinkedList();
		
		String[] command=null;
		Scanner input = new Scanner(System.in);
		
		while(true){
			command = input.nextLine().split(" ");
			
			switch(command[0]){
			case "addfirst":
				list.addFirstNode(command[1]);
				break;
			case "addmiddle":
				list.addMiddleNode(command[1], command[2]);
				break;
			case "addlast":
				list.addLastNode(command[1]);
				break;
			case "delete":
				list.deleteNode(command[1]);
				break;
			case "print":
				System.out.println(list);
				break;
			case "quit":
				return;
			}
		}	
		
	}
}
