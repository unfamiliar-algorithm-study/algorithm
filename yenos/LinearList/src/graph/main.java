/**
 * 
 */
package graph;

/**
 * @author yenos
 * @date 2016. 9. 10.
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		graphList g2 = new graphList(4);
//		g2.insertData(0, 1);	
//		g2.insertData(0, 2);
//		
//		System.out.println("그래프 G2의 인접리스트 : ");
//		g2.printAdjList();
		
	GraphArr graphArr = new GraphArr(5);
	graphArr.indsertArrData(0, 1);
	graphArr.indsertArrData(0, 2);
	graphArr.indsertArrData(1, 3);
	graphArr.indsertArrData(1, 4);
	graphArr.prettyShowAll();
	graphArr.DFS(0);
//	graphArr.BFS(0);
	

	
	
	}

}
