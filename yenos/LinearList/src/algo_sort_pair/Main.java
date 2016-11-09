/**
 * 
 */
package algo_sort_pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yenos
 * @date 2016. 10. 15.
 */
public class Main {

	/**
	 * @date
	 * @param args
	 */

	static ArrayList<String> result  = new ArrayList<>();
	static ArrayList<Integer> isVisit = new ArrayList<>();
	

	public static void canISort(ArrayList<Integer> arrElements) {

		ArrayList<Integer> arrSmallestPairIndex = getSmallest(arrElements);
		System.out.println("====== smallestPairsIndex ======");
		for (int a : arrSmallestPairIndex) {
			System.out.println(a);
		}
		//
		int smallestInArr = getSmallestValue(arrElements);
		System.out.println("smallest ==> "+smallestInArr);
		System.out.println("0==>" + arrElements.get(0));
		System.out.println("0==>" + arrElements.get(0).intValue());



		// 처음값이 가장작은값이냐?
		if (smallestInArr == arrElements.get(0).intValue() && isVisit.size()==arrElements.size()*2+2) {
			isVisit.clear();
			// 정렬되었나체크
			System.out.println("정렬 판 별 ");
			boolean isSort=true;
			for(int i=1;i<arrElements.size();i++){
				//뒤에것이 항상크다면 투
				if(arrElements.get(i-1)<arrElements.get(i)){
					isSort = true;
					
				}else{
					isSort = false;
					break;
				}
			}

			if(isSort){
				result.add("YES");
			}else{
				result.add("NO");
			}

		} else {

			// 해당 부분을 없애고.
			int right = arrElements.get(arrSmallestPairIndex.get(1).intValue());
			int left = arrElements.get(arrSmallestPairIndex.get(0).intValue());

			System.out.println("rihgt " + right);
			System.out.println("rihgt " + left);

			arrElements.remove(arrSmallestPairIndex.get(1).intValue());
			arrElements.remove(arrSmallestPairIndex.get(0).intValue());
			
			
			// 아닐경우 맨앞으로 가져옴.
			int valAddin = 0;
			
//			int justOne = 0;
//			for(int j=0;j<left;j++){
//				//left가 더커지는 찰라에 밀어넣으
//
////				if(arrElements.get(j) > left){
////					if(justOne ==0){
////						arrElements.add(j, left);
////						arrElements.add(j+1, right);
////						justOne++;
////					}
////					
////				}
//
//			}
			

			// 왼쪽이 더작은 경우면 0,1이아니라 1,2에추가한다.
//			if (arrElements.get(0) < left) {
//				arrElements.add(1, left);
//				arrElements.add(2, right);
//				// right와 left를가장 앞으로 가져온다.
//			} else {
//				arrElements.add(0, left);
//				arrElements.add(1, right);
//			}
			
			int vistValue = -1;
			for(int j=1;j<isVisit.size();j++){
				//왼쪽 오른쪽이 한버이라도 true이면 그 왼쪽 오른쪽은 돌지 않는다.
				if(isVisit.get(j-1)==left &&isVisit.get(j)==right){
					vistValue = j;
				}else{

				}	
			}

			
				arrElements.add(vistValue, left);
				arrElements.add(vistValue+1, right);
				
			System.out.println("====== LAST  let's Recursiv ======");
			for (int a : arrElements) {
				System.out.println(a);
			}

			// 방문여부를 파악
//			isVisit.clear();
			isVisit.add(left);
			isVisit.add(right);
			System.out.println("====== LAST  isVIsit======");
			for (int a : isVisit) {
				System.out.println(a);
			}


			canISort(arrElements);
			
		}

	}

	public static int getSmallestValue(ArrayList<Integer> arrElements) {
		int smallest = 0;
		for (int i = 0; i < arrElements.size(); i++) {
			if (i == 0) {
				smallest = arrElements.get(i);
			}
			if (smallest > arrElements.get(i)) {
				smallest = arrElements.get(i);
			}
		}
		return smallest;
	}

	public static ArrayList<Integer> getSmallest(ArrayList<Integer> arrElements) {

		int smallest = 10000;
		

		ArrayList<Integer> arrSmallestPair = new ArrayList<>();
		for (int i = 1; i < arrElements.size(); i++) {
			int left = arrElements.get(i - 1);
			int right = arrElements.get(i);
			int sum = left + right;
			System.out.println("left/right= "+left+" "+right);
			
			boolean isVistt = false;
			for(int j=1;j<isVisit.size();j++){
				//왼쪽 오른쪽이 한버이라도 true이면 그 왼쪽 오른쪽은 돌지 않는다.
				if(isVisit.get(j-1)==left &&isVisit.get(j)==right){
					isVistt = true;

				}else{
				}	
			}


			if (isVistt) {
				//is Vist이랑 겹치는건 패스다. 
				//이미 순환했기떄				
			} else {
				if (i == 1) {
					smallest = sum;
					
					arrSmallestPair.clear();
					arrSmallestPair.add(i - 1);
					arrSmallestPair.add(i);
				} else {
					// 합이 스몰리스트보다작다면.
					if (sum < smallest) {
						System.out.println("sum<smallest");
						smallest = sum;
						
						arrSmallestPair.clear();
						// 인덱스를 저장하고있는다.
						arrSmallestPair.add(i - 1);
						arrSmallestPair.add(i);
					} else if (sum == smallest) {
						
						arrSmallestPair.clear();
						arrSmallestPair.add(i - 1);
						arrSmallestPair.add(i);
						System.out.println("sum==same");
						// 기존에있는것과 앞자리 비교한다.
						// 앞자리는 정렬에서 매우 중요하다.
						int prev = arrElements.get(arrSmallestPair.get(0));
						int current = left;
						// 만약 현재 것의 앞자리가 저번것보다 작다면
						// 현재것으로 바꿔줘야한다.
						if (current < prev) {
							System.out.println("current<prev");
							arrSmallestPair.clear();
							// 인덱스를 저장하고있는다.
							arrSmallestPair.add(i - 1);
							arrSmallestPair.add(i);
							// 아니라면 그냥 아무것도하지않고 과거것을 가지고 있는다.
						} else {

						}
					}
				}

			}
		}
		return arrSmallestPair;
	}

	public static void main(String[] args) {
		System.out.println("start");

		isVisit.add(-100);
		isVisit.add(-100);
		// //check getSmallest
		// ArrayList<Integer> tmpArr = new ArrayList<>();
		// tmpArr.add(10);
		// tmpArr.add(3);
		// tmpArr.add(7);
		// tmpArr.add(40);
		// tmpArr.add(1);
		// tmpArr.add(1);
		// canISort(tmpArr);
		// for(int t:tmpArr){
		// System.out.println(t);
		// }

		// ArrayList<Integer> tmp = getSmallest(tmpArr);
		// System.out.println(tmpArr.get(tmp.get(0)));
		// System.out.println(tmpArr.get(tmp.get(1)));

		Scanner scan = new Scanner(System.in);
		int cntQuiz;

		System.out.println("how ?");
		cntQuiz = scan.nextInt();

		int cntElement;

		ArrayList<Integer> arrElements = new ArrayList<>();

		for (int i = 0; i < cntQuiz; i++) {
			System.out.println("element cnt ?");
			arrElements.clear();
			cntElement = scan.nextInt();
			for (int j = 0; j < cntElement; j++) {
				int elemnts = scan.nextInt();
				arrElements.add(elemnts);
			}

			canISort(arrElements);			

		}
		for(String result : result){
			System.out.println(result);
		}

	}

}
