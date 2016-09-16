/**
  * @FileName : Main.java
  * @Date : 2016. 9. 15. 
  * @author : ChoiTaeEun
  * @description :
  */
package main;

import graph.ArrayGraph;
import graph.LinkedGraph;
import queue.LinkedQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		
		ArrayGraph ag = new ArrayGraph(7);
		
		ag.insertEdge(0, 1);
		ag.insertEdge(0, 2);
		ag.insertEdge(1, 3);
		ag.insertEdge(1, 4);
		ag.insertEdge(2, 4);
		ag.insertEdge(3, 6);
		ag.insertEdge(4, 6);
		ag.insertEdge(5, 6);
		
		System.out.println(ag);
		
		
		ag.BFS();
		
		
		
		
		
		
		LinkedGraph lg = new LinkedGraph(4);
		
		lg.insertEdge(0, 1);
		lg.insertEdge(0, 3);
		lg.insertEdge(2, 3);
		
		System.out.println(lg);
	}
	
}
