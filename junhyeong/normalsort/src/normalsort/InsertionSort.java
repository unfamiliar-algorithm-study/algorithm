package normalsort;

public class InsertionSort {
	int temp;
	int j;
	public InsertionSort(int[] arr){
		
		System.out.println("InsertioneSolt arr = ");

		//크기 8에서 첫번재 값은 정렬된 것
		//두번째 값부터 마지막 까지 총 7개 값
		for(int i = 1; i < arr.length; i++){
			temp = arr[i];
			//i = 2일때,
			//j = 2, j>0, arr[2](26) < arr[1](73),
			//arr[2] = arr[1]  => 45 73 73
			for(j = i ; (j > 0) && (temp < arr[j - 1]) ; j--){
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
			
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
