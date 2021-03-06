package highsort;

public class QuickSort {
	
	public QuickSort(){
	}
	
	public void quicksort(int[]arr, int begin, int end){
		int left;
		int right;
		int pivot;
		int temp;
		if(begin < end){
			left = begin +1;
			right = end;
			pivot = arr[begin];

			while(left < right){
				while(arr[left] < pivot && left < end){
					left++;
				}
				while(arr[right] > pivot && right > begin){
					right--;
				}
				if(left < right){
					temp = arr[right];
					arr[right] = arr[left];
					arr[left] = temp;
				}
				System.out.println(left +" " + right + " ");
			}
			arr[begin] = arr[right];
			arr[right] = pivot;
			
			tracer(arr, arr.length);
			quicksort(arr, begin, right-1);
			quicksort(arr, right+1, end);

		}
	}
	
	public void tracer(int[] arr, int len){
		int i;
		for(i = 0; i<len; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println("");
	}
}
