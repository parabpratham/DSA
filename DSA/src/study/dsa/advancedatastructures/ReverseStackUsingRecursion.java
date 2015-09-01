package study.dsa.advancedatastructures;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackUsingRecursion {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
			stack.push(sc.nextInt());
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);

	}

	private static void reverse(Stack<Integer> stack) {
		int current = stack.pop();
		int loop = stack.size();
		while (loop != 0) {
			insertAtBottom(stack, current, loop--);
			current = stack.pop();
		}
		stack.push(current);
	}

	private static void insertAtBottom(Stack<Integer> stack, int current,
			int loop) {
		if (loop == 0) {
			stack.push(current);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, current, --loop);
		stack.push(temp);
	}

}
