/**
 * 
 */
package algo_hanoi;

/**
 * @author yenos
 * @date 2016. 10. 20.
 */
public class Main {

	/**
	 * @date
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		hanoi(3,'a','b','c');
	
		for(int i = 2 ; i<100;i++){
			int count=0;
			for(int j = 2;j<i;j++){
				if(i%j==0){
					count = 1;
				}

			}
			if(count==0){
				System.out.println(i+"는 소수입니다.");
			}
		}

	}
	public static void hanoi(int n,char a,char b,char c){
		if(n==1){
            System.out.println( "원판 "+n+"이 기둥 " + a+ 
                    "에서 기둥 " + c +"로 이동" );
		}else{
			///n-1 a->b 로 옮긴다는 뜻 
			hanoi(n-1, a, c, b);
            System.out.println( "원판 "+n+"이 기둥 " + a+ 
                    "에서 기둥 " + c +"로 이동" );
            //n-1 b->c로 옮긴다는
            hanoi(n-1,b,a,c);
		}
	}

}
