

/**
 * @author yenos
 * @date 2016. 9. 3.
 * 
 *
 */
public class Poly {
	private int degree;
	private double[] coef;

	public Poly(int degree, double[] coef) {
		this.degree = degree;
		this.coef = coef;
	}

	public Poly(){		
	}
	
	
	// 두개의 다항식을 더하는 함수
	public Poly addPoly(Poly a, Poly b){
		
		//어떤것이 더 차수가 높을까?
		int diff = a.degree-b.degree;
		
		//a가 더 차수가 높은거임.
		return diff>0  ? addTerms(a, b) : addTerms(b, a);
		
	}

	//실제 더해주는 함수.
	public Poly addTerms(Poly a, Poly b) {
		double[] arrResult = new double[a.degree + 1];
		arrResult = setSizeToFit(a, b);

		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = a.coef[i] + arrResult[i];
		}
		
		Poly newPoly = new Poly(arrResult.length-1, arrResult);
		return newPoly;
	}
//가장큰 어레잉에 사이즈 맞춰주는 함수.
	public double[] setSizeToFit(Poly a, Poly b) {
		int diff = abs(a.degree, b.degree);

		double[] arrAdded = new double[a.degree + 1];
		for (int i = 0; i < diff; i++) {
			arrAdded[i] = 0;
		}
		for (int i = diff; i < a.degree + 1; i++) {
			arrAdded[i] = b.coef[i - diff];
		}
		return arrAdded;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public double[] getCoef() {
		return coef;
	}

	public void setCoef(double[] coef) {
		this.coef = coef;
	}

	public int abs(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}

}
