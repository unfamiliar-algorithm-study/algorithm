/**
 * 
 */
package sta;

/**
 * @author yenos
 * @date 2016. 9. 4.
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack stack = new Stack();

		System.out.println("===== arrSTack =====");
		// ARR!!!!!
		stack.arrPush("hi");
		stack.arrPush("nice");
		stack.arrPush("meet");
		stack.arrShowAllStack();
		// //pop
		// stack.arrPop();
		// //show all
		// stack.arrShowAllStack();
		// //pop
		// stack.arrPop();
		// stack.arrShowAllStack();

		System.out.println("===== END=====");
		System.out.println();
		System.out.println("===== LinkStack =====");

		stack.linkPush("hi");
		stack.linkPush("nice");
		stack.linkPush("to");
		System.out.println("===== showall =====");

		stack.linkShowAllNode();
		System.out.println("===== pop" + " =====");

		stack.linkPop();
		stack.linkPop();
		stack.linkShowAllNode();
		System.out.println("===== END=====");

		// Stack을 이용해 infix => postfix로 구현해보자!!!!!!!!!!!!!!
		// !!!!!!!!
		System.out.println("===== infix ==> posfix =====");

		String sick = "((A+B)*C)";

		String result = "";
		for (int i = 0; i < sick.length(); i++) {
			String strFirst = sick.substring(i, i + 1);
			System.out.println(strFirst);

			// 연산자가 나오면 넣고.
			if (strFirst.equals("+") || strFirst.equals("-") || strFirst.equals("*") || strFirst.equals("-")) {
				stack.linkPush(strFirst);
				// 아무것도안함
			} else if (strFirst.equals("(") || strFirst.equals("{") || strFirst.equals("[")) {
				// 닫는거면 팦해서 더해
			} else if (strFirst.equals(")") || strFirst.equals("}") || strFirst.equals("]")) {
				String popStr = stack.linkPop();
				result += popStr;

				// A,bC이면 result에 붙인다.
			} else {
				result += strFirst;
			}

		}
		// rufrhk
		System.out.println(result);
		System.out.println("===== end =====");

		// Stack을 이용해 posfix연산을해보자!!!!
		// !!!!!!!!
		System.out.println("===== posfix =====");

		String sick2 = "82/3-";
		String result2;

		for (int i = 0; i < sick2.length(); i++) {
			String strFirst = sick2.substring(i, i + 1);
			System.out.println(strFirst);
			// 연산자가 나오면 2개뺴고 그거 계산한것을 넣어준다.
			if (strFirst.equals("+") || strFirst.equals("-") || strFirst.equals("*") || strFirst.equals("/")) {
				// 아무것도안함
				int pop1 = Integer.parseInt(stack.linkPop());
				int pop2 = Integer.parseInt(stack.linkPop());
				if (strFirst.equals("+")) {
					stack.linkPush(Integer.toString(pop2 + pop1));
				} else if (strFirst.equals("-")) {
					stack.linkPush(Integer.toString(pop2 - pop1));
				} else if (strFirst.equals("*")) {
					stack.linkPush(Integer.toString(pop2 * pop1));
				} else if (strFirst.equals("/")) {
					if (pop2 != 0) {
						stack.linkPush(Integer.toString((int) pop2 / (int) pop1));
					}
				}
			} else {
				// 숫자푸시해서 넣어
				stack.linkPush(strFirst);
			}

			if (i == sick2.length() - 1) {
				System.out.println("result is " + stack.linkPop());
			}
		}

	}

}
