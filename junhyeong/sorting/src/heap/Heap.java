package heap;

public class Heap {
	
	//배열 A[]를 힙으로 만듬
	//size = 10 ( 10/2 = 5 )
	//5, 4, 3, 2 (4번시행)
	public void reheap(int A[], int length, int i){
		boolean done = false;
		int T = A[i];// 처음 인덱스는 9 (사이즈 -1)
		//A[4]일때 부터 시작
		int parent = i;// 부모는 9
		int child = 2*(i+1)-1;	//자식은  19
		
		//자식이 최대 길이보다 짧으면서  done이 false인동안 계속 실행
		//i = 4일때 부터 child가 돌아가기 시작
		while((child < length) && (!done))
		{
			if(child < length - 1){
				if(A[child] < A[child+1]){
					child += 1;
				}
			}
			
			//T(=A[4])가  A[9]보다 큰가 비교
			//parent = 4가 된다
			if(T >= A[child]){
				done = true;
			}
			else{
				A[parent] = A[child];
				parent = child;
				child = 2*(parent+1)-1;
			}
		}
		A[parent] = T;
	}
	
	public void sort(int A[]){
		//배열 A를 우선 tree형태로 만드는 작업
		for(int i = A.length-1; i>=0; i--)
			reheap(A, A.length, i);
		
		//만들어진 tree를 root를 하나씩 제거하며 배열에 넣음
		for(int i = A.length-1; i>0; i--){
			int T = A[i];
			A[i] = A[0];
			A[0] = T;
			reheap(A, i, 0);
		}
	}
}
