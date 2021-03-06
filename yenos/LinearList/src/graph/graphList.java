/**
 * 
 */
package graph;


/**
 * @author yenos
 * @date 2016. 9. 10. 그래프 알고리즘 .
 */
public class graphList {
	private Node[] arrNode;
	private int graphSize;

	private class Node {
		int data;
		Node next;
	}

	public graphList(int graphSize) {
		arrNode = new Node[graphSize];
		this.graphSize = graphSize;
	}
	
	


	// 정점 v1 에서 v2를 잇는 간선을 생성한다.(v2 가 새로 생성할 노드이다.)
	public void insertData(int v1, int v2) {

		// 정점 사이즈를 초과할 경우.
		if (v1 < 0 || v2 < 0 || v1 >= graphSize || v2 >= graphSize) {
//			throwing("사이즈를 초과합니다.");
		} else {
			Node node = new Node();
			node.data = v2;
			// 2가지 작업을 해주어야한다.
			// 새로운 노드에 다음이 v1 이되어야하고
			// v2 의 다음은 v1의 현재 최상단의 노드를 가리키고
			// ex) 1,0
			// 0.next => arrNOde[v1];
			// arrNode[v1= 0
			// 0.enxt => 이전에 있던 arrNode[v1]이
			node.next = arrNode[v1];
			// v은v2가되면된다.
			arrNode[v1] = node;
			
			
			Node node2 = new Node();
			node2.data = v1;
			node2.next = arrNode[v2];
			arrNode[v2] =node2; 
			
			// 0 , 1
			// 1을 가지는 새노드는
			// 다음이 arrNode[0]이 되고  1 ==> 0 을 가지게됨.
			// 0번째 = 1==>0 이 되게된다. 

		}

	}

	public void printAdjList() {
		for (int i = 0; i < graphSize; i++) {
			System.out.print("정점 " + i + "의 인접리스트");
		
			//arrNode 의 i번째 부터 순차적으로 탐색을 한다. 내부 temp의 next가 없을때까지.
			//우리가 데이터를 집어넣을때 앞쪽으로 스택구현과같이 넣음으로
			// ex) 0 일경우 
			for (Node temp = arrNode[i]; temp != null; temp = temp.next)
				System.out.print(" => " + temp.data);
			System.out.println();
		}
	}

	
	
}
