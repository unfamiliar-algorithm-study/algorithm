import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author yenos
 * @date 2016. 9. 3.
 */
public class main {

	public static void main(String[] args) {

		// 8x5, 1x4, -3x3, 2x2,5x1,1.8
		double[] arr01 = { 8, 1, -3, 2.5, 1.8 };
		
		// arr01은 맥스 3승짜리이고,
		// 9x3, 3x2, 5x1, 0
		double[] arr02 = { 9, 3, 5, 0 };

		Poly poly1 = new Poly(arr01.length - 1, arr01);
		Poly poly2 = new Poly(arr02.length - 1, arr02);		
		Poly poly3 = new Poly().addPoly(poly1, poly2);
		
		System.out.println(poly3.getDegree());
		
		for(int i=0 ;i<poly3.getCoef().length;i++){
			System.out.println(poly3.getCoef()[i]);
		}
		
		
		
		
//		SpareMatrix matEx01 = new SpareMatrix(3,3);					
//		SpareMatrix spareTrans = matEx01.transPoseSM(matEx01.getMatrix());		
//		spareTrans.prettyMatrix();
//		
//		
//		SpareMatrix matEx02 = new SpareMatrix(3,3);
//		SpareMatrix matEx03 = new SpareMatrix(3,3);
//		
//		SpareMatrix addMatrix = new SpareMatrix().addSM(matEx02.getMatrix(),matEx03.getMatrix());		
//		addMatrix.prettyMatrix();		
		//

		
		
		//		spareMatrix.prettyMatrix();
		
//		double[][] matrix  = new double[10][10];
//		
//		for(int i=0;i<matrix.length;i++){
//			for(int j=0;j<matrix[i].length;j++){
////				System.out.println(matrix[i][j]);
//			}
//		}
		
//		for(double[] element : matrix){
////			System.out.println(element[]);
//		}
		
//		int[10][10] matrix;
		
		
		
	}

}
