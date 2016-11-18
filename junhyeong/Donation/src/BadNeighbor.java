import java.util.ArrayList;
import java.util.Scanner;

public class BadNeighbor {
	
	static int[] sumDonation;

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int number;
		int[] arrDonation;
		
		System.out.print("이웃집 숫자 = ");
		number = sc.nextInt();
		
		arrDonation = new int[number];
		sumDonation = new int[number];
		
		System.out.print("donations = ");
		for(int i = 0; i < number; i++){
			arrDonation[i] = sc.nextInt();
		}
		
		System.out.print("최대 기부금 = " + maxDonations(arrDonation));
		
		
		
	}
	//더한 배열중 최대값을 찾는다
	public static int maxDonations(int[] donations){
		
		int maxSum = 0;
		
		for(int i = 0; i < donations.length; i++){
			maxSum = Math.max(maxSum, sumDonations(donations, i)); 
		}
		
		return maxSum;
	}
	//세가지 경우에 따라서 배열을 채워나간다
	//1,2번째 집은 그대로 내려오고
	//3번째 집은 첫번쨰 집을  더한값
	//4번째 집부터는 한칸 띄우고 두집중 큰집을 찾아 자신의 값 더한다
	public static int sumDonations(int[] donations, int start){
		
		int address = start;
		int length = donations.length;
		
		for(int i = 0; i < length - 1; i++){
			if(i > 2){
				sumDonation[i] = Math.max(sumDonation[i-2], sumDonation[i-3]) 
									+ donations[address];
			}
			//1~3번째 집까지에 대한 경우 그대로 내린다
			else{
				sumDonation[i] = donations[address];
				if(i == 2){
					sumDonation[i] = sumDonation[0] + donations[address];
				}
			}
			address++;
			address %= donations.length;

		}
		return sumDonation[donations.length-2];
	}
	
}
