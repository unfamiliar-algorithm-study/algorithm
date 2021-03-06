/**
 * 
 */
package linkedlist;

import javax.xml.stream.events.NotationDeclaration;

import org.w3c.dom.ranges.RangeException;

/**
 * @author yenos
 * @date 2016. 9. 4.
 */
public class LinkedList {

	class Node {
		String data;
		Node next;
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

	private Node head = null;
	private Node lastNode = new Node();
	private int lastIndex;

	public LinkedList() {
		
	}
	// public boolean isEmpty(){
	// return lastNode.data == null ? true : false ;
	// }

	// Exception Rule
	// 1. 중간외의 맨앞 처리
	// 2. 음수의 값을 넣을경우.
	// 3. lastIndex보다 큰값을 넣을 경우.

	public void middleAdd(int index, String data) {

		// 만약 index 가 0 일경우는 첫번째에 값을 넣어준다.
		if (index - 1 == -1) {
			addFirst(data);
		} else {
			// 0보다 작은값.혹은 index 보다 큰값.
			if (index - 1 < 0 || index > getLastIndex()) {
				throwing("index out of Range!!!");
			} else {
				Node tmp = new Node();
				tmp.data = data;

				// 1번째의 넌다면?
				// 0 1 2 3 4 +tmp
				// 템프의 넥스트가 전꺼의넥스트를 가지고
				tmp.next = searchWithIndexNode(index - 1).next;
				// 전꺼의 네스트가 탬프가된다
				searchWithIndexNode(index - 1).next = tmp;
			}
		}
	}

	// 처음에 저장하는 경우.
	public void addFirst(String data) {
		Node tmp = new Node();
		tmp.data = data;

		// 헤드가
		if (head != null) {

			// 원래 헤드가 가리치고있는애를 임시변수가 가리치고 있어야 한다.
			tmp.next = head.next;
			// 그리고 해드의 다음은 tmp가 되어야한다.
			head.next = tmp;

			// 헤드가 널이면 처음이 없다는 이야기다. 해드를 추가해준다.
		} else {

			// 해드가 널이면 새로 초기화해서 tmp를 만들어준다.
			head = new Node();
			// 해드의 노등가 이노드를 가지고있는다.
			head.next = tmp;
			// 라스트는 tmp자체가 되고
			lastNode = tmp;//

		}
	}

	// 마지막에 넣을
	public void addLast(String data) {
		Node tmp = new Node();
		tmp.data = data;

		if (head == null) {
			head = new Node();
			// 해드의 노등가 이노드를 가지고있는다.
			head.next = tmp;
			// 라스트는 tmp자체가 되고
			lastNode = tmp;

		} else {
			// 현재의 라스트는?
			// 혀재라스트의 다음을 tmp로 넣어주
			lastNode.next = tmp;

			// 라스트는 다시 tmp로 설정한다.
			lastNode = tmp;
		}
	}

	public void delIndex(int index) {
		if (index - 1 == -1) {
			// 
			//해드가 가리키는것은 삭제될것앞에것이된다.
			head.next = searchWithIndexNode(index+1);

		} else {
			// 0보다 작은값.혹은 index 보다 큰값.
			if (index - 1 < 0 || index > getLastIndex()) {
				throwing("index out of Range!!!");
			} else {
				Node tmp = new Node();

				//해당삭제노드의 다음 전것의 노드를 설
				tmp = searchWithIndexNode(index-1);
				//전것의 노드가 가리키는것을 다음 노드로 설정한다.
				tmp.next = searchWithIndexNode(index+1);
				
//
//				// 1번째의 넌다면?
//				// 0 1 2 3 4 +tmp
//				// 템프의 넥스트가 전꺼의넥스트를 가지고
//				tmp.next = searchWithIndexNode(index - 1).next;
//				// 전꺼의 네스트가 탬프가된다
//				searchWithIndexNode(index - 1).next = tmp;
			}
		}
	}

	// @@@검색@@@
	public String searchWithIndex(int index) {

		if (index - 1 < 0 || index > getLastIndex()) {
			throwing("index out of Range!!!");
			return null;
		} else {
			Node tmp = new Node();
			tmp = head;

			int i = 0;

			while (tmp != lastNode) {

				// 새로운노드 추가.
				// 굳이 뉴를 해줄 필요가없다.
//				Node a = new Node();
				Node a ;
				if (tmp != null) {
					// 탬프의 넥스트를 a가 가지
					a = tmp.next;
					// tmp는 다시 a의 next를 가진다.
					tmp = a;
					if (i == index) {

						return a.data;
					}
					i++;
				} else {
					return null;
				}
			}
			return null;
		}
	}

	// 데이타로검색
	public int searchWithData(String data) {
		Node tmp = new Node();
		tmp = head;

		int i = 0;

		while (tmp != lastNode) {

			// 새로운노드 추가.
//			Node a = new Node();
			Node a;
			if (tmp != null) {
				// 탬프의 넥스트를 a가 가지
				a = tmp.next;
				// tmp는 다시 a의 next를 가진다.
				tmp = a;
				if (a.data.equals(data)) {
					return i;
				}
				i++;
			} else {
				// 탈출하는부분. 즉 매칭값이 없으면 null을 호출한다.
				return 0;
			}
		}

		return 0;
	}

	// 인덱스로 검색해서 노드를 반환해준다.
	private Node searchWithIndexNode(int index) {

		Node tmp = new Node();
		tmp = head;

		int i = 0;

		while (tmp != lastNode) {

			// 새로운노드 추가.
//			Node a = new Node();
			Node a ;
			if (tmp != null) {
				// 탬프의 넥스트를 a가 가지
				a = tmp.next;
				// tmp는 다시 a의 next를 가진다.
				tmp = a;
				if (i == index) {

					return a;
				}
				i++;
			} else {
				return null;
			}
		}
		return null;
	}

	public String getLastData() {
		return lastNode.data;
	}

	public int getLastIndex() {
		return searchWithData(lastNode.data);
	}

	public void showAllNode() {
		System.out.println("==== show all Linked list ====");

		Node tmp = new Node();
		tmp = head;

		while (tmp != lastNode) {
			// 새로운노드 추가.
//			Node a = new Node();
			Node a;
			if (tmp != null) {
				// 탬프의 넥스트를 a가 가지
				a = tmp.next;
				// tmp는 다시 a의 next를 가진다.
				tmp = a;
				System.out.println(a.data);
			} else {
				break;
			}
		}
		System.out.println("==== end ====");

	}

}
