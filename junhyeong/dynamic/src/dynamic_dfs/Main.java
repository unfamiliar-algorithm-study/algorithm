package dynamic_dfs;

public class Main {
	static final int h = 5, w = 4;
	static int[][] dp = new int[h+1][w+1];
	
	public static void main(String[] main){
		calc();
		System.out.println(dp[0][0]);
		//0,0에서 3,3까지 가는 경우의 수 합
		System.out.println(dp[3][3]);
		System.out.println(dp[4][4]);
		System.out.println(dp[5][4]);
	}
	
	public static void calc(){
		int i, j;
		dp[0][0] = 1;
		for(i = 0; i<=h; i++){
			for(j = 0; j<= w; j++){
				//각 좌표를 지날때 마다 배열의 해당 좌표에 근접한 좌표의 배열값을 더한다
				if(i != 0)
					dp[i][j] += dp[i-1][j];
				if(j != 0)
					dp[i][j] += dp[i][j-1];
			}
		}
	}
}
