package microsoft;

public class Stack {

	private static class Node {
		private int data;

		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top; // add and remove from the top of the stack
	
	public boolean isEmpty() {
		return top == null;
	}
	public int peak() {
		return top.data;
	}
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}
}
