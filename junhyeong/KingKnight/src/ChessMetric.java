import java.util.Scanner;

public class ChessMetric {
	static int[][] dp;
	
	public static void main(String[] args){
		int size;
		int[] start = new int[2];
		int[] end = new int[2];
		int numMoves;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Size = ");
		size = sc.nextInt();
		
		dp = new int[size+1][size+1];
		
		System.out.println("start = ");
		for(int i = 0; i <2 ; i++){
		start[i] = sc.nextInt();
		}
		
		System.out.println("end = ");
		for(int i = 0; i <2 ; i++){
		end[i] = sc.nextInt();
		}
		
		System.out.println("numMoves = ");
		numMoves = sc.nextInt();
		
		howMany(size, start, end, numMoves);
		
		System.out.println(dp[end[0]][end[1]]);
	}
	
	public static long howMany(int size, int[] start, int[] end, int numMoves){

		int[] temp = new int[2];
		int[] move_x = {0, 0, 1, 1, 1, -1, -1, -1, 2, 2, -2, -2, 1, -1, 1, -1};
		int[] move_y = {1, -1, 1, 0, -1, 1, 0, -1, 1, -1, 1, -1, 2, 2, -2, -2};

		//이동하는 경우의 수에 대해 move_x, move_y 배열에 차례대로 저장한다.
		//이동한 경로가 사이즈를 벗어나지 않으면 해당 좌표에 1을 더해주는 동적프로그밍
		//움직일수 있는 기회가 더 남아있다면 재귀로 함수를 호출한다.
		for(int i = 0; i < 16; i++){
			temp[0] = start[0] + move_x[i];
			temp[1] = start[1] + move_y[i];
			if(temp[0] >= 0 && temp[1] >= 0 && temp[0] <= size && temp[1] <= size){
				dp[temp[0]][temp[1]] += 1;
				
				if(numMoves > 1){
					howMany(size, temp, end, numMoves-1);
				}
			}
		}

		return 0;
	}
		
}
