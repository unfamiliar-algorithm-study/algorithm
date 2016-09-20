package normalsort;

public class SelectionSort {
	
	int temp;
	
	public SelectionSort(int[] arr){
		
		System.out.println("SelectionSolt arr = ");
		for(int min = 0; min < arr.length - 1 ; min++){
			for(int j = min+1 ; j < arr.length; j++){
				if(arr[min] > arr[j]){
					temp = arr[min];
					arr[min] = arr[j];
					arr[j] = temp;
				}
			}
			printArr(arr);
			System.out.println("");
		}
	}
	
	private void printArr(int[] arr){
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i]+ " ");
		}
	}
}
