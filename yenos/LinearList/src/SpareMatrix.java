/**
 * 
 */

/**
 * @author yenos
 * @date 2016. 9. 3.
 */
public class SpareMatrix {

	
	private int[][] matrix;
	
	public SpareMatrix(){
		
	}
	public SpareMatrix(int m,int n){
		createSM(m, n);
	}
	
	public void createSM(int m, int n){
		
		matrix = new int[m][n];
		//임시로크레이트할때 이렇게 만든다.
		int incrData=0;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				
				matrix[i][j] = incrData++;
			}
		}
	}

	public SpareMatrix transPoseSM(int[][] spareMat){
		SpareMatrix spareMatrix = new SpareMatrix();		
		spareMatrix.createSM(spareMat.length, spareMat[0].length);
		
		for(int i=0;i<spareMat.length;i++){
			for(int j=0;j<spareMat[i].length;j++){
				//0 이아닐경우에만 바꾼다.
				//가운데는 안바꾸어도도 된다.
				if(spareMat[i][j]!=0 && i!=j){
					spareMatrix.matrix[i][j] = spareMat[j][i];
				}
			}
		}
		return spareMatrix;
	}
	
	public SpareMatrix addSM(int[][] a,int[][] b ){
		SpareMatrix spareMatrix = new SpareMatrix();		
		spareMatrix.createSM(a.length, a[0].length);
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				 spareMatrix.matrix[i][j] = a[i][j]+b[i][j];				
			}
		}
		
		return spareMatrix;
	}
	
//	
//	public int getColum() {
//		return colum;
//	}
//
//	public void setColum(int colum) {
//		this.colum = colum;
//	}
//
//	public int getRow() {
//		return row;
//	}
//
//	public void setRow(int row) {
//		this.row = row;
//	}
//
//	public int getValue() {
//		return value;
//	}
//
//	public void setValue(int value) {
//		this.value = value;
//	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void prettyMatrix(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(" ");
				System.out.print(matrix[i][j]);
			}
			System.out.println("\n");
		}
	}
//	public SpareMatrix(matrix) {
//	}
	
}
