package polynomial;

public class Polynomial {

	private double[] coefficient;
	private int degree;
	
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
	
	public int getGapDegree(Polynomial addPolynomial){
		
		int gapDegree = this.degree - addPolynomial.getDegree();
		if(gapDegree < 0){ 
			return gapDegree*(-1);
		}
		return gapDegree;
	}
	
	public Polynomial getCompareLongPolynomial(Polynomial addPolynomial){
		if(this.degree > addPolynomial.getDegree()){
			return this;
		}else{
			return addPolynomial;
		}
	}
	
	public int getCompareMaxDegree(Polynomial addPolynomial){
		return this.degree > addPolynomial.getDegree() ? this.degree : addPolynomial.getDegree();
	}
	
	public int getCompareMinDegree(Polynomial addPolynomial){
		return this.degree < addPolynomial.getDegree() ? this.degree : addPolynomial.getDegree();
	}
	
	public Polynomial addPolynomial(Polynomial addPolynomial){
		
		int resultDegree = this.getCompareMaxDegree(addPolynomial);
		Polynomial resultPolynomial = this.getEmptyPolynomial(resultDegree);
		this.addTerms(resultPolynomial, addPolynomial);
		
		return resultPolynomial;
	}
	
	public void addTerms(Polynomial resultPolynomial, Polynomial addPolynomial){
		
		int repeatCount = this.getCompareMinDegree(addPolynomial)+1;
		for(int i=0; i <  repeatCount ; i++){
			double value = this.getCoefficient(this.degree-i) + addPolynomial.getCoefficient(addPolynomial.getDegree()-i);
			resultPolynomial.setCoefficient(resultPolynomial.getDegree()-i, value);  
		}
		repeatCount = this.getGapDegree(addPolynomial);
		for(int i=0; i<repeatCount ; i++){
			resultPolynomial.setCoefficient(i, this.getCompareLongPolynomial(addPolynomial).getCoefficient(i));
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
