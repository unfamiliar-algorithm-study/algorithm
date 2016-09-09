/*
 * @author: taeun
 * 2016.9.7
 * 선형리스트 1차원배열 순차자료구조방식
 * */
package sequential;

import java.util.Scanner;

import exception.MemoryException;
import exception.UnexpectedIndexException;

public class Main {

	public static void main(String[] args) throws MemoryException, UnexpectedIndexException{
		
		System.out.println("----sequential list----");
		System.out.println("example command: add 3(value), addmiddle 3 1(value, index), delete 0(index), print, quit\n");
		
		int size = 3;
		SequentialArray sa = new SequentialArray(size);
		
		Scanner input = new Scanner(System.in);
		String command[];
		while(true){
			System.out.print("input command: ");
			command = input.nextLine().split(" ");
			
			switch(command[0]){
			case "add":
				sa.add(Integer.parseInt(command[1]));
				break;
			case "addmiddle":
				sa.addMiddle(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				break;
			case "delete":
				sa.delete(Integer.parseInt(command[1]));
				break;
			case "print":
				System.out.println(sa);
				break;
			case "quit":
				return;
			}
		}
	}
}
