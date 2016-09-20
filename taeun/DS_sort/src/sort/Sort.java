/**
 * 
 */
package sort;

import java.util.Arrays;

/**
 * @FileName : Sort.java
 * @Date : 2016. 9. 19.
 * @author : ChoiTaeEun
 * @description : 버블정렬, 선택정렬, 삽입정렬, 퀵소트, 병합정렬 구현
 */
public class Sort {

	public static void bubble(int[] arr) {
		for (int i = 0; i < arr.length; i++) { // 전체반복횟수
			for (int j = 0; j < arr.length - i - 1; j++) { // 내부 반복횟수
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void selection(int[] arr) {// 가장 작은 원소를 선택해서 왼쪽으로 정렬하는 알고리즘
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) { // min값 찾기
					min = arr[j];
					minIndex = j;
				}
			}
			// 가장 작은값을 왼쪽 정렬된 부분으로 switching
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void insertion(int[] arr) {

		// 왼쪽은 이미 정렬된 부분이라고 봄.
		// 그다음부터 하나하나 왼쪽에 정렬시킴 .

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i]; // item을 하나 선택
			int tempIndex = i;
			for (int j = i; (j > 0) && (arr[j - 1]) > temp; j--) { // 0~item전의 인덱스까지 반복해서 item앞에 j에서 멈춤
				arr[j] = arr[j - 1];
				tempIndex = j - 1;
			}
			arr[tempIndex] = temp;
		}
	}

	public static void quick(int[] arr) {
		quick(arr, 0, arr.length - 1);
	}

	private static void quick(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end); // pivot을 리턴하고 좌우로 분할
			quick(arr, start, pivot - 1);
			quick(arr, pivot + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) { // 노이해;..
		int pivot = arr[start];

		int i = start;
		int j = end + 1;
		do {
			do {
				i++;
			} while (i <= end && arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		} while (i < j);

		int temp = arr[start];
		arr[start] = arr[j];
		arr[j] = temp;

		return j;
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int start, int end){
		if(start < end){
			int middle = (start+end)/2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			merge(arr, start, middle, end);
		}
	}
	
	private  static void merge(int[] arr, int start, int middle, int end){ // 병합작업
		int[] tempArr = new int[ end - start + 1 ];  // 병합후 저장할 임시배열
		int k = 0; // 임시배열의 포인터
		
		int i = start; // 병합할 배열의 첫번째 포인터 
		int j = middle+1;// 병합할 배열의 두번째 포인터 
		while( k < end-start+1 ){ //임시배열이 꽉찰때까지 반복
			
			if(arr[i] < arr[j]){ //첫번째포인터가 더작으면
				tempArr[k++] = arr[i++]; //임시배열에 첫번째를 넣는다
			}else{ //두번째포인터가 더크면
				tempArr[k++] = arr[j++]; //임시배열에 두번째를 넣는다 
			}
			
			if( i == middle+1 ){ //첫번째포인터가 미들까지도달하면 
				while( j < end+1 ){ 
					tempArr[k++] = arr[j++]; //두번째포인터부터 마지막까지 임시배열에 싿 넣는다
				}
			}else if( j == end+1 ){ //두번째포인터가 끝까지 도달하면
				while( i < middle+1 ){
					tempArr[k++] = arr[i++]; //첫번째포인터부터 미들까지 임시배열에 싹다 넣는다
				}
			}
		}
		
		k=0;
		while(k < end-start+1){ //임시배열에 병합한 값을 실제 배열로 옮긴다
			arr[start+k] = tempArr[k];
			k++;
		}
		
		
	}
	

}
