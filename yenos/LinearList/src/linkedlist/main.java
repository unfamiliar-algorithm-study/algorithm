/**
 * 
 */
package linkedlist;

/**
 * @author yenos
 * @date 2016. 9. 4.
 */
public class main {

	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		
		//리스트 마지막에 추가한다.
		l.addLast("10");		
		l.addLast("11");
		l.addLast("12");	
		//리스트에첫번째의 추가한다.
		l.addFirst("9");
		
		//잘보이는지 검색한다.
		l.showAllNode();
		
		
		//인덱스0번째의 값을 가져온다. 
		int index = 0;
		System.out.println("index "+index+" => "+l.searchWithIndex(1)+"데이터를 가집니다.");

		// 데이터 9를 몇번 인덱스에 있는지 검색한
		int data = 9;
		System.out.println("data "+data+" => "+l.searchWithData("10")+"번쨰에 있어요.");
		
		// test. 1에 999를 넣는다.
		l.middleAdd(0,"999");

		//일부러out of Range를 넣어본다.
//		l.middleAdd(-1,"999");
		//잘 들어갔는지 검색한다. 
		l.delIndex(0);
		l.showAllNode();
	}
}
