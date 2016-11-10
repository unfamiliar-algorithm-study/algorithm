package quardtree;

/**
 * @Filename QuardTree.java
 * @Date 2016. 9. 24.
 * @author 준형
 * @description 쿼드트리
 */

/*
 * 영상의 크기 N이 들어오면 N * N 크기의 2차배열 생성
 * 2의 제곱으로 크기는 증가, 감소
 * 하나의 사각형 모든값이 1이면 1, 0이면 0
 */

public class QuardTree {
	private int[][] video;
	private int size;
	boolean flag;
	
	public QuardTree(int size, int[][] video){
		this.size = size;
		this.video = video;		
		searchVideo(0,0, this.size);
	}
	
	public void searchVideo(int width, int height, int size){

		flag = true;
		if(size != 1){
			//첫번째 값이랑 하나씩 비교
			for(int i = height; i < height + size; i++){
				for(int j = width; j < width + size; j++){
					if(video[i][j] != video[height][width]){
					flag = false;
					}
				}
			}
		}
		
		if(flag){
			System.out.print(video[height][width]);
		}
		
		//4각형을 네등분해서 다시 서치
		else{
			System.out.print("(");
			//[0][0]에서 시작
			searchVideo(height, width, size/2);
			//[0][size/2]
			searchVideo(height + size/2, width, size/2);
			//[size/2][0]
			searchVideo(height, width + size/2, size/2);
			//[size/2][size/2]
			searchVideo(width + size/2, height + size/2, size/2);
			System.out.print(")");
		}	
	}
}





















