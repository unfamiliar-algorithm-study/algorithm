/**
 * 
 */
package queue;

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
		
		Deck deck = new Deck();
		
		deck.createDQ();
		deck.insertFront("10");
		deck.insertFront("20");
		deck.insertRear("30");
		System.out.println(deck.deleteFront());
		deck.printPretty();
	System.out.println(deck.deleteRear());
//	deck.printPretty();
		

	}

}