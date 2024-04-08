package com.learning.day4;

class Node {
    double data;
    Node next;

    Node(double data) {
        this.data = data;
        this.next = null;
    }
}

public class D04P02 {
    private Node top;

    // Constructor to initialize the stack
    public D04P02() {
        this.top = null; // Stack is initially empty
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to push an element onto the stack
    public void push(double d) {
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop an element from the stack
    public double pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        }
        double poppedData = top.data;
        top = top.next;
        return poppedData;
    }
    
    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        D04P02 stacklinkedlist = new D04P02();

        // Push some elements onto the stack
        stacklinkedlist.push(10.0);
        stacklinkedlist.push(20.0);
        stacklinkedlist.push(30.0);
        stacklinkedlist.push(40.0);
        System.out.print("The elements of the stack are: ");
        stacklinkedlist.display();

        // Pop elements from the stack
        System.out.println("Popped element: " + stacklinkedlist.pop());
        System.out.println("Popped element: " + stacklinkedlist.pop());
        System.out.print("After popping twice: ");
       stacklinkedlist.display();
    }
}
