/**
 * 
 */
package sort;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterLocation;

/**
 * @author yenos
 * @date 2016. 9. 19. 정렬을 구현해봅시다!
 */
public class Sort {

	public static int[] selectionSort(int arr[]) {
		int arrLen = arr.length;
		int smallestIndex = 0;

		for (int i = 0; i < arrLen; i++) {
			// 검색한결과가 기준벨류보다 작으면
			// 작은벨류를 계속바꿔준다.

			// 첫번쨰 포문
			// 총 배열의 갯수만큼 돌아야한다.
			int standardValue = arr[i];
			// System.out.println("set StandardValue=>"+standardValue);

			// 두번째 포문
			// arrLen arrLen-1, arrLen-2... 이렇게 진행.
			for (int j = i; j < arrLen; j++) {

				if (standardValue >= arr[j]) {
					standardValue = arr[j];
					smallestIndex = j;
				}

				if (j == arrLen - 1) {
					int tmp;
					// //탬프에 값을 넣어주고
					tmp = arr[i];
					// //기준엔 가장 작은 값을 넣고.
					arr[i] = arr[smallestIndex];
					// //기존꺼 바꾸기.
					arr[smallestIndex] = tmp;
					// //언사이즈를 ++ 해주고

				}

			}

		}

		return arr;
	}

	public static int[] bubbleSort(int arr[]) {
		int arrLen = arr.length;

		for (int i = 0; i < arrLen; i++) {

			// 매번 마지막까지 된다.
			for (int j = 0; j < arrLen - i; j++) {

				// 앞에것이 더크다면 바꿔준다.
				if (j + 1 < arrLen - i) {
					if (arr[j] > arr[j + 1]) {
						int tmp;
						tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}
		}
		return arr;
	}

	public static int[] insertSort(int arr[]) {
		int arrLen = arr.length;

		// 모든요소를 검색하기위한포무
		for (int i = 0; i < arrLen; i++) {
			int tmp;

			// 앞에 정렬된 배열에서 비교하는 부분.(앞쪽 포문)
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}

			}
		}

		return arr;
	}

	// low는 가장낮은 인덱스 high는 가장 높은 인덱스
	public static int[] quickSortt(int[] arr, int low, int high) {

		quickSort(arr, low, high);

		return arr;
	}

	public static void quickSort(int[] arr, int low, int high) {

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low;
		int j = high;

		// 두개가 같을경우 종료되는데 왼쪾 오른쪽 부터 가운데값으로 다가올때 둘이 겹치는 경우를 말한다.
		while (i <= j) {

			// i 를 ++ 해준다.
			// 기준보다 작은값을 찾을떄까지인덱스를 증가시킨다.
			while (arr[i] < pivot) {
				i++;
			}
			// j 를 ++ 해준다.
			// 기준보다 높은값을 찾을때까지 인덱스를 증가시킨다.
			while (arr[j] > pivot) {
				j--;
			}

			// i와 j를 스왑한다.
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// j 랑 i랑 같은 상태가 되었고,
		// 처음~ j까지 다시 위와같은 연산을한다.
		if (low < j)
			quickSort(arr, low, j);
		// i~ 끝까지 다시 위와같은 연산을한다.
		if (high > i)
			quickSort(arr, i, high);
	}

	// low는 가장낮은 인덱스 high는 가장 높은 인덱스
	public static int[] mergeSortt(int[] arr, int low, int high) {

		MergeSort(arr, low, high);

		return arr;
	}

	public static void MergeSort(int[] arr, int low, int high) {

		//
		if (low < high) {
			int middle = low + (high - high) / 2;
			//왼쪽을 계속 나눈다.
			MergeSort(arr, low, middle);
			//오른쪽을 계쏙 나눈다.
			MergeSort(arr, middle + 1, high);
			//나눠진전부를 병합한다. 
			mergeParts(arr, low, middle, high);
		}
	}

	public static void mergeParts(int[] arr, int low, int middle, int high) {
		//합칠떄 배열을 계속해서 더해줘야함으로  솔팅된 결과를 담을 임시 변수가필요하다.
		int[] tempMergArr = new int[arr.length];
		
		//정렬 되지않은 원본배열을 tempMergeArr로 복사한다. => value를 바로 가져다쓰기위해서다.
		for (int i = low; i <= high; i++) {
			tempMergArr[i] = arr[i];
		}
		//2개배열 왼쪽 
		int i = low;
		//2개배열중 오른쪽 
		int j = middle + 1;
		
		//실제통합된 배열을 저장하기위한.
		int k = low;
		
		//합치려는 배열2개의 왼쪽 배열 혹은 오른쪽배열이 비교를하는데  어느한쪽이 끝까지간다면 (미들까지 혹은 가장 큰값까지) 종료해야한다. 비교가끝났음으
		while (i <= middle && j <= high) {
			// 두개의 배열 i 번쨰 j 번쨰 각가을 비교해서 작으면 i를 먼저 넣어주고,
			if (tempMergArr[i] <= tempMergArr[j]) {
				arr[k] = tempMergArr[i];
				i++;
				//크면 j를 넣어주면 된다.
			} else {
				arr[k] = tempMergArr[j];
				j++;
			}
			//그리고 통합배열인덱스를 올린다.
			k++;
		}
		//왼쪽이 더 많을 수있어서 끝까지연산되지 못한 경우가있을수 있다.
		//그러므로 왼쪽값을 k에 마져 넣어주고 똑가티 통합배열과 i 인덱스를 올려준다. 
		
		while (i <= middle) {
			arr[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
	
	
	public static void countingSort(int[] arrQuiz){
		//각arr의 값이 몇번쨰에 위치하고있는지 파악한다.
		
		int [] arrAccum = new int[12];
		
		//최초 0 으로 최기화.
//		for(int i =0;i<arrAccum.length;i++){
//			arrAccum[i] = 0;
//		}
//				
		//나온수 만큼 누적 합 어레이 계산.
		for(int i=0;i<arrQuiz.length;i++){
			arrAccum[arrQuiz[i]] +=1;
		}
		
		int [] arrAccumCopy= new int[12];
		
		arrAccumCopy = arrAccum.clone();

		for(int i=1;i<arrAccum.length;i++){
			arrAccum[i] = arrAccum[i-1] + arrAccumCopy[i];
		}
		
//		System.out.println();
//		System.out.println("accumed array");
//		for(int i=0;i<arrAccum.length;i++){			
//			System.out.print(" "+arrAccum[i]);
//		}

		
		int [] arrAnswer = new int[12];
		
		for(int i=0;i<arrQuiz.length
				;i++){

			//최초 배열하고자하는 값의 인덱스를 가지는 누적합의 위치에  배열값을 넣으면된다.
			// 최초 
			// 2  2 5 5 1 3 3
			// 누적합
			// 0 1 2 3 4 5 6 7
			// 1   2 2   2
			// 최종 누적합
			// 0 1 2 3 4 5 6 7
			// 1 1 3 5 5 7 0 0 
			
			//답
			// 0 1 2 3 4 5 6 7
			// 	 1 2 2 3 3 5 5
//			System.out.println(arrQuiz[i]);
//			for(int j=0;j<arrAccum.length;j++){			
//				System.out.print(" "+arrAccum[j]);
//			}System.out.println();

			
			arrAnswer[arrAccum[arrQuiz[i]]-1] = arrQuiz[i];			
			arrAccum[arrQuiz[i]]-=1;
//			for(int j=0;j<arrAnswer.length;j++){			
//				System.out.print(" "+arrAnswer[j]);
//			}System.out.println();
		}
		
		System.out.println();
		for(int i=0;i<arrAnswer.length;i++){
			System.out.print(" "+arrAnswer[i]);
		}
		
		
		
		
	}
	public static void radixSort(int[] arr){

		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		bucket.add(new ArrayList<Integer>());
		
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i : arr){
			tmp.add(i);
		}
		
			
		//모듈러연산을 위함.
		int mod = 10;
		//나누기연산을 위함.
		int divider = 1;
		//가장긴 숫자수만큼해야하기떄문에 
	    int numlen = 0;       

	    
	     for (int i=0; i<arr.length; i++)
	     {
	         if ( Integer.toString(tmp.get(i)).length() > numlen )  
	         {
	        	 numlen = Integer.toString(tmp.get(i)).length();
	         }
	     }
	    
	    for(int i =0 ;i<numlen;i++){	
	    	for(int z=0;z<10;z++){
	    		bucket.get(z).clear();	
	    	}
	    	
			for(int j =0 ;j<tmp.size();j++){			
                int flagNum = (tmp.get(j) % mod) / divider;
				bucket.get(flagNum).add(tmp.get(j));						
			}

			//다시사용해야함으로 클리어한다.
			tmp.clear();
			for(int j=0;j<bucket.size();j++){
				for(int k=0;k<bucket.get(j).size();k++){
					tmp.add(bucket.get(j).get(k));
				}				
			}
			mod *= 10;
			divider *= 10;
			
	    }
	    
	    for(int i=0;i<tmp.size();i++){
	    	System.out.println("radix =>"+tmp.get(i));
	    }
		
	}
	
	public static void 자릿수를뽑아내보자(int 숫자){
		//모듈러연산을 위함
		int mod = 10;
		//나누기연산을 위함.
		int divider = 1;
		///123
		
		for(int i=0;i<3;i++){
			//123 % 10 => 3 /1 => 3
			//123 % 100 => 23/10 => 2
			//123 % 1000 => 123/100 => 1
			//.. 큰숫자부터 출력됨.
	        int flagNum = (숫자 % mod) / divider;
	        System.out.println(flagNum);
	        mod*=10;
	        divider*=10;
	        
		}
	}

	//여기서부터 힙정
	
	public static int [] arrHeap = new int[7];
	public int heapIndex = 0 ;	
	public static void insertHeap(int v){
			
		// v = 0  
		// 0,1
		
		// v = 1
		// 2,3
		
		// v = 2
		// 4,5
		
		// v = 3
		// 6,7
		
		if(arrHeap==null || arrHeap.length<1)
			return ;
		
		
		int childLeft = v*2;
		int childRight = childLeft+1;
		int largest;
		
		//힙의 왼쪽값이 현재 부모(arrHeap[v])보다 크다면?
		//지금들어올녀석이 더크다라고정해준다. largest = left
		if (childLeft<arrHeap.length&&arrHeap[childLeft]>arrHeap[v]){
			largest = childLeft;					
		}
		//그게 아니라면 현재값이 더크겠찌.
		else{
			largest = v;
		}
		
		//위에서 정해진 가장큰값이랑 또 오른쪽값이랑 비교해봐야한다.
		//위에서 정해진 부모이든, 왼쪽이든 오른쪽이랑 비교해서 (어쨋든 가장큰 인덱스)
		//그 인덱스가있는 곳과 childRight를 비교 
		//childRight가 더크면 해당해당인덱스 리턴.
		if(childRight<arrHeap.length&&arrHeap[childRight]>arrHeap[largest]){
			largest = childRight;
		}
		//엘스인경우를 안한이유는 
		// 왼쪽보다 오른쪽이 무조건 더 작때문에 
		//왼쪽이 더클경우  왼쪽 >오른쪽> v => 어짜피 최대못뙴. 
		//왼쪽 >v> 오른 =>어자피최대못됨.
		
		//v>왼쪽 일경우에서 right랑비교 
		//오른>v>왼쪽인경우는 어짜피 최대못됨
		//v>오른>왼쪽 일경우는 아무것도 하지 않아도되기때문.
		//아무것도 하지 않았다는것은 재정렬이 필요없고 v*2 가 left가 되고 childLeft+1이 비었다는것이되고자연스럽게 꼬리롱붙는다.
		
		//가장큰값이 v라면 
		if(largest!=v){
			//v랑 현재 가장큰값이랑 스왑을하고.
			swap(v,largest);
			//가방큰값으로 다시 리커시브한다.
			insertHeap(largest);
		}
		for (int i = 0; i < arrHeap.length; i++) {
            System.out.print(" " + arrHeap[i]);
        }System.out.println();
	}
	
    private static void swap(int i, int j) {
        int tmp = arrHeap[i];
        arrHeap[i] = arrHeap[j];
        arrHeap[j] = tmp;
    }

    public static void buildMaxHeap() {
    	 
        if (arrHeap == null || arrHeap.length < 1)
            return;
 
        for (int i = arrHeap.length / 2; i > 0; i--) {
            insertHeap(i);
            
        }
    }
    
    public static void printArr() {
        for (int i = 0; i < arrHeap.length; i++) {
            System.out.print(" " + arrHeap[i]);
        }
    }


	

}
