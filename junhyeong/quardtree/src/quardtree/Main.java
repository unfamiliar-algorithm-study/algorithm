package quardtree;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		int size;
		int[][] video;
		String[] str_video;
		char char_video;
		
		Scanner sc = new Scanner(System.in);
        
		size = sc.nextInt();
		sc.nextLine();
		
		video = new int[size][size];
		str_video = new String[size];
		
		for(int i = 0; i < size; i++){
			str_video[i] = sc.nextLine();
		}
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				video[i][j] = str_video[i].charAt(j);
			}
		}
		quardTree(size, video);
        
	}
	
	public static void quardTree(int size, int[][] arr){
		int max_size = size;
		int[][] video = arr;		
		searchVideo(0,0,video, max_size);
	}
	
	public static void searchVideo(int width, int height, int[][] video, int max_size){

		boolean flag = true;
		if(max_size != 1){
			//첫번째 값이랑 하나씩 비교
			for(int i = height; i < height + max_size; i++){
				for(int j = width; j < width + max_size; j++){
					if(video[i][j] != video[height][width]){
					flag = false;
					}
				}
			}
		}
		
		if(flag){
			System.out.print(video[height][width] - 48);
		}
		
		//4각형을 네등분해서 다시 서치
		else{
			System.out.print("(");
			//[0][0]에서 시작
			searchVideo(width, height, video, max_size/2);
			//[0][size/2]
			searchVideo(width + max_size/2, height, video, max_size/2);
			//[size/2][0]
			searchVideo(width, height + max_size/2, video, max_size/2);
			//[size/2][size/2]
			searchVideo(width + max_size/2, height + max_size/2, video, max_size/2);
			System.out.print(")");
		}	
	}
}