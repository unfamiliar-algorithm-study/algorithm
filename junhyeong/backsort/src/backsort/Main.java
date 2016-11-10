package backsort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = null;
		boolean[] result = null;
		int sub = 0;
		int length;
		
		int test = sc.nextInt();
		for(int i =0; i<test; i++){
			length = sc.nextInt();
			arr = new int[length];
			result = new boolean[test];
			
			for(int j = 0; j<length; j++){
				arr[j] = sc.nextInt();
			}
			for(int j =0; j<length-1; j++){
				sub += (arr[j] - arr[j+1]);
			}
			if(sub >= 0){
				result[i] = false;
			}
			else{
				result[i] = true;
			}
			
			sub = 0;
		}
		for(int i =0; i<test; i++){
			System.out.println(result[i]);
		}

	}
}
