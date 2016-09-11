package polynomial;

public class Polynomial {

	private double[] coefficient; //계수 배열 
	private int degree; //차수 
	
	public Polynomial(int degree, double[] coefficient){
		this.coefficient = coefficient;
		this.degree = degree;
	}
	
	public Polynomial(int degree){
		this.coefficient = new double[degree+1];
		this.degree = degree;
	}
	
	public Polynomial getEmptyPolynomial(int degree){
		Polynomial emptyPolynomial = new Polynomial(degree);
		return emptyPolynomial;
	}
	
	public double getCoefficient(int exponent){
		return this.coefficient[exponent];
	}
	
	/*
	 * @param exponent : 차수(인덱스)
	 * @param value : 값 
	*/
	public void setCoefficient(int exponent, double value){ 
		this.coefficient[exponent] = value;
	}
	
	public int getCoefficientLength(){
		return this.coefficient.length;
	}
	
	public int getDegree(){
		return this.degree;
	}
	
	public void setDegree(int degree){
		this.degree = degree;
	}
	
	public int getGapDegree(Polynomial addPolynomial){ //현재다항식과 매개변수로받은 다항식의 최고차수의 차이를구하는 메소드
		
		int gapDegree = this.degree - addPolynomial.getDegree();
		if(gapDegree < 0){ 
			return gapDegree*(-1);
		}
		return gapDegree;
	}
	
	public Polynomial getCompareLongPolynomial(Polynomial addPolynomial){ //현재다항식과 매개변수로받은 다항식중 더 큰 차수의 다항식을 구하는 메소드 
		if(this.degree > addPolynomial.getDegree()){
			return this;
		}else{
			return addPolynomial;
		}
	}
	
	public int getCompareMaxDegree(Polynomial addPolynomial){ //둘중 더 큰 차수를 비교해서 구하는 메소드 
		return this.degree > addPolynomial.getDegree() ? this.degree : addPolynomial.getDegree();
	}
	
	public int getCompareMinDegree(Polynomial addPolynomial){ //둘중 더 작은 차수를 비교해서 구하는 메소드
		return this.degree < addPolynomial.getDegree() ? this.degree : addPolynomial.getDegree();
	}
	
	public Polynomial addPolynomial(Polynomial addPolynomial){
		
		int resultDegree = this.getCompareMaxDegree(addPolynomial); //결과 다항식의 배열을 만들기위해 두 다항식중 더 큰 차수를 알아낸다.
		Polynomial resultPolynomial = this.getEmptyPolynomial(resultDegree);
		this.addTerms(resultPolynomial, addPolynomial);
		
		return resultPolynomial;
	}
	
	public void addTerms(Polynomial resultPolynomial, Polynomial addPolynomial){ 
		
		int repeatCount = this.getCompareMinDegree(addPolynomial)+1; //두 다항식중 더 작은 차수만큼 루프돌기위한 변수 
		
		for(int i=0; i <  repeatCount ; i++){ // 두 다항식중 작은다항식의 차수만큼 다항식 두개를 더함.. 
			double value = this.getCoefficient(this.degree-i) + addPolynomial.getCoefficient(addPolynomial.getDegree()-i);
			resultPolynomial.setCoefficient(resultPolynomial.getDegree()-i, value);  
		}
		
		repeatCount = this.getGapDegree(addPolynomial); // 두 다항식의 차수의 차이를 구함 (n번 돌기위해 ) 
		
		for(int i=0; i<repeatCount ; i++){ //n번도는데 
			resultPolynomial.setCoefficient(i, this.getCompareLongPolynomial(addPolynomial).getCoefficient(i)); //결과 다항식에 긴다항식의배열 처음부터 차이만큼 똑같이 넣어줌. )
		}
		
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < this.degree+1; i++){
			
			if(this.getCoefficient(i)!=0){
				if(i != 0){
					sb.append(" + ");
				}
				sb.append(this.getCoefficient(i)+"X^"+(this.degree-i));
			}
		}
		return sb.toString();
	}
	
}
