package graph;

public class Main {
	public static void main(String[] args){
		ListGraph g2 = new ListGraph(4);
		g2.insertEdge(0,3); g2.insertEdge(0,1); 
		g2.insertEdge(1,3); g2.insertEdge(1,2); g2.insertEdge(1,0); 
		g2.insertEdge(2,3); g2.insertEdge(2,1); 
		g2.insertEdge(3,2); g2.insertEdge(3,1); g2.insertEdge(3,0);
		System.out.println("그래프 G2의 인접리스트 : ");
		g2.printAdjList();
		g2.DFS();
		g2.BFS(0);
	}

}
