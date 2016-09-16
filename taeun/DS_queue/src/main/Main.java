/*
 * 2016.9.5
 * 1차원배열 큐, 배열 원형큐, linked list 큐, doubly linked list 를 이용한 Deque 
 * 
 * */
package main;

import exception.MemoryException;
import queue.CircularQueue;
import queue.Deque;
import queue.LinkedQueue;
import queue.SequentialQueue;

public class Main {

	public static void main(String[] args) throws MemoryException{
		
		
		//배열을 이용한 순차큐*****************************************************
		System.out.println("----Sequential Queue----");
		
		int queueSize = 10; 
		String[] queueArray = new String[queueSize];
		
		SequentialQueue queue = new SequentialQueue(queueSize, queueArray);
		
		long start = System.currentTimeMillis(); //시간측정
		for(int i=0; i<queueSize; i++){ //사이즈만큼 정수값 인큐 
			queue.enQueue(i+" ");
		}
		while(queue.isEmpty()){
			queue.deQueue(); //사이즈만큼 디큐
		}
		long end = System.currentTimeMillis();
		
		System.out.println("input size: "+queueSize +" / time:"+ (end-start)/1000.0);
		
		
		
		//배열을 이용한 원형큐 *******************************************************************
		System.out.println("----circular queue----");
		
		queueSize = 10;
		String[] circularQueueArray = new String[queueSize];
		
		CircularQueue circularQueue = new CircularQueue(queueSize, circularQueueArray);
		
		System.out.println(circularQueue);
		
		for(int i=0; i<queueSize-1 ; i++){
			circularQueue.enQueue(i+" "); //사이즈만큼 인큐
		}
		
		System.out.println(circularQueue);
		
		while(!circularQueue.isEmpty()){
			System.out.println(circularQueue.deQueue()); //사이즈만큼 디큐
		}
		System.out.println(circularQueue);
		
		
		//링크드 리스트를 이용한 큐*************************************************************
		System.out.println("----linked queue----");
		
		LinkedQueue linkedQueue = new LinkedQueue();
		
		int inputSize = 10;
		for(int i=0; i<inputSize; i++){
			linkedQueue.enQueue(i+" "); //인큐
		}
		
		System.out.println(linkedQueue);
		
		for(int i=0; i<inputSize; i++){
			System.out.println(linkedQueue.deQueue()); //디큐
		}
		
		System.out.println(linkedQueue); //출력
		
		
		
		//덱*************************************************************
		System.out.println("----deque----");
		
		Deque deque = new Deque();
		
		System.out.println(deque);
		
		deque.addFront(1+" ");
		System.out.println(deque);
		
		deque.addFront(2+" ");
		System.out.println(deque);
		
		deque.addFront(3+" ");
		System.out.println(deque);
		
		deque.addFront(4+" ");
		System.out.println(deque);
		
		deque.addLast(5+" ");
		System.out.println(deque);
		
		
		deque.deleteLast();
		System.out.println(deque);
		
		deque.deleteFront();
		System.out.println(deque);
	}
	
}
