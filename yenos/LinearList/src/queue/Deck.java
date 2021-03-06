
package queue;
import except.PkCustomExcept;

/**
 * @author yenos
 * @date 2016. 9. 14.
 * 덱을 구현해보자!
 */
public class Deck {

	class Node {
		Node left;
		Node right;
		String data;
	}

	Node front;
	Node rear;

	public void createDQ() {
		front = null;
		rear = null;
	}

	// 만약 큐가 비었다면 둘다 널일 경우이다.
	public Boolean isEmptyDQ() {
		if (front == null && rear == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertFront(String data) {

		Node newNode = new Node();
		newNode.data = data;

		// 비어있다면
		if (isEmptyDQ()) {
			front = new Node();
			rear = new Node();
			// 프론트의 라잇은 새로운 노드를 가치키고 /
			front.right = newNode;
			// 레어는 맨뒤에 있는 녀석 즉 지금 이자신.
			rear = newNode;
		}
		// 이미 차있다면.
		else {
			// 프론트의 오른쪽이 가르치고있는 노드의 왼쪽이 새로운 노드를 가르치
			Node tmp = front.right;
			tmp.left = newNode;
			// 새로운 노드의 오른쪽은 전에 노드가되
			newNode.right = tmp;

			// 프론트는 다시 새노드들 가르킨다
			front.right = newNode;
			// //레어는 새로운노드가된다.
			// rear = newNode;
		}

	}

	public void insertRear(String data) {
		Node newNode = new Node();
		newNode.data = data;
		// 비어있다면
		if (isEmptyDQ()) {
			front = new Node();
			rear = new Node();
			// 프론트의 라잇은 새로운 노드를 가리키고 
			front.right = newNode;
			// 레어는 맨뒤에 있는 녀석 즉 지금 이자신.
			rear = newNode;
		}else{
			
			//마지막꺼를 기준으로 넣어줘야함으
			Node tmp = rear;
			//마지막 오른쪽을 뉴노드 
			rear.right = newNode;
			//새로운노드의 왼쪽을 예전것으로  
			newNode.left = tmp;
			//그리고 레어에 새로운 노드
			rear = newNode;
		}
	}
	
	public String deleteFront(){
		if(isEmptyDQ()){
			new PkCustomExcept("isEmpty");

			return null;
		}else{
			
			Node tmp = front.right;
			//두번째 녀석의래프트를널로만들어주고
			tmp.right.left = null;
			//front를 이전한다.
			
			front.right = tmp.right;
			return tmp.data;

		}
	}
	
	public String deleteRear(){
		if(isEmptyDQ()){
			new PkCustomExcept("isEmpty");
			return null;
		}else{
			
			String returnStr =rear.data ;
			
			Node tmp = rear.left;
			//마지막의 왼노드의 오른쪽을 없애주고(null)
			tmp.right = null;
			//레어를 이전한다.
			rear = tmp;
			
			return returnStr;

		}
	}

	public void printPretty() {
		if (isEmptyDQ()) {
			new PkCustomExcept("isEmpty");
			} else {
			Node tmp2 = front.right;
			// System.out.println(tmp2.data);
			// System.out.println(rear.data);
			while (front.right != null) {
				Node tmp = front.right;
				System.out.print(tmp.data + "->");

				front.right = tmp.right;

			}
		}
	}

}
