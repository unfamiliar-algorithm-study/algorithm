import java.util.Scanner;

public class HandsShaking {
	static long[] dp;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("n = ");
		n = sc.nextInt();
		//반으로 나눴을때 한쪽이 2 ,4, 6일때만 알면된다.
		dp = new long[n/2];
		
		System.out.print("가능한 경우의 수 = " + countPerfect(n));
	}
	
	public static long countPerfect(int n){
		
		dp[0] = 1;
		//5 = 4 + (3*1 + 2*2 + 1*3) + 4
		//n이 증가한다는 것은 사람 두명이 추가되는 것이므로 두개의 돌에대한 경우만 추가로 생각해주면 된다
		
		//n이 8일때; 
		//i = 1,2,3
		//j는 i가 3일때 두번(0*1 + 1*0)
		
		//n이 10일때
		//i = 1,2,3,4
		//j는 i가 4일때 세번 더해야한다
		for(int i = 1 ; i < n/2; i++){
			dp[i] += dp[i-1];
			
			for(int j = 2; j <= i; j++){
				dp[i] += dp[j-2]*dp[i-j];
			}
			dp[i] += dp[i-1];
		}
		
		return dp[n/2 -1];
	}
}
