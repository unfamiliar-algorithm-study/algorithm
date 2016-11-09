package top7_2;
import java.util.*;

/*
 * 2016.11.9
 * 회사조직급여 문제 
 * ...O(n^4)인듯하다.........
 * */
public class Main {
	
	public static void main(String[] args){
		
		/*
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String[] relations = new String[n];
		for(int i=0; i<n; i++){
			relations[i] = input.nextLine();
		}
		*/
		String[] relations = {
								"NNNNNN",
								"YNYNNY",
								"YNNNNY",
								"NNNNNN",
								"YNYNNN",
								"YNNYNN"
						};
		
		long start = System.currentTimeMillis();
		long salary = totalSalary(relations);
		long end = System.currentTimeMillis();
		
		System.out.println(salary);
		System.out.println((end-start));
		
	}
	
	public static long totalSalary(String[] relations){
		
		int relationLen = relations.length;
		long[] salaryMemo = new long[relationLen];
		
		StringBuilder regex = new StringBuilder();
		StringBuilder finishRegex = new StringBuilder();
		for(int i=0; i<relationLen; i++){
			salaryMemo[i] = 0; //memo 초기화
			regex.append("N"); //정규표현식 N으로 초기화
			finishRegex.append(".");
		}
		String startRegex = regex.toString();
		
		
		//초기값 셋팅
		for(int i=0; i<relationLen; i++){
			if(relations[i].equals(startRegex)){
				salaryMemo[i] = 1;
				fixRegex(i, regex);
				
			}
		}
		
		//모든 점들을 방문했을동안 돈다.
		while(!regex.toString().equals(finishRegex.toString())){
			for(int i=0; i<relationLen; i++){ //한행씩 검사한다
				if(regex.charAt(i)!='.'){ //현재 정규식이 .인곳의 인덱스는 이미 방문한것이라고 생각, 방문안한곳을 체크
					
					if(relations[i].matches(regex.toString())){ //해당 행과 정규식이 매치되면
						salaryMemo[i] = getSalary(relations[i], salaryMemo); //해당행이 Y인곳들의 합을 더해서 행인덱스의 표현식을 .으로바꿔줌.
						fixRegex(i, regex);
					}
				}
			}
		}
		
		return getSum(salaryMemo); 
	}
	
	public static long getSalary(String relation, long[] salaryMemo){ //Y인 곳의 salary들의 합을 구해주는 메소드
		long sum = 0;
		int target = 'Y';
		int len = relation.length();
		for(int i=0; i<len; i++){
			if(target == relation.charAt(i)){
				sum += salaryMemo[i];
			}
		}
		return sum;
	}
		
	public static void fixRegex(int index, StringBuilder regex){ //해당 index의 표현식을 .으로 수정하는메소드
		regex.insert(index, '.');
		regex.deleteCharAt(index+1);
	}

	public static long getSum(long[] salaryMemo){ //salaryMemo 합계내는 메소드
		long sum = 0;
		for(long s : salaryMemo){
			sum+=s;
		}
		return sum;
	}

}
