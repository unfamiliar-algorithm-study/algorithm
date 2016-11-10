package dfs;

public class Main {
	static int h = 5;
	static int w = 4;
	static int[][] dp = new int[h+1][w+1];

	public static void main(String[] args){
		//0,0에서 5,4까지 갈수있는 경우의 수
		System.out.println(dfs(0,0));
		
		//3,3에서 5,4까지 갈수있는 경우의 수
		System.out.println(dfs(3,3));
		
		//4,4에서 5,4까지 갈수있는 경우의 수
		System.out.println(dfs(4,4));
	}
	
	public static int dfs(int nowh, int noww){
		if(nowh > h || noww > w) 
			//현재 좌표가 목표좌표의 범위를 벗어났을 때 
			return 0;
		else if(nowh == h && noww == w)
			//현재 좌표와 목표좌표의 높이 또는 길이가 같을때
			return 1;
		else if(dp[nowh][noww] != 0 )
			//초기 배열값은 0인데 재귀되면서 값이 변한다
			return dp[nowh][noww];
		
		//재귀함수로 값 변경하여 최종 출력
		return dp[nowh][noww] = dfs(nowh+1, noww) + dfs(nowh, noww+1);
	}
}
