package heap;

public class Main {
	public static void main(String[] args) {
		Heap H = new Heap();
		H.insertHeap(H.heap,4);
		H.insertHeap(H.heap,7);
		H.insertHeap(H.heap,8);
		H.insertHeap(H.heap,9);
		H.insertHeap(H.heap,3);
		H.insertHeap(H.heap,5);
		H.insertHeap(H.heap,15);
		H.insertHeap(H.heap,2);   

		H.insertHeap(H.heap,19);
		H.insertHeap(H.heap,13);
		H.insertHeap(H.heap,18);
		H.insertHeap(H.heap,12);
		H.insertHeap(H.heap,8);
		H.insertHeap(H.heap,5);

		H.insertBinaryTree(H.tree, 10);
		H.makeTreeHeap(H.tree, 10);
		//H.delete(H.tree);
		//H.delete(H.tree);
		H.print_Heap(H.tree);
		//H.delete(H.heap);
		//H.delete(H.heap);
		H.print_Heap(H.heap);	
	}
}
