package heap;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		int[] A = new int[] {5, 54, 21, 34, 65, 32, 6, 7, 1, 10};
		Heap heap = new Heap();
		
		System.out.println("A[] = " + Arrays.toString(A));
		
		heap.sort(A);

		System.out.println("정렬된 A[] = "+ Arrays.toString(A));
	}
}
