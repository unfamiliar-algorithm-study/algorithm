package highsort;

public class Main {
	public static void main(String[] args){
		int[] arr1 = {73, 45, 63, 26, 37, 31, 18, 5};
		int[] arr2 = {73, 45, 26, 16, 63, 8, 31, 22};

		QuickSort quicksort = new QuickSort();
		quicksort.quicksort(arr1, 0, arr1.length -1);
		
		System.out.println("QuickSort");		
		
		for(int i = 0; i< arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println(" ");		
		
		MergeSort mergesort = new MergeSort();
		mergesort.mergeSort(arr2, 0, arr2.length -1);
		
		System.out.println("MergeSort ");		
		
		for(int i = 0; i< arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println(" ");		
		
	}
	
	
}