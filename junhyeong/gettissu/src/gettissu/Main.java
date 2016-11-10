package gettissu;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		int x = 0;
		int y = 0;
		//전체 휴지 좌표를 저장할 배열
		Tissu[] tissu = new Tissu[size+1];
		//휴지와 휴지사이 거리값 가지고 있을 배열(다익스트라)
		double[][] intervalTissu = new double[size+1][size+1];
		
		//투영된  점까지의 거리를 저장할 배열
		double[] dist = new double[size+1];
		
		tissu[0] = new Tissu();
		//사이즈 만큼 휴지 좌표 입력
		for(int i = 1; i<=size; i++){
			x = scanner.nextInt();
			y = scanner.nextInt();
			tissu[i] = new Tissu(x,y);
		}
		
		//점과 직선사이의 거리
		//|ax1+by1+c|/root(a^2 + b^2
		//-x +y = 0
		for(int i = 0; i<=size; i++){
			x = tissu[i].GetX();
			y = tissu[i].GetY(); 
			
			dist[i] = Math.sqrt((x*x+y*y) - Math.pow(Math.abs(-x + y) / Math.sqrt(2), 2));
		}
		
		//다 들어갔는지 학인 출력하는 for문
		for(int i = 0; i <size + 1; i++){
			tissu[i].printPos();
		}
		System.out.println(" ");
		//다 들어갔는지 학인 출력하는 for문
		System.out.println("거리값 출력");
		for(int i = 0; i <=size; i++){
			System.out.print(dist[i] +" , " );
		}
		System.out.println(" ");

		BubbleSort bubblesort = new BubbleSort(dist, tissu);
		
		//다 들어갔는지 학인 출력하는 for문
		for(int i = 0; i <size + 1; i++){
			tissu[i].printPos();
		}
		
	}		
	
	public static double getDistance(Tissu tissu1, Tissu tissu2){
		double x, y;
		double distance;
		x = (double)(tissu1.GetX() - tissu2.GetX());
		y = (double)(tissu1.GetX() - tissu2.GetX());
		
		distance = Math.sqrt(x*x + y*y);
		return distance;
	}
}
