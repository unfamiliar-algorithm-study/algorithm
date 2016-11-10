package heap;

class Heap {
	static int heap[];
	static int tree[];
	static int heapsize;
	static int n;
	
	Heap(){
		n=0;
		heapsize = 100;
		heap = new int[heapsize];
		tree = new int[heapsize];
	}
	void insertHeap(int heap[], int k){
		int i;
		n++;
		
		for(i=n;;){
			if(i==1)break;
			if(k<=heap[i/2]) break;
			heap[i] = heap[i/2];
			i = i/2;
		}
		heap[i]=k;
}
	int delete(int heap[]){
		int temp = heap[n];
		int del = heap[1];
		int i=1;
		int j=2;
		heap[n]=0;
		n--;
		
		while(j <=n){
			if(j < n){
				if(heap[j] < heap[j+1]) j++;
			}
			if(temp > heap[j]) break;
			heap[i] = heap[j];
			i = j;
			j = j * 2;
		}
		heap[i] = temp;
		return del;
	}
	
	void print_Heap(int heap[]){
		for(int i=1; i<=n; i *=2){
			for(int j=1; j<=i*2-1;j++){
				System.out.print(heap[j]+"\t");
			}
			System.out.println();
		}
		
	}
	void insertBinaryTree(int tree[],int cnt)
	{
		//원소의 갯수가 n개인 이진트리 생성
		//원소의 값은 random하게 삽입한다.
		for(int i = 1; i < cnt; i++) 
		{ 
			tree[i]=(int)(Math.random()*100); 
		}
		
		System.out.println("insertBinaryTree");
		for(int l = 1; l<=cnt ; l*=2){
			for(int k=l ; k<=l*2-1;k++){
				System.out.print(tree[k]+"\t");
			}
			System.out.println();
		}
	}


	void makeTreeHeap(int tree[], int n)
	{
		int i, p, j, temp = 0;
		
		for(i = n/2; i>=1; i--){
			p = i;
			for(j=2*p;j<=n;j=2*j){
				if(j>n){
					if(tree[j]<tree[j+1]) j=j+1;
				}
				if(tree[p]>=tree[j])break;
				temp = tree[p];
				tree[p] = tree[j];
				tree[j] = temp;
				p=j;
			}
		}
		System.out.println("makeTreeHeap");
		for(int l = 1; l<=n ; l*=2){
			for(int k=l ; k<=l*2-1;k++){
				System.out.print(tree[k]+"\t");
			}
			System.out.println();
		}
	}
}