package com.learning.day4;

import java.util.Scanner;

public class D04P03 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = scanner.nextInt();

		int[] a = new int[n];

		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

                System.out.println("Enter search element using linear search");
		int search = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i == search) {
				count++;
			}
		}
		if (count == 1) {
			System.out.println("Element is present");
		} else
			System.out.println("Element is not present");

	}

}
