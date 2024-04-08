package com.learning.day4;

class QueueNode {
	int data;
	QueueNode next;

	public QueueNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class D04P05 {
	private QueueNode front; // Front of the queue
	private QueueNode rear; // Rear of the queue
	private int size; // Size of the queue

	// Constructor
	public D04P05() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	// Method to insert an element into the queue
	public void enqueue(int item) {
		QueueNode newNode = new QueueNode(item);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	// Method to remove an element from the queue
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return -1;
		}
		int removedItem = front.data;
		front = front.next;
		if (front == null) {
			rear = null; // If the queue becomes empty after dequeue
		}
		size--;
		return removedItem;
	}


	// Method to check if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Method to display the elements of the queue
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		
		QueueNode current = front;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		D04P05 queue = new D04P05();

		queue.enqueue(89);
		queue.enqueue(99);
		queue.enqueue(109);
		queue.enqueue(209);
		queue.enqueue(309);

		System.out.print("Elements in queue: ");
		queue.display();

		queue.dequeue();
		queue.dequeue();
        System.out.print("After removing two elements: ");
		queue.display(); 

	}
}