/**
 * 
 */
package sort;

import java.awt.HeadlessException;

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

}
