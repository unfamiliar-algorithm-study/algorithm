/**
 * 
 */
package sort;

/**
 * @author yenos
 * @date 2016. 9. 19.
 */
public class main {

	/**
	 * @date
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]  = {10,5,13,24,7,30,1};
		
//
//		System.out.println("====before====");
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]+" ");			
//		}		
//		System.out.println("");
//		System.out.println("===selection Sort ====");
//		int resultSelect[] = Sort.selectionSort(arr);		
//		for(int i=0;i<resultSelect.length;i++){
//			System.out.print(resultSelect[i]+" ");
//		}
//		
//		arr = new int[] {10,5,13,24,7,30,1};
//		System.out.println("");
//		System.out.println("===bubble Sort ====");
//		int resultBubble[] = Sort.bubbleSort(arr);		
//		for(int i=0;i<resultBubble.length;i++){
//			System.out.print(resultBubble[i]+" ");
//		}
//		arr = new int[] {10,5,13,24,7,30,1};
//		System.out.println("");
//		System.out.println("===insertion Sort ====");
//		int resultInsertion[] = Sort.insertSort(arr);		
//		for(int i=0;i<resultInsertion.length;i++){
//			System.out.print(resultInsertion[i]+" ");
//		}
//		arr = new int[] {10,5,13,24,7,30,1};
//		System.out.println("");
//		System.out.println("===quick Sort ====");
//		int resultQuick[] = Sort.quickSortt(arr,0,arr.length-1);
//
//		for(int i=0;i<resultQuick.length;i++){
//			System.out.print(resultQuick[i]+" ");
//		}
//		
//		arr = new int[] {10,5,13,24,7,30,1};
//		System.out.println("");
//		System.out.println("===merge Sort ====");
//		int resultMerge[] = Sort.mergeSortt(arr,0,arr.length-1);
//
//		for(int i=0;i<resultMerge.length;i++){
//			System.out.print(resultMerge[i]+" ");
//		}		
//		
		
//		arr = new int[] {12,50,43,24,76,90,14};
//
//		Sort.radixSort(arr);
//		
//		Sort.자릿수를뽑아내보자(123);
		
		arr = new int[] {90,43,24,59,76};
//		0 1 2 3 4 5 6 7 8 9 10 11 12
//		0 1 4 6 6 8 10 12 12 12 12 12 
		
//		0 1 2 3 4 5 6 7 8 9 10 11 12
//		        2
		
//		Sort.countingSort(arr);
		
		
        
//        Heap heap = new Heap(arr);
        Sort.arrHeap = arr;
        
        Sort.buildMaxHeap();
        
        Sort.printArr();
        System.out.println();

		
		
		
		
	}

}
