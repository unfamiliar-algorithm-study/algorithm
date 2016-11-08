/**
 * 
 */
package AlgoBook;

/**
 * @author yenos
 * @date 2016. 11. 5.
 */
public class Main {

	/**
	 * @date
	 * @param args
	 */
	static int h = 5;
	static int w = 4;
	static int[][]dp = new int[h+1][w+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(dfs(h,w));
		
//		String[] ex = {"NNYN","NNYN","NNNN","NYYN"};
		String[] ex = {"NNNNNN","YNYNNY","YNNNNY","NNNNNN","YNYNNN","YNNYNN"};
//		String[] ex = {"NYNNYN","NNNNNN","NNNNNN","NNYNNN","NNNNNN","NNNYYN"};
		
		int sum =new Salary().getSalary(ex);
		System.out.println("sum is=>"+sum);
		
		
	}
	
	
	
	//최종
	static int [] ws = {3,4,1,2,3};
	static int [] ps = {2,3,2,3,6};
	static int maxw=10;
	static int[][] dpp = new int[6][11];
	
//최종 동적계획법을이용
	static int ret = 0;
	public static void knapsack3(){
		
		for(int i=0;i<=ws.length;i++){
			for(int j=0;j<=maxw;j++){
				dp[i+1][j+ws[i]] = Math.max(dp[i+1][j+ws[i]],dp[i][j+ps[i]]);
				ret = Math.max(dp[i+1][j+ws[i]],ret);
			}
			
		}	
	}
	
	
	
	//n은 현재 보고있는 물건의 번호(index),w는 현재가지고있는무게
	//0,0
	public static int knapsack2(int n, int w){
		if(w>maxw) return -1;
		if(n>=ws.length) return 0;
		//값이 만약존재한다면 해당값을 리턴한다.
		if(dpp[n][w]>=0) return dpp[n][w];
		
		return dp[n][w] = Math.max(knapsack2(n+1,w),knapsack2(n+1,w+ws[n])+ps[n]);
	}
	
	
	
	//n은 현재 보고있는 물건의 번호(index),w는 현재가지고있는무게 
	public static int knapsack(int n, int w){
		if(w>maxw) return -1;
		if(n>=ws.length) return 0;
		return Math.max(knapsack(n+1,w),knapsack(n+1,w+ws[n])+ps[n]);
	}
	
	
	public static int dfs(int nowh,int noww){
		//범위아웃.
		if(nowh >h || noww> w)return 0;
		//끝나는조건.
		if(nowh==h && noww== w)return 1;
		if(dp[nowh][noww]!=0) return dp[nowh][noww];
		
		return dp[nowh][noww]=dfs(nowh+1,noww)+dfs(nowh,noww+1);
		
	}
	
	//edit di 처럼 전에것을 저장하고 더함.
	public static void calc(){
		int i;
		dp[0][0]=1;
		for(i=0;i<=h;i++){
			for(int j=0;j<=w;j++){
				if(i!=0) dp[i][j]+=dp[i-1][j];
				if(j!=0) dp[i][j]+=dp[i][j-1];
			}
		}
	}

}
