/**
 * 
 */
package algoTree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yenos
 * @date 2016. 9. 23.
 */
public class main {

	/**
	 * @date
	 * @param args
	 */

	public static ArrayList<String> queuee = new ArrayList<>();

	public static String binNumber(int size) {
//		Random rg = new Random();
//		int n = rg.nextInt();
//		return Integer.toBinaryString(n).substring(0, size);
		if(size==1){
			return "0";
		}else if(size==2){
			return "01";	
		}else {
			String a ="";
			for(int i=0;i<size/2;i++){
				a+="01";
			}
			return a;
		}
	}
//(0101)(0101)(0101)(0101)
	public static void main(String[] args) {
		
		// System.out.println(binNumber(8));
		int cnt = 0;
		Scanner scan = new Scanner(System.in); // 문자 입력을 인자로 Scanner 생성
		// System.out.println("몇줄?");
		cnt = scan.nextInt();
		// 2
//		while (cnt < 65) {

//			int randomVal = cnt;


			int[][] table = new int[cnt][cnt];

			String message;

			for (int i = 0; i < cnt; i++) {

				 message = scan.next();

//				message = binNumber(randomVal);
//				System.out.println(message);

				// 나눠서. 스트링 배열에 저장..
				String[] arrMessage = message.split("");

				// 인트로받을 곳.
				for (int j = 0; j < cnt; j++) {
					table[i][j] = Integer.parseInt(arrMessage[j]);
				}
			}
			queuee = new ArrayList<>();
			// 배열의 길이를 반으로 나눈다. 그리고 나눈만큼 for 루프를 돌린다.
			넷으로나눠서불러오는능력(table);
			System.out.println(result());
//ss
//		}

	}

	public static void 넷으로나눠서불러오는능력(int 이중배열[][]) {
		int 이중배열길이 = 이중배열[0].length;

		int[][] 분할된이중배열 = new int[이중배열길이 / 2][이중배열길이 / 2];
		int 사각형의합 = 0;
		if(이중배열길이/2==1){
//			System.out.println("이중배열이 1개일때이다.");
			queuee.add("(");
			for (int i = 0; i < 이중배열길이 ; i++) {
				for (int j = 0; j < 이중배열길이 ; j++) {
					if(이중배열[i][j]==0){
						queuee.add("0");

					}else{
						queuee.add("1");

					}
				}
			}
			
			queuee.add(")");
		}

		if (이중배열길이 > 1) {
			queuee.add("(");

			사각형의합 = 0;
			// System.out.println("----------- 좌상 -----------" + 이중배열길이);
			for (int i = 0; i < 이중배열길이 / 2; i++) {
				for (int j = 0; j < 이중배열길이 / 2; j++) {
					// System.out.print(이중배열[i][j]);
					분할된이중배열[i][j] = 이중배열[i][j];

					사각형의합 += 이중배열[i][j];
				}
				// System.out.println();

			}
//			 System.out.println("사각혀으이합 ==> "+사각형의합 );
//			 System.out.println("사각혀으이합 ==> "+(이중배열길이 / 2) );
			// 이중배열이 1개보다 클때 그리고 내부합이 0 이아니거나 모두 1이여서 합이 해당배열의칸보다 작을떄는 섞여있을
			// 경우임으로 다시 돌려서 구한다.
			if (이중배열길이 > 1 && 사각형의합 != 0 && 사각형의합 != (이중배열길이 / 2) * (이중배열길이 / 2)) {
				넷으로나눠서불러오는능력(분할된이중배열);
			} else if (사각형의합 == 0) {
				// 모두 0 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("0");
			} else if (사각형의합 == (이중배열길이 / 2) * (이중배열길이 / 2)) {
				// 모두 1 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("1");
			}

			사각형의합 = 0;
			// System.out.println("----------- 우상 -----------" + 이중배열길이);
			for (int i = 0; i < 이중배열길이 / 2; i++) {
				for (int j = 이중배열길이 / 2; j < 이중배열길이; j++) {
					// System.out.print(이중배열[i][j]);
					분할된이중배열[i][j - 이중배열길이 / 2] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j];

				}
				// System.out.println();
			}
			// System.out.println("사각혀으이합 ==> "+사각형의합 );
			if (이중배열길이 > 1 && 사각형의합 != 0 && 사각형의합 != (이중배열길이 / 2) * (이중배열길이 / 2)) {
				넷으로나눠서불러오는능력(분할된이중배열);
			} else if (사각형의합 == 0) {
				// 모두 0 일 경우.
				// queuee.add(이중배열길이*-1);
				// queuee.add();

				queuee.add("0");
			} else if (사각형의합 == (이중배열길이 / 2) * (이중배열길이 / 2)) {
				// 모두 1 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("1");
			}

			사각형의합 = 0;
			// System.out.println("----------- 좌하 -----------" + 이중배열길이);
			for (int i = 이중배열길이 / 2; i < 이중배열길이; i++) {
				for (int j = 0; j < 이중배열길이 / 2; j++) {
					// System.out.print(이중배열[i][j]);
					분할된이중배열[i - 이중배열길이 / 2][j] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j];
				}
				// System.out.println();
			}

			// System.out.println("사각혀으이합 ==> "+사각형의합 );
			if (이중배열길이 > 1 && 사각형의합 != 0 && 사각형의합 != (이중배열길이 / 2) * (이중배열길이 / 2)) {
				넷으로나눠서불러오는능력(분할된이중배열);
			} else if (사각형의합 == 0) {
				// 모두 0 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("0");
			} else if (사각형의합 == (이중배열길이 / 2) * (이중배열길이 / 2)) {
				// 모두 1 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("1");
			}

			사각형의합 = 0;
			// System.out.println("---------- 우하 -----------" + 이중배열길이);
			for (int i = 이중배열길이 / 2; i < 이중배열길이; i++) {
				for (int j = 이중배열길이 / 2; j < 이중배열길이; j++) {
					// System.out.print(이중배열[i][j]);
					분할된이중배열[i - 이중배열길이 / 2][j - 이중배열길이 / 2] = 이중배열[i][j];
					사각형의합 += 이중배열[i][j];
				}
				// System.out.println();

			}

			// System.out.println("사각혀으이합 ==> "+사각형의합 );
			if (이중배열길이 > 1 && 사각형의합 != 0 && 사각형의합 != (이중배열길이 / 2) * (이중배열길이 / 2)) {
				넷으로나눠서불러오는능력(분할된이중배열);
			} else if (사각형의합 == 0) {
				// 모두 0 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("0");
			} else if (사각형의합 == (이중배열길이 / 2) * (이중배열길이 / 2)) {
				// 모두 1 일 경우.
				// queuee.add(이중배열길이*-1);
				queuee.add("1");
			}
			queuee.add(")");
		}

	}

	public static String result() {
		String result = "";
		for (int i = 0; i < queuee.size(); i++) {

			result += queuee.get(i);
		}
		return result;
	}
}
