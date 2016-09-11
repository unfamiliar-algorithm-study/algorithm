package matrix;

public class Matrix {

	private int row;
	private int column;
	private int[][] matrix;
	
	public Matrix(int row, int column, int[][] matrix){
		this.row = row;
		this.column = column;
		this.matrix = matrix;
	}
	
	public Matrix(int row, int column){
		this.row = row;
		this.column = column;
		this.matrix = new int[row][column];
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}
	
	public Matrix add(Matrix addMatrix){ //덧셈
		
		Matrix resultMatrix = new Matrix(column, row);
		for(int i=0; i<row; i++ ){
			for(int j=0; j<column; i++){
				resultMatrix.matrix[i][j] = this.matrix[i][j] + addMatrix.matrix[i][j];
			}
		}
		
		return resultMatrix;
	}
	
	public Matrix transpose(){ //전치행렬 구하기 
		
		Matrix resultMatrix = new Matrix(this.column, this.row);
		
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				resultMatrix.matrix[j][i] = this.matrix[i][j];
			}
		}
		return resultMatrix;
	}
	
	public Matrix multiple(Matrix multipleMatrix){ //두 행렬 곱하기 
		
		Matrix resultMatrix = new Matrix(this.row, multipleMatrix.getColumn());
		/*
		int result = 0;
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				this.matrix[i][j] * multipleMatrix[][]
			}
		}
		*/
		return null;
	}
	
	
}
