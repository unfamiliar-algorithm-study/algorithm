/**
 * 
 */
package AlgoBook;

import java.util.StringTokenizer;

/**
 * @author yenos
 * @date 2016. 11. 8.
 */
public class Salary {

	int arrMe[] = new int[6];
	
	public int getSalary(String[] relation){
		
		//relation size만큼.
		//{nnyn,nnyn,nnnn,nyyn}
		// 0 은 2의 매니저
		// 1 은 2의 매니저
		// 3 은 1, 2의 매니저 
		// 0 은 salary (0) = salary(2) 
		// 1 은 salary (1) = salary (2) 
		//3 은 salary(3) = salary(1)+salary(2)
		int sums = 0;
		
		// 초기값을 1로 세팅해둔다.
		// 결국 말단 인턴나부랭이는 무조건 1임으로.
		for(int i=0;i<relation.length;i++){
			String ele = relation[i];
			if(ele=="NNNNNN"){
				arrMe[i] = 1;
			}
		}

		System.out.println("start sums =>"+sums);
		//한명씩 판단하면서 돌아가는데
		// 매번 해당 인원의 해당하는 값이 있는지를 판단하고 없다면 만들어서 넣어주고.
		// 만약 있다면 해당 값을 가져오면 되는것이다.
		for(int i=0;i<relation.length;i++){
			sums+=midsalary(i, relation);
			
		}
		
		return sums;
	}
	
	public int midsalary(int i,String[] relation){
		if(arrMe[i]==0){
			int indiSalary = 0;
			String ele = relation[i];
			System.out.println(ele);
	
	
			for(int j=0;j<ele.length();j++){
				
				char single = ele.charAt(j);
				// Y일경우 해당값을 출력하고 현재가 arrMe ==0일때임으로
				// 아직 i번째사람에대한 검색및arrMe에 저장이 되지않는상태이다.
				if(single=='Y'){
					System.out.println(i+"번쨰의 "+"call calcSalary=>"+j+"번");					
					indiSalary += midsalary(j, relation);
					System.out.println("sum +>"+indiSalary);
				}				
				
			}
			
			//임시변수에 해당 데이터의 샐러리값을 추가한다.
			//
			if(ele!="NNNNNN"){
				arrMe[i] = indiSalary;
			}
			
		}
		return arrMe[i];

//		for(int k=0;k<arrMe.length;k++){
//			System.out.println(arrMe[k]);
//		}
	}
	
	//arrMe
	// 0 0 1 0 0 0 000 ...
	
//	public int calcSalary(int nums,int[] arrMe){
//		if(arrMe[nums]==0){
//			return 0; 
//		}else{
//			return 1; 
//		}
////		return 1;	
//	}
}
