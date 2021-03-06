package graph;

public class ListGraph {
	
	private boolean[] visited;
	private Node[] list;
	private int num; // vertex 개수
	
	private class Node {
		int vertex;
		Node link;
	}
	public ListGraph(int n) {
		list = new Node[n];
		this.num = n;
		visited = new boolean[n];
	}
	
	public void insertEdge(int v1, int v2) {
		if(v1<0 || v1>=num || v2<0 || v2>=num)
			System.out.println("그래프에 없는 정점입니다!");
		else {
			// vertex가 v2인 새로운 노드를 v1의 연결리스트 맨 앞에 삽입
			Node newNode = new Node();
			newNode.vertex = v2;
			newNode.link = list[v1];
			list[v1] = newNode;
		}
	}
	
	public void printAdjList() {
		for(int i=0; i<num; i++) {
			System.out.print("정점 " + i + "의 인접리스트");
	
			for(Node temp = list[i]; temp != null; temp = temp.link)
				System.out.print(" -> "+ temp.vertex);
			System.out.println();
			}
	}
		
	
	public void DFS() {
		//처음에 방문값 전부 false로 초기화
		for(int i = 0; i < num; i++)
			visited[i] = false;
		
		for(int i = 0; i < num; i++){
			if(visited[i] == false && list[i] != null){
				DFS(i);
			}
	}
		System.out.println("DFS end");
	}
			 
	public void DFS(int i) {
		System.out.print(i + " ");
		visited[i] = true;	
		for(Node temp = list[i]; temp != null; temp = temp.link){
			if(visited[temp.vertex] == false){
				DFS(temp.vertex);
			}
		}
	}
	
	public void BFS(int i){
		for(int v = 0; v < num; v++)
			visited[v] = false;
		
		visited[i] = true;
		
		LinkedQueue Q = new LinkedQueue();
		
		Q.enQueue(i);
		
		while (!Q.isEmpty()) {
			int r = Q.deQueue();	
			System.out.print(r + " ");
			//아 이부분 어떻게 해야할까
			for(Node temp = list[i]; temp != null; temp = temp.link){
				if (!visited[temp.vertex]) {
					visited[temp.vertex] = true;
					Q.enQueue(temp.vertex);
				}
			}
		}
	}
}