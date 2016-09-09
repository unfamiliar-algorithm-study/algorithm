/*
 * 2016.9.5
 * 일차원 배열을이용한 원형 큐
 * */
package queue;

import exception.MemoryException;

public class CircularQueue {
	
	private int front; //원형큐에서 프론트는 맨처음데이터를 가르키는게 아니라 맨처음의 이전인덱스를 가르킨다.(그래서 1차원 원형큐는 한칸이 비어있음. 메모리낭비(?)) 
	private int rear;
	private int queueSize;
	private String[] circularQueueArray; 
	
	public CircularQueue(int queueSize, String[] circularQueueArray){
		this.front = 0;
		this.rear = 0;
		this.queueSize = queueSize;
		this.circularQueueArray = circularQueueArray;
	}
	
	public boolean isEmpty(){ 
		if(front == rear){ //프론트와 꼬리가 같을때는 비어있는것으로 간주 
			return true;
		}else{
			return false;
		}
	}

	public boolean isFull(){
		if(front == ((rear + 1) % queueSize)){ //꼬리뒤에 프론트가 있으면 꽉찬것으로 간주한다.   
			return true;					   //큐사이즈만큼 모드연산을 한것은 원형큐이기 때문에 맨뒤 다음인덱스는 맨처음으로 돌아오게 하기위함.
		}else{
			return false;
		}
	}
	
	public void enQueue(String data) throws MemoryException{
		if(isFull()){ //꽉찼으면 오버플로 익셉션발생
			throw new MemoryException("over flow");
		}
		rear = ((rear + 1) % queueSize); //꼬리를 가르키고있는 인덱스를 증가시켜주고~(모드연산은 원형큐라서한것) 
		circularQueueArray[rear] = data; //거기에 데이터를 넣는다.
	}
	
	public String deQueue() throws MemoryException{
		if(isEmpty()){ //비었으면 언더플로 익셉션발생 
			throw new MemoryException("under flow");
		}
		front = ((front + 1) % queueSize); //맨 처음을 가르키고있는 인덱스를 한칸 우이동 시킨후 
		return circularQueueArray[front]; //해당 인덱스의 데이터를 디큐해서 리턴해준다.
	}
	
	@Override
	public String toString(){ //투스트륑메소드.
		if(isEmpty()){ //비었을땐 - 출력 
			return "-";
		}
		
		StringBuilder sb = new StringBuilder(); //스트링빌더는 문자열이 자주 수정될때 사용하면 좋은 클래스. 
		
		int i=1;
		int pointer= (front + 1) % queueSize; //프론트의 다음을가르키는 포인터 

		while(true){ //계속돈다.
			pointer = (front + i) % queueSize;
			sb.append(circularQueueArray[pointer] + " "); //해당 포인터의 데이터를 스트링빌더에 어펜드 함.
			i++;
			if(pointer == rear){ //포인터가꼬리를 가르킬때까지 돈다.
				break;
			}
		}
		return sb.toString(); //스트링빌더를 스트링으로 변환해서 리턴.
	}
}
