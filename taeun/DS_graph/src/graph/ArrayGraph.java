package graph;

import java.util.Arrays;

import exception.MemoryException;
import queue.LinkedQueue;

/**
  * @FileName : ArrayGraph.java
  * @Date : 2016. 9. 15. 
  * @author : ChoiTaeEun
  * @description : 배열을 이용한 무방향 그래프구현, +DFS,BFS
  */
public class ArrayGraph {
	
	private int vertexSize;
	private int[][] graph;
	private boolean[] visited;
	
	
	public ArrayGraph(int vertexSize){
		this.vertexSize = vertexSize;
		this.graph = new int[vertexSize][vertexSize];
		this.visited = new boolean[vertexSize];
		
		for(int i=0; i < vertexSize; i++){
			for(int j=0; j < vertexSize ; j++){
				graph[i][i] = 0;
			}
			visited[i] = false;
		}
	}
	
	public boolean isInRange(int vertex){ //정점이 범위이내에 있는지 검사하는 함수 
		if(vertex >= 0 && vertex < vertexSize){
			return true;
		}else{
			return false;
		}
	}
	
	public void insertEdge(int vertex1, int vertex2) throws Exception{ //간선삽입 메소드 
		if(isInRange(vertex1) && isInRange(vertex2)){ //범위안에있으면 삽입 
			graph[vertex1][vertex2] = 1;
			graph[vertex2][vertex1] = 1;
		}else{
			throw new Exception("out of range");
		}
	}
	
	public void DFS(){ //너비우선탐색 
		makeInvitedFalse();
		for(int i=0; i<vertexSize; i++){ //한열을 모두 돈다.
			DFS(i);
		}
		System.out.println("\n");
	}
	
	private void DFS(int vertex){
		
		if(!visited[vertex]){ //방문하지 않았을때만 실행한다.
			
			visited[vertex] = true; //방문하고 
			System.out.print(vertex+" "); //출력한다
			
			for(int i=0; i<vertexSize; i++){ //인접한 정점을 다시 방문한다
				if(graph[vertex][i] == 1){
					DFS(i);
				}
			}
		}
	}
	
	public void BFS() throws MemoryException{
		makeInvitedFalse();
		
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		
		for(int i=0; i<vertexSize; i++){
			BFS(i,queue); //한 열을 깊이우선탐색한다.
		}
		System.out.println("\n");
	}
	
	public void BFS(int vertex, LinkedQueue queue) throws MemoryException{

		if(!visited[vertex]){ //방문하지않앗을때 실행한다
			
			visited[vertex] = true; //트루로 만들고(방문)
			System.out.print(vertex+" "); //출력하고
			
			
			for(int i=0; i<vertexSize; i++){ //해당 정점의 인접한 정점을 큐에 다 넣는다
				if(graph[vertex][i]==1){
					queue.enQueue(i);
				}
			}
			
			while(!queue.isEmpty()){ //큐가모두 비워질동안 정점을 방문한다
				BFS((Integer)queue.deQueue(), queue); 
			}
		}
	}
	
	public void makeInvitedFalse(){ //visited배열을 false로 만드는 함수 
		for(int i=0; i<vertexSize; i++){
			this.visited[i] = false;
		}
	}
	
	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<vertexSize; i++){
			for(int j=0; j<vertexSize; j++){
				sb.append(graph[i][j]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
