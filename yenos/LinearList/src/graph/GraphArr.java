/**
 * 
 */
package graph;



/**
 * @author yenos
 * @date 2016. 9. 10.
 *배열을 이용한 그래프 표기 및탐색법 
 */
public class GraphArr {
	int[][] arr;
	int ARR_SIZE;
	boolean[] visit  ;
	int[] queue;
	int flgLastIndex = 0;
	int flgFirstIndex = 0;
	
	public GraphArr(int ARR_SIZE){
		this.arr = new int[ARR_SIZE][ARR_SIZE];
		this.ARR_SIZE = ARR_SIZE;
		this.visit = new boolean[ARR_SIZE];
		this.queue  = new int[ARR_SIZE];
	}
	
	
	// 0 , 1
	//인접행렬만들
	public void indsertArrData(int a, int b){
		if(a<0 || b<0 || a>ARR_SIZE-1 || b>ARR_SIZE-1){
			throwing(" 범위를 초과했습니다. ");
		}else{

			arr[a][b] = 1;
			arr[b][a] = 1;	
		}
	}
	
	public void prettyShowAll(){
		for(int i=0;i<ARR_SIZE;i++){
			for(int j=0;j<ARR_SIZE;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
	}
	 
	
	public void DFS(int v)
	{
		 //정점 v를 탐색했으므로 트루 
	    visit[v] = true;
	    for (int i = 0; i <ARR_SIZE; i++) 
	    {
	        //정점이연결되어있고 방문하 않았던 곳일경우. 
	        if (arr[v][i] == 1 && !visit[i])
	        {
	            System.out.println( v+"==>"+ i);
	            // 정점 i에서 다시 DFS를 시작한다
	            DFS(i);
	        }
	    }
	}
	
	
	
	public void BFS(int v){
		//해당 v정점을 방문. 
		visit[v] = true;
		//v 를 큐에 넣어준다.
		enqueue(v);
		
		//둘이 만나게되면 그것은 끝났을 경우이다.
		while(flgFirstIndex<flgLastIndex){
			v = dequeue();
			for(int i =0;i<ARR_SIZE;i++){
				if(arr[v][i]==1 && !visit[i]){
					visit[i] = true;
//					System.out.println(visit[i]);
					System.out.println(v+"==>"+i);
					enqueue(i);
				}
			}
		}
		
		
	}
	
	public void enqueue(int data){
		if(flgLastIndex<ARR_SIZE){
			queue[flgLastIndex] = data;
			flgLastIndex++;	
		}else{
			throwing(" 범위 초과하셨습니다 ");
		}
	}
	public int dequeue(){
		if(flgFirstIndex<ARR_SIZE){
			return queue[flgFirstIndex++]; 
		}else{
			throwing(" 범위 초과하셨습니다 ");
			return 0;			
		}		
	}
	
	
	
	class PkCustomException extends Exception {
		public PkCustomException(String message) {
			super(message);
		}
	}

	public void throwing(String msg) {
		try {
			throw new PkCustomException(msg);
		} catch (PkCustomException e) {
			e.printStackTrace();
		}
	}
}
