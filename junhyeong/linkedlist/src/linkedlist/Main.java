package linkedlist;

public class Main {
	public static void main(String[] args){
		LinkedList numbers = new LinkedList();
		numbers.addFirst(50);
		numbers.addFirst(10);
		numbers.add(2, 100);
		numbers.addLast(20);
		numbers.addLast(30);

		System.out.println("size = " + numbers.size());
		System.out.println("index '3' = " + numbers.get(3));
		System.out.println("index of '30' = " + numbers.indexOf(30));
		
		LinkedList.ListIterator li = numbers.listIterator();
		System.out.println("use iterator first = " + li.next());
		System.out.println("use iterator second = " + li.next());
		
		while(li.hasNext()){
		    if((int)li.next() == 20)
		    	li.add(40);
		}		
		System.out.println(numbers);
		
	}
}
