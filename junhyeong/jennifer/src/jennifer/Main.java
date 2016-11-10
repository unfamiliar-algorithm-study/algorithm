package jennifer;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int[][] dist = new int[1001][1001];
		
		StringBuffer SB = new StringBuffer();
		
		Scanner sc = new Scanner(System.in);
		
		SB.append("JENNIFER");
		for(int i = 1; i<SB.length(); i++){
			dist[i][0] = i;
		}
		for(int i = 1; i<SB.length(); i++){
			dist[i][0] = i;
		}
	}
}
