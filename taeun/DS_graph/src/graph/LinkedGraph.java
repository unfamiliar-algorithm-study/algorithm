package graph;

/**
  * @FileName : LinkedGraph.java
  * @Date : 2016. 9. 15. 
  * @author : ChoiTaeEun
  * @description : 링크드 리스트를 이용한 무방향 그래프구현
  */
public class LinkedGraph {

	private int vertexSize;
	private Node[] graphList;
	
	public LinkedGraph(int vertexSize){
		this.vertexSize = vertexSize;
		this.graphList = new Node[vertexSize];
	}
	
	public boolean isInRange(int vertex){ //입력 vertex가 범위안에 있는지 검사 
		if(vertex >= 0 && vertex < vertexSize){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isContains(int vertex1, int vertex2){ //이미 있는 간선인지 확인 
		
		Node pointer = graphList[vertex1];  
		while(pointer != null){
			if(pointer.vertex == vertex2){
				return true;
			}
			pointer = pointer.link;
		}
		
		pointer = graphList[vertex2];  
		while(pointer != null){
			if(pointer.vertex == vertex1){
				return true;
			}
			pointer = pointer.link;
		}
		return false;
	}
	
	
	public void insertEdge(int vertex1, int vertex2) throws Exception{
		
		if(isInRange(vertex1) && isInRange(vertex2)){ //범위안에있으면 
			
			if(isContains(vertex1, vertex2)){ //이미 존재하는 간선일때 
				throw new Exception("vertex existed already");
			}
			
			Node newNode = new Node(vertex2); //vertex1 에 vertex2 삽입
			newNode.link = graphList[vertex1];
			graphList[vertex1] = newNode;
			
			newNode = new Node(vertex1); //vertex2에 vertex1삽입
			newNode.link = graphList[vertex2];
			graphList[vertex2] = newNode;
		}else{
			throw new Exception("out of range");
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<vertexSize; i++){
			sb.append(i+": ");
			
			Node pointer = graphList[i];
			while(pointer != null){
				sb.append(pointer.vertex);
				pointer = pointer.link;
				if(pointer != null){
					sb.append(" -> ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private class Node{
		int vertex;
		Node link;
		
		Node(int vertex){
			this.vertex = vertex;
			this.link = null;
		}
	}
}
