/**
 * 
 */
package algoTree;

import java.util.ArrayList;

/**
 * @author yenos
 * @date 2016. 9. 23.
 */
public class QuardTree {
	
	
	public ArrayList<String> queuee = new ArrayList<>();

	public  void 넷으로나눠서불러오는능력(int 이중배열[][]) {
		int 이중배열길이 = 이중배열[0].length;

		int[][] 분할된이중배열 = new int[이중배열길이 / 2][이중배열길이 / 2];
		int 사각형의합 = 0;
		
		if (이중배열길이 > 1) {
			queuee.add("(");

			사각형의합 = 0;
//			System.out.println("----------- 좌상 -----------" + 이중배열길이);
			for (int i = 0; i < 이중배열길이 / 2; i++) {
				for (int j = 0; j < 이중배열길이 / 2; j++) {
//					System.out.print(이중배열[i][j]);
					분할된이중배열[i][j] = 이중배열[i][j];
					
					
					사각형의합 += 이중배열[i][j] ;					
				}
//				System.out.println();
				
			}
//			System.out.println("사각혀으이합 ==> "+사각형의합 );
			// 이중배열이 1개보다 클때 그리고 내부합이 0 이아니거나 모두 1이여서 합이 해당배열의칸보다 작을떄는 섞여있을 경우임으로 다시 돌려서 구한다.
			if(이중배열길이>1 && 사각형의합 !=0 && 사각형의합 != (이중배열길이/2)*(이중배열길이/2)  ){
				 넷으로나눠서불러오는능력(분할된이중배열);
			}else if(사각형의합 ==0){
				//모두 0 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("0");
			}else if(사각형의합 == (이중배열길이/2)*(이중배열길이/2)  ){
				//모두 1 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("1");			
			}
			 
			
			사각형의합 = 0;
//			System.out.println("----------- 우상 -----------" + 이중배열길이);
			for (int i = 0; i < 이중배열길이 / 2; i++) {
				for (int j = 이중배열길이 / 2; j < 이중배열길이; j++) {
//					System.out.print(이중배열[i][j]);
					분할된이중배열[i][j-이중배열길이/2] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j] ;

				}
//				System.out.println();
			}
//			System.out.println("사각혀으이합 ==> "+사각형의합 );
			if(이중배열길이>1 && 사각형의합 !=0 && 사각형의합 != (이중배열길이/2)*(이중배열길이/2)  ){
				 넷으로나눠서불러오는능력(분할된이중배열);
			}else if(사각형의합 ==0){
				//모두 0 일 경우.
//				queuee.add(이중배열길이*-1);
//				queuee.add();

				queuee.add("0");
			}else if(사각형의합 == (이중배열길이/2)*(이중배열길이/2)  ){
				//모두 1 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("1");			
			}

			
			
			
			
			사각형의합 = 0;
//			System.out.println("----------- 좌하 -----------" + 이중배열길이);
			for (int i = 이중배열길이 / 2; i < 이중배열길이; i++) {
				for (int j = 0; j < 이중배열길이 / 2; j++) {
//					System.out.print(이중배열[i][j]);
					분할된이중배열[i-이중배열길이/2][j] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j] ;
				}
//				System.out.println();
			}
			
//			System.out.println("사각혀으이합 ==> "+사각형의합 );
			if(이중배열길이>1 && 사각형의합 !=0 && 사각형의합 != (이중배열길이/2)*(이중배열길이/2)  ){
				 넷으로나눠서불러오는능력(분할된이중배열);
			}else if(사각형의합 ==0){
				//모두 0 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("0");
				}else if(사각형의합 == (이중배열길이/2)*(이중배열길이/2)  ){
				//모두 1 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("1");				
			}
			
		
			사각형의합 = 0;
//			System.out.println("---------- 우하 -----------" + 이중배열길이);
			for (int i = 이중배열길이 / 2; i < 이중배열길이; i++) {
				for (int j = 이중배열길이 / 2; j < 이중배열길이; j++) {
//					System.out.print(이중배열[i][j]);
					분할된이중배열[i-이중배열길이/2][j-이중배열길이/2] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j] ;
				}
//				System.out.println();
			
			}
			
//			System.out.println("사각혀으이합 ==> "+사각형의합 );
			if(이중배열길이>1 && 사각형의합 !=0 && 사각형의합 != (이중배열길이/2)*(이중배열길이/2)){
				 넷으로나눠서불러오는능력(분할된이중배열);
			}else if(사각형의합 ==0){
				//모두 0 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("0");
			}else if(사각형의합 == (이중배열길이/2)*(이중배열길이/2)  ){
				//모두 1 일 경우.
//				queuee.add(이중배열길이*-1);
				queuee.add("1");				
			}
			queuee.add(")");	
		}

	}
	public String result(){
		String result="";
		for(int i =0 ;i<queuee.size();i++){
//			System.out.print(queuee.get(i)+" ");
			result+=queuee.get(i);
		}
		return result;
	}

}
