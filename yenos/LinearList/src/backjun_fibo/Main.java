/**
 * 
 */
package backjun_fibo;

import java.util.ArrayList;

/**
 * @author yenos
 * @date 2016. 11. 6.
 */
public class Main {

	/**
	 * @date
	 * @param args
	 */
	
	public static ArrayList<hashs> arrMem = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(fibonacci(5));
		
		for(int i=0;i<40;i++){
			arrMem.add(new hashs(-1,-1));	
		}
		fibonacci(2);
		
		

	}
	
	public static int fibonacci(int n) {

	    
		if (n==0) {
//	    	System.out.println("0");
//			//비어있을경우
//			if(arrMem.get(n).one==-1 && arrMem.get(n).zero==-1){
//				arrMem.add(new hashs(0,1));
			arrMem.set(0, new hashs(0,1));
			
	        return 0;
	    } else if (n==1) {
//	    	System.out.println("1");
//			if(arrMem.get(n).one==-1 && arrMem.get(n).zero==-1){
	    	arrMem.set(1, new hashs(1,0));

	    	//2를 만들어놓는다.
	    	arrMem.set(2, new hashs(arrMem.get(1).one+arrMem.get(0).one,arrMem.get(1).zero+arrMem.get(0).zero));
			
	        return 1;
	    } else {
	    	
//	    	fibonacci(n-2);
//	    	fibonacci(n-1);
	    	System.out.print(arrMem.get(n).one);
	    	System.out.println(arrMem.get(n).zero);
	    	return fibonacci(n-2) + fibonacci(n-1);
	    }
		
	}


}
