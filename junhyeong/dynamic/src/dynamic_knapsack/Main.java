package dynamic_knapsack;

public class Main {
	static int[] ws = {3,4,1,2,3};
	static int[] ps = {2,3,2,3,6};
	
	//dp[물건개수][나올수있는가치의 경우의수]
	static int[][] dp = new int[6][11];
	
	static int maxw = 10;
	static int ret =0;
	
	public static void main(String[] args){
		System.out.println(knapsack());

	}
	
	public static int knapsack(){
		
		//물건의 0번부터 시작
		for(int i = 0; i <ws.length; i++){
			//최대 무게가 될떄까지 반복
			for(int j = 0; j<= maxw; j++){
				//각 무게에서 나올 수있는 모든 경우의수를 비교해서 최대값을 ret에 저장
				if(j+ws[i]<=maxw){
					dp[i+1][j+ws[i]] = Math.max(dp[i+1][j+ws[i]], dp[i][j] + ps[i]);
					ret = Math.max(dp[i+1][j+ws[i]],ret);
				}
			}
		}
		return ret;
	}	
}
