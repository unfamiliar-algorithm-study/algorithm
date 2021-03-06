package knapsack;

public class Main {
	static int[] ws = {3,4,1,2,3};
	static int[] ps = {2,3,2,3,6};
	static int[][] dp = new int[6][11];
	static int maxw = 10;
	
	public static void main(String[] args){
		System.out.println(knapsack(0,0));
		System.out.println(knapsack_memo(1,1));
	}
	
	public static int knapsack(int n, int w){
		
		//전체 무게를 초과 했을 때
		if(w > maxw) return -1;
		//전체 물품을 탐색 했을 때
		if(n >= ws.length) return 0;
		
		//재귀적으로 현재 물품을 더하지 않았을때와 현재물품을 더했을때 무게, 가치 비교하여 최대값 출력
		return Math.max(knapsack(n+1,w), knapsack(n+1,w + ws[n]) + ps[n]);
	}
	
	//배열에 각 항목에 대한 값을 메모
	public static int knapsack_memo(int n, int w){
		
		if(w > maxw) return -1;
		if(n >= ws.length) return 0;
		
		if(dp[n][w] >= 0)return dp[n][w];
		//재귀적으로 현재 물품을 더하지 않았을때와 현재물품을 더했을때 무게, 가치 비교하여 최대값 출력
		return dp[n][w] = Math.max(knapsack(n+1,w), knapsack(n+1,w + ws[n]) + ps[n]);
	}
}
