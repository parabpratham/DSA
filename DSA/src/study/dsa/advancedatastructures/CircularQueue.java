package study.dsa.advancedatastructures;

public class CircularQueue {

	int a[];
	int front, rear, n;

	public CircularQueue() {
		a = new int[25];
		front = rear = -1;
		n = 10;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return front == (rear + 1) % n;
	}

	public void display() {
		int i;
		if (isEmpty()) {
			System.out.print("Empty\n");
		} else if (rear < front) {
			for (i = front; i < n; i++)
				System.out.print(a[i] + " ");
			for (i = 0; i <= rear; i++)
				System.out.print(a[i] + " ");
		} else {
			for (i = front; i <= rear; i++)
				System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public void insert(int val) {
		// check if full
		if (((rear + 1) % n) == front)
			System.out.println("Full");
		else {

			if (front == -1)
				front = rear = 0;
			else
				rear = (rear + 1) % n;
			a[rear] = val;
			// display();
		}

	}

	public int delete() {
		int del = -1;
		if (front == -1)
			System.out.println("Empty \n");
		else {
			del = a[front];
			a[front] = -1;
			// System.out.println(del + " deleted");
			if (front == rear)
				front = rear = -1;
			else
				front = (front + 1) % n;

		}
		return del;
	}

	public boolean hasOneElement() {
		return (front + 1) % n > rear;
	}

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue();

		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		q.insert(5);
		q.insert(6);
		q.delete();
		q.delete();
		q.display();
		q.delete();
		q.delete();
		q.insert(7);
		q.insert(8);
		q.insert(9);
		q.insert(10);
		q.insert(11);
		q.delete();
		q.delete();
		q.delete();
		q.delete();

	}

}
