/**
 * 
 */
package algo_paper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yenos
 * @date 2016. 10. 2.
 */

class data{

	int keys;
	int xpos;
	int ypos;
	/**
	 * @param keys
	 * @param xpos
	 * @param ypos
	 */
	public data( int xpos, int ypos) {
		super();

		this.xpos = xpos;
		this.ypos = ypos;
	}	
}

public class Main {
	
	/**
	 * @date
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] table = new int[10][10];
		Scanner scan = null;
		//휴지 갯수 
		int cnt;
		System.out.println("몇개? ");
		cnt = scan.nextInt();
		

		String message;

		System.out.println(" = 좌표 입력 =");
		
		int index = cnt;
		while(index>0){
			 message = scan.next();
			 String[] arrMessage = message.split(",");
			 int xPaper =Integer.parseInt(arrMessage[0]);
			 int yPaper = Integer.parseInt(arrMessage[1]);			 
			 table[xPaper][yPaper] = 1;
			 index--;
		}		
		System.out.println(" = answer =");
		
		//1인것들의 좌표를 저장하고
		// 좌표의합으로 솔트를 하고 다시 좌표를 반환한다.
		
//		HashMap<Integer , String> map = new HashMap<Integer,String>();
		

		ArrayList<data>list= new ArrayList<data>();
		ArrayList<Integer>sum= new ArrayList<>();
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				System.out.print(table[i][j]);
				
				if(table[i][j]==1){
					sum.add(i+j);
					list.add(new data(i,j));					
				}
			}
			System.out.println();
		}
		
		
		   Collections.sort(sum);
		   int ssum=0;

		   for(int i=0;i<sum.size();i++){
			   for(int j=0;j<sum.size();j++){
				   ssum = list.get(j).xpos+list.get(j).ypos;
				   
				   if(ssum==sum.get(i)){
					   System.out.println("("+list.get(j).xpos+","+list.get(j).ypos+")");
				   }
			   }			   
		   }
			   

		

		
	}
	
	
}
