package com.learning.day4;

public class D04P01 {

	static int MAX;;
	int top;
	private String a[];

	D04P01(int size) {
		top = -1;
		this.MAX=size;
		this.a = new String[MAX];
	}

	// Check if the stack is empty
	boolean isEmpty() {
		return (top < 0);
	}

	// Inserting an element into the stack
	boolean push(String x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			return true;
		}
	}

	// Deleting an element
	String pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			String x = a[top--];
			return x;
		}
	}

	void display() {
		for (int i = 0; i <=top; i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String args[]) {
		D04P01 s = new D04P01(4);
		System.out.println("After pushing 4 elements:");
		s.push("Hello");
		s.push("World");
		s.push("Java");
		s.push("Programming");
		s.display();
		s.pop();
		System.out.println("\nAfter a pop:");
		s.display();
	}

}
