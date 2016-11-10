package gettissu;

public class BubbleSort {
	double temp;
	Tissu tissu_temp;
	
	public BubbleSort(double[] arr, Tissu[] tissu){
		
		System.out.println("BubbleSolt arr = ");

		//초기 max = 8
		for(int max = arr.length - 1; max > 0; max--){
			//max = 8일때, 아래 for문은 8번 시행
			//m_arr[7] > m_arr[8] 불가
			//m_arr[6] > m_arr[7] 까지가능

			for(int j = 0; j < max; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					tissu_temp = tissu[j];
					tissu[j] = tissu[j+1];
					tissu[j+1] = tissu_temp;
				}
			}
			printArr(arr);
			System.out.println("");
		}
	}
	
	private void printArr(double[] arr){
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i]+ " ");
		}
	}
}
