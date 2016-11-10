import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CorporationSalary {
	
	static int[] salary;
	static int wordSize;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int size;
		String inputRelations;	//처음에 입력받을 전체 문자열
		String[] relations;	//문자열을 단어로 쪼개서 저장할 배열
		
		inputRelations = sc.nextLine(); 
		size = (int) Math.sqrt(inputRelations.length()); //문자열을 단어로 몇개 쪼갤수 있는지 길이 구하는 식
		System.out.println(size);
		
		relations = new String[size];	//배열 단어갯수만큼 할당
		salary = new int[size];
		StringTokenizer st = new StringTokenizer(inputRelations, " "); //공백단위로 쪼개기 위한 토큰
		
		for(int i = 0; i < size; i++){
			relations[i] = st.nextToken();	//배열에 단어 입력
			System.out.println(relations[i]);
		}
		totalSalary(relations);
		System.out.println(Arrays.toString(salary));
	}
	
	public static long totalSalary(String[] relations){
		wordSize = relations[0].length();
		
		for(int index = 0; index < relations.length ; index++){
			//해당 인덱스의 급여가 getSalary로 인해 채워지지 않았을때 만 진행
			if(salary[index] == 0){
				for(int index_word = 0; index_word < wordSize; index_word++){			
					//글자가  Y일 때 해당 직원의 급여를 가져와야한다
					if(relations[index].charAt(index_word) != 'N'){
						if(salary[index_word] == 0)
						{	
							getSalary(relations, index_word);
						}
						//Y가 있는 위치의 급여를 가져와서 자기 급여에 더한다	
						salary[index] += salary[index_word];

					}
				}
			}
			
			//오직 가장 첫번째 사원이 모두 N인 최말당 사원일때만 생각한 조건문
			if(salary[index] == 0){
				salary[index] = 1;
			}		
		}
		return 0;
	}
	
	public static long getSalary(String[] relations, int index){
		
		//처음 NNYY일때
		//index 2,3에 Y가 있다
		//단어에 Y가 있다면 해당 인덱스의 단어로 이동해 최말단인지 확인한다.
		//index 2에서 먼저 getsalary 실행
		//salary[0] = salary [2] + salary[3]
		//			= 1 + salary[2]
		for(int index_word = 0; index_word < wordSize; index_word++){
			if(relations[index].charAt(index_word) != 'N' )
			{
				if(salary[index_word] == 0)
					getSalary(relations, index_word);
				salary[index] += salary[index_word];
			}
		}
		
		//위 작업을 겨쳤는데 아직 0이면 최말단 사원이다
		if(salary[index] == 0){
			salary[index] = 1;
		}	
		return 0;
	}
}
