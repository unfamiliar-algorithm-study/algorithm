/**
 * 
 */
package tree;

/**
 * @author yenos
 * @date 2016. 9. 14.
 */
public class main {

	/**
	 * @date
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		binarySearch bs = new binarySearch();
		
		bs.insertNode(50);
		bs.insertNode(30);
		bs.insertNode(70);
		bs.insertNode(20);
		bs.insertNode(25);

		bs.preOrder(bs.startNode);
		bs.remove(20);
		System.out.println();
		bs.preOrder(bs.startNode);
		
	}

}
