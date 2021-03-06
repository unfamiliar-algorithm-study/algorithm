package linearlist;

public class Main {
	public static void main(String[] args){
		double[] arr1 = {2,3,5,1};
		double[] arr2 = {6,5,2,7,1,5};
		
		Poly poly1 = new Poly(arr1.length, arr1);
		Poly poly2 = new Poly(arr2.length, arr2);
		Poly poly3 = new Poly().addPoly(poly1, poly2);
		
		int newDegree = poly3.getDegree();
		
		for(int i=0 ;i<newDegree;i++){
			System.out.println(poly3.getCoef()[i]);
		}
	}

}
