package study.dsa.advancedatastructures;

public class StackUsingQueue {

	CircularQueue queue1;
	CircularQueue queue2;

	int top = 0;
	int cq = 1;

	public StackUsingQueue() {

		queue1 = new CircularQueue();
		queue2 = new CircularQueue();

	}

	public void push(int val) {
		if (cq == 2) {
			while (!queue2.isEmpty())
				queue1.insert(queue2.delete());
			cq = 1;
		}
		queue1.insert(val);
	}

	public void display() {
		if (cq == 1)
			queue1.display();
		else {
			while (!queue2.isEmpty()) {
				queue1.insert(queue2.delete());
			}
			cq = 1;
			queue1.display();
		}
	}

	public int pop() {
		int returnVal = -1;
		if (cq == 1) {
			while (!queue1.hasOneElement())
				queue2.insert(queue1.delete());
			cq = 2;
			returnVal = queue1.delete();
		} else
		{
			while (!queue2.hasOneElement())
				queue1.insert(queue2.delete());
			cq = 2;
			returnVal = queue2.delete();
		}
		return returnVal;
	}

	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		System.out.println(sq.pop() + " popped");
		sq.push(4);
		System.out.println(sq.pop() + " popped");
		System.out.println(sq.pop() + " popped");
		sq.push(5);
		sq.push(6);
		sq.push(7);
		sq.push(9);
		sq.display();
		System.out.println(sq.pop() + " popped");
		sq.display();
	}
}
