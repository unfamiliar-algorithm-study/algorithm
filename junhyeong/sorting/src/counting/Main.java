package counting;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		int[] A = {2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4};
		System.out.println("A[] = " + Arrays.toString(A));
		Counting counting = new Counting();
		int[] B = counting.sort(A);
		System.out.println("정렬된 A[] = " + Arrays.toString(B));
	}
}
