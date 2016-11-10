package gettissu;

public class Tissu {
	private int x;
	private int y;
	
	public Tissu(){
		this.x = 0;
		this.y = 0;
	}
	
	public Tissu(int x , int y){
		this.x = x;
		this.y = y;
		
	}
	
	public int GetX(){
		return x;
	}
	
	public int GetY(){
		return y;
	}
	
	public void printPos(){
		System.out.print("(" + x + "," + y + ")");
	}
}
