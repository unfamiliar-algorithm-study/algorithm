package highsort;

public class MergeSort {

	public void mergeSort(int[] arr, int left, int right){
		int middle;
		if( left < right){
			middle = (left + right) / 2;

			System.out.println("middle index = " + middle);
			System.out.println("왼쪽 정렬");
			
			for(int i = 0; i < middle; i++)
				System.out.print(arr[i]+ " ");
			
			System.out.println("");			
			System.out.println("오른쪽 정렬");
			
			for(int i = middle; i < right; i++)
				System.out.print(arr[i]+ " ");
			
			System.out.println("");			
			
			mergeSort(arr, left, middle);
			//왼쪽에서 중간까지 분할후 다시 왼쪽 배열에 대해서 다 분할
			mergeSort(arr, middle+1, right);
			//중간부터 오른쪽까지 분할
			
			
			merge(arr, left, middle, right);
		}
	}
	public void merge(int[] arr, int left, int middle, int right){
		int i, j, k, m;
		i = left;
		j = middle + 1;
		k = left;
		
		int[] temp = new int[arr.length];
		
		while(i <= middle && j <= right){
			if(arr[i] < arr[j]){
				temp[k] = arr[i];
				i++;
			}else{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i > middle){
			for(m = j; m<= right; m++){
				temp[k] = arr[m];
				k++;
			}
		} else{
			for(m = i; m<= middle; m++){
				temp[k] = arr[m];
				k++;
			}
		}
		
		for(m = left; m<= right; m++){
			arr[m] = temp[m];
		}
	}
}
