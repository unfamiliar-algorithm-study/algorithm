/*
 * 2016.9.1
 * 설명: 배열로 구현한 스택(순차차료구조)
 * 
 * */
package stack;

public class Main {
	
	public static void main(String[] args) throws MemoryException{
		
		System.out.println("----sequential Stack----");
		
		int stackSize = 10000000;
		
		String[] stackArray = new String[stackSize];
		Stack stack = new Stack(stackSize, stackArray);
		
		long start = System.currentTimeMillis();
		for(int i=0; i<stackSize; i++){
			stack.push(i+" ");
		}
		for(int i=0; i<stackSize; i++){
			stack.pop();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("input size:"+stackSize+" / 시간:"+(end-start)/1000.0);
	}

}
