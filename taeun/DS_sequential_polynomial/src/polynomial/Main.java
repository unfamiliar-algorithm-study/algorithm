/*
 * 2016.08.31
 * 설명: 다항식의 덧셈 순차 자료구조 구현.
 * 
 * TODO : 코드가 무지더러움 슈도코드대로 하는것이 좋을듯
 * TODO : 곱셈과 나눗셈기능도 추가해야함
 * 
 * */
package polynomial;

public class Main {

	public static void main(String[] args) {
		
		double[] coefficientArrayA = {9, 3, 5, 0, 4, 10, -8, 4, 6};
		double[] coefficientArrayB = {8, 1, -3, 2.5, 1.8};
		
		Polynomial a = new Polynomial(8, coefficientArrayA);
		Polynomial b = new Polynomial(4, coefficientArrayB);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		long start = System.currentTimeMillis();
		Polynomial c = a.addPolynomial(b);
		long end = System.currentTimeMillis();
		
		System.out.println(c.toString());
		System.out.println((end-start)/1000.0);
		
	}

}
