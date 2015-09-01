package study.dsa.advancedatastructures;

import java.util.Stack;

public class QueueUsingStacks {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int cq = 1;

	public QueueUsingStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public boolean hasOneElement(Stack<Integer> stk) {
		return stk.size() == 1;
	}

	public boolean isEmpty() {
		return (stack1.isEmpty() && stack2.isEmpty());
	}

	public void insert(int val) {
		if (cq == 2) {
			while (!stack2.empty()) {
				stack1.push(stack2.pop());
			}
			cq = 2;
		}
		stack1.push(val);
	}

	public void display() {
		if (cq == 1)
			while (!stack1.isEmpty())
				System.out.print(stack1.pop() + " ");
		else {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			cq = 1;
			while (!stack1.isEmpty())
				System.out.print(stack1.pop() + " ");
		}
		System.out.println();
	}

	public int delete() {
		int returnVal = -1;
		if (cq == 1) {
			while (!hasOneElement(stack1))
				stack2.push(stack1.pop());
			cq = 2;
			returnVal = stack1.pop();
		} else {
			returnVal = stack2.pop();
		}
		return returnVal;
	}

	public static void main(String[] args) {

		QueueUsingStacks queue = new QueueUsingStacks();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		System.out.println(queue.delete());
		System.out.println(queue.delete());
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.display();
		queue.insert(7);
		System.out.println(queue.delete() + " Popped");
		queue.insert(8);
		queue.insert(9);
		System.out.println(queue.delete() + " Popped");
		queue.insert(10);
		queue.insert(11);
		queue.insert(13);
		queue.display();
	}

}
