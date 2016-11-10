package counting;

public class Counting {
	public int[] sort(int[] A){
		int[] Result = new int[A.length +1];
		int[] Count = new int[A.length +1];
		
		for(int i = 0; i < Count.length; i++){
			Count[i] = 0; //카운트 배열 0으로 초기화
		}
		
		for(int i =0; i<A.length; i++){
			int x = Count[A[i]];
			x++;
			Count[A[i]] = x;
		}
		
		//count값 새로 설정
		for(int i = 1; i<Count.length; i++){
			Count[i] = Count[i] + Count[i-1];
		}
		
		for(int i = A.length -1; i>= 0; i--){
			int x = Count[A[i]];
			Result[x] = A[i];
			x--;
			Count[A[i]] = x;
		}
		
		return Result;
	}
}
