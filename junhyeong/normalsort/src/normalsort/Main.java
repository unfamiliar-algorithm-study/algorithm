package normalsort;

public class Main {
	public static void main(String[] args){
		int[] arr1 = {69, 10, 30, 2, 16, 8, 31, 22};
		int[] arr2 = {73, 45, 63, 26, 37, 31, 18, 5};
		int[] arr3 = {73, 45, 26, 16, 63, 8, 31, 22};

		SelectionSort selectionsort = new SelectionSort(arr1);
		BubbleSort bubblesort = new BubbleSort(arr2);
		InsertionSort insertion = new InsertionSort(arr3);
	}
}
