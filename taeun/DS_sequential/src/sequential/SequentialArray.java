package sequential;

import exception.MemoryException;
import exception.UnexpectedIndexException;

public class SequentialArray {

	private int size;
	private int tail;
	private Integer[] array;
	
	
	public SequentialArray(int size){
		this.size = size;
		this.tail = -1;
		this.array = new Integer[this.size];
	}
	
	public boolean isFull(){
		if(tail == size-1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isEmpty(){
		if(tail == -1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isMiddleIndex(int index){
		if(index >= 0 && index <= tail){ 
			return true;
		}else{
			return false;
		}
	}
	
	public void add(int value) throws MemoryException{
		if(isFull()){
			throw new MemoryException("over flow");
		}
		array[++tail] = new Integer(value);
	}
	
	public void addMiddle(int value, int index) throws MemoryException, UnexpectedIndexException{
		if(isFull()){
			throw new MemoryException("over flow");
		}
		
		if(!isMiddleIndex(index)){
			throw new UnexpectedIndexException("not a middle index");
		}
		
		int turnCount = tail - index + 1;
		for(int i=0; i < turnCount; i++){
			array[tail-i+1] = array[tail-i];
		}
		tail++;
		array[index] = new Integer(value);
	}

	public void delete(int index) throws UnexpectedIndexException{
		if(isFull()){
			tail--;
			return;
		}
		
		if(!isMiddleIndex(index)){
			throw new UnexpectedIndexException("not a middle index");
		}
		
		int turnCount = tail - index;
		for(int i=0; i < turnCount; i++){
			array[index+i] = array[index+i+1];
		}
		tail--;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < size; i++){
			if(i <= tail){
				sb.append(array[i]+" ");
			}else{
				sb.append("* ");
			}
		}
		return sb.toString();
	}
	
}
