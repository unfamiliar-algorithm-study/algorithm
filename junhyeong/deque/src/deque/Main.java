package deque;

public class Main {
	public static void main(String[] args){
		char deletedItem;
		Deque Q = new Deque();
		
		Q.insertFront('A');
		Q.print();
		
		Q.insertFront('B');
		Q.print();
		
		Q.insertFront('C');
		Q.print();
		
		deletedItem = Q.deleteFront();
		if(deletedItem != 0){
			System.out.println("Front deleted item : " + deletedItem);

		}
		Q.print();
		
		deletedItem = Q.deleteRear();
		if(deletedItem != 0){
			System.out.println("Rear Deleted Item: " + deletedItem);
			
		}
		Q.print();
		
		Q.insertRear('D');
		Q.print();
		
		Q.insertRear('E');
		Q.print();
		
		Q.insertRear('F');
		Q.print();
	}
}
