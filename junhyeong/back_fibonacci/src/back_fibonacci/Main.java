package back_fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int num_0 = 0;
	static int num_1 = 0;
	static ArrayList<Integer> countArr = new ArrayList<Integer>();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int n = 0;
		
		countArr.add(1);
		countArr.add(1);
		
		for(int i = 0; i < count; i++){
			n = sc.nextInt();
			if(n == 0){
				countArr.get(0);
			}
			else if(n == 1){
				countArr.get(1);
			}
			else{
				fibonacci(n);
			}
			System.out.println(num_0 + " " + num_1);
			num_0 = num_1 = 0;
		}
	}
	
	public static void fibonacci(int n){
		if( n == countArr.size() ){
			countArr.add(countArr.get(n-1) + countArr.get(n-2));
		}
		else if((n-1) == countArr.size()){
			fibonacci(n-1);
			countArr.add(countArr.get(n-2) + countArr.get(n-3));
		}
		else if((n-2) >= countArr.size()){
			fibonacci(n-1);
			fibonacci(n-2);
			countArr.add(countArr.get(n-1) + countArr.get(n-2));
		}
	}
}
