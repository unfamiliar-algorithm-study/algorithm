/**
 * 
 */
package algo_hanKom;

import java.util.Scanner;

/**
 * @author yenos
 * @date 2016. 10. 21.
 */
public class Main {

	/**
	 * @date
	 * @param args
	 */
	public static void main(String[] args) {
		
//		int cnt;
//		System.out.println("몇개? ");
//		Scanner scan = new Scanner(System.in); // 문자 입력을 인자로 Scanner 생성
//		cnt = scan.nextInt();

		//문제이다  
		int target  = 12;
		
		//합을 출력한다.
		int sum = 0 ;
		//마이너스할 녀석을 정한다.
		int maxMinu = 0 ;
		
		//1 부터 타겟까지 루프를 돌것이다.
		//기본 더하기연산으로돈다
		for(int i=1 ;i<target+1;i++){
			//System.out.println(sum);
			
			//합하다가 sum 이랑 타겟이랑 같으면 개이득!
			sum+=i;	

			// 6 => 1 2 3  오 됨. 개이득!
			if(sum==target){
				for(int j=1;j<i+1;j++){
					System.out.print("+");
					System.out.println(j);
				}
				System.out.println("끝!");
				break;
				
				//마이너스할수있는 최대치를 구하는 조건이다.
				//sum-target이 1보다 커진다는것은 target보다 섬이 클경우이다.
				// sum-target/2 한값이 0보다커야한다.
				// 1/2 => 0이면 의미가없다.(1이상이여야함.)
			}else if((sum-target)>1&& (sum-target)/2>0){
				maxMinu = (int)(sum-target)/2;
				System.out.println(i+"번쨰 타겟=>"+maxMinu);
				
				int tmpsum = 0;  
				for(int j=1 ;j<target;j++){
					//최대 마이너스이면 마이너스를 한다.
					if(j==maxMinu){
						tmpsum -=j;
						System.out.println("-"+j);
					}else{
						tmpsum +=j;
						System.out.println("+"+j);
					}
					
					if(tmpsum==target){
						System.out.println("정답! "+tmpsum+"완성 ");
						sum=-99;
						break;
						
					}
					
				}
				//타겟을 - 해본다.
			}
			if(sum==-99){
				break;
			}
			


		}

	}

}
