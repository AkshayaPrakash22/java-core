package com.learning.day4;

public class D04P04 {
	
	private int maxSize;
    private int[] queueArray;
    private int front; // Front of the queue
    private int rear; // Rear of the queue
    private int currentSize; // Current size of the queue

    // Constructor
    public D04P04(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Method to insert an element into the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        currentSize++;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int removedItem = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return removedItem;
    }


    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int index = front;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        D04P04 queue = new D04P04(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.print("Elements in Queue: ");
        queue.display(); 
        
        queue.dequeue();
        System.out.print("After removing first element: ");
        queue.display(); 

    }

}
