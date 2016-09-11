/*
package polynomial;

public class Polynomial implements Comparable{

	
	private int degree; //차수 
	private double[] coefficient; //계수
	
	public Polynomial(int degree, double[] coefficient){
		this.degree = degree;
		this.coefficient = coefficient;
	}
	
	public Polynomial(int degree){
		this.degree = degree;
		this.coefficient = new double[degree+1];
		for(int i=0; i<coefficient.length; i++){
			coefficient[i] = 0;
		}
	}
	
	public int getDegree(){
		return this.degree;
	}
	
	public boolean isEmptyPolynomial(){
		for(int i=0; i < coefficient.length; i++){
			if(coefficient[i] != 0){ //계수가 하나라도 0이 아니면 fasle
				return false;
			}
		}
		return true; //모든 계수가 0이면 true
	}
	
//a.addPolynomial(b);
	public Polynomial addPolynomial(Polynomial addPolynomial){
		
		int degree = this.degree > addPolynomial.getDegree() ? this.degree : addPolynomial.getDegree();
		Polynomial resultPolynomial = new Polynomial(degree);
		
		int pointerDegree = 0;
		while(!isEmptyPolynomial() && !addPolynomial.isEmptyPolynomial()){
			
			int comparedValue = this.compareTo(addPolynomial);
			switch(comparedValue){
				case 1:
					resultPolynomial.addTerm(pointerDegree, this.coefficient[pointerDegree]);
					this.deleteTerm(pointerDegree);
					break;
				case 0:
					resultPolynomial.addTerm(pointerDegree, this.coefficient[pointerDegree] + addPolynomial.coefficient[pointerDegree]);
					this.deleteTerm(pointerDegree);
					addPolynomial.deleteTerm(pointerDegree);
					break;
				case -1:
					resultPolynomial.addTerm(pointerDegree, addPolynomial.coefficient[pointerDegree]);
					addPolynomial.deleteTerm(pointerDegree);
					break;
			
			
			
			}
			
			
			
			
		}
		
	}
	
	public void addTerm(int exponent, double coefficient){ //지수 계수
		this.coefficient[exponent] = coefficient;
	}
	
	public void deleteTerm(int exponent){
		this.coefficient[exponent] = 0;
	}
	
	
	@Override
	public int compareTo(Object comparePolynomial){
		if(this.degree > ((Polynomial)comparePolynomial).getDegree()){
			return 1;
		}else if(this.degree == ((Polynomial)comparePolynomial).getDegree()){
			return 0;
		}else if(this.degree < ((Polynomial)comparePolynomial).getDegree()){
			return -1;
		}
		return -2;//error
	}
}

*/