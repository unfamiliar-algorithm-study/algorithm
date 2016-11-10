package top7_2;

public class Main2 {

	private static long[] salaries;
	
	public static long totalSalary(String[] relations){
		salaries = new long[relations.length];
		
		long total = 0;
		for(int i=0; i<relations.length;i++){
			total+= getSalary(i, relations);
		}		
		return total;
	}
	
	private static long getSalary(int i, String[] relations){
		if(salaries[i] == 0){
			long salary = 0;
			String relation = relations[i];
			
			for(int j=0; j<relation.length(); j++){
				if(relation.charAt(j)=='Y'){
					salary+=getSalary(j, relations);
				}
			}
			
			if(salary == 0){
				salary=1;
			}
			salaries[i] = salary;
		}
		return salaries[i];
	}
	
	public static void main(String[] args){
		
		
		String[] relations = {
								"NNNNNN",
								"YNYNNY",
								"YNNNNY",
								"NNNNNN",
								"YNYNNN",
								"YNNYNN"
						};
		
		long start = System.currentTimeMillis();
		long result = totalSalary(relations);
		long end = System.currentTimeMillis();
		
		System.out.println(result);
		System.out.println((end-start));
	}
}
