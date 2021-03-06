package linearlist;

public class Poly {
	private int degree;
	private double[] coef;
	
	public Poly(){
		
	}
	
	public Poly(int degree, double[] coef){
		this.degree = degree;
		this.coef = coef;
	}
	
	public int getDegree(){
		return degree;
	}
	
	public double[] getCoef(){
		return this.coef;
	}
	//두 다항식을 더하는 함수
	public Poly addPoly(Poly poly1, Poly poly2){
		int dif = poly1.degree - poly2.degree;
		double[] newCoef;
		Poly newPoly;
		
		if(dif > 0){
			newCoef = fillZero(dif, poly2);
			addCoef(poly1, newCoef);
			newPoly = new Poly(degree, coef);
		}		
		else{
			newCoef = fillZero((-1 * dif), poly1);
			addCoef(poly2, newCoef);
			newPoly = new Poly(degree, coef);

		}
		return newPoly;
	}
	
	//차이만큼 0을 채우는 함수
	public double[] fillZero(int dif, Poly poly){
		degree = poly.coef.length + dif;
		double[] newCoef = new double[degree+1];
		this.coef = new double[degree+1];
		System.out.println("dif = " + dif);
		//2
		System.out.println("newDegree = " + degree);
		//6
		
		for(int i = 0; i < dif; i++){
			newCoef[i] = 0;
		}
		for(int i = dif; i < degree; i++){
			newCoef[i] = poly.coef[i - dif];
		}
		return newCoef;
	}
	
	public void addCoef(Poly poly, double[] newCoef){
		for(int i = 0; i < poly.degree ; i++){
			coef[i] = poly.coef[i] + newCoef[i];
		}	
		return;
	}
}
