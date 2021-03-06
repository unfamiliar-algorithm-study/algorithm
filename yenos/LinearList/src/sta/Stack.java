/**
 * 
 */
package sta;

/**
 * @author yenos
 * @date 2016. 9. 4.
 */
public class Stack {

	class Node {
		String data;
		Node next;
	}

	Node top = null;

	public void linkPush(String data) {
		Node tmp = new Node();
		tmp.data = data;
		// top이 널이면
		// top을 만들어주고
		if (top == null) {
			//  top (data x) -> newNode 
			top = new Node();
			top.data = null;
			top.next = tmp;
		} else {
			
			// top 이 널이 아니라면 최소 1개가 존재한다.
			// case1. top -> 0node
			// case2. top -> 1 node -> 0 node

			// tmp의 다음은 top이 가리키던것.
			tmp.next = top.next;
			// top이 이제 가리켜야할것은 tmp
			top.next = tmp;
		}
	}

	public String linkPop() {
		// null이 아니야.
		// case2. top -> 1 node -> 0 node

		if (top.next != null) {
			Node tmp = new Node();
			// 1node
			tmp = top.next;
			// 탑의 다음은 tmp의 다음노드.
			top.next = tmp.next;
			return tmp.data;
//			 System.out.println(tmp.data);
		} else {

			throwing("out of Range");
			return null;

		}

	}

	public void linkShowAllNode() {

		// //Case top -> 3 node -> 2node -> 0 node..
		if (top.next != null) {
			// if(top.ne)
			Node tmp = new Node();
			tmp = top.next;

			while (tmp != null) {
				Node a = new Node();
				// tmp = 3node
				// a = 2node
				a = tmp;
				// tmp = 3노드의 다음
				tmp = a.next;
				System.out.println(" " + a.data);
			}
		} else {
			System.out.println("님 밑바닥이에");
		}
	}

	public boolean isEmpty() {
		return top.next == null ? true : false;
	}












	// @@@ arrray!!!!!
	// *** 배열 푸시 할때 항상 새로 만들지 말고 꽉찼을경우에만 채우기.
	private int STACK_SIZE = 0;
	String[] arrStack;

	// stack Arr를 만든다.
	public String[] makeAddStackArr() {
		if (arrStack != null) {

			String[] arrNew = new String[++STACK_SIZE];
			for (int i = 0; i < arrStack.length; i++) {
				arrNew[i] = arrStack[i];
			}

			return arrNew;
		} else {
			return new String[++STACK_SIZE];
		}
	}

	public String[] makeMinuStackArr() {
		// 널이아니면 무조건 한개 이상 존재
		if (arrStack != null) {
			// 사이즈하나줄이고
			String[] arrNew = new String[--STACK_SIZE];
			//
			// 줄인상태로 다 채워넣고
			for (int i = 0; i < STACK_SIZE; i++) {
				arrNew[i] = arrStack[i];
			}
			return arrNew;

			// 한개도없데 마이너슨한다.
		} else {
			throwing("index out of Range!!!");
			return null;
		}

	}

	// push
	public void arrPush(String data) {
		arrStack = makeAddStackArr();
		arrStack[STACK_SIZE - 1] = data;
	}

	// isEmpty
	public boolean isEmpt() {
		return STACK_SIZE == 0 ? true : false;
	}

	public void arrPop() {
		arrStack = makeMinuStackArr();
		// arr
	}

	public void arrShowAllStack() {
		if (STACK_SIZE == 0) {
			System.out.println("님 밑바닥이에요!");
		} else {
			for (int i = 0; i < arrStack.length; i++) {
				System.out.println("stack val ==> " + arrStack[i]);
			}
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
