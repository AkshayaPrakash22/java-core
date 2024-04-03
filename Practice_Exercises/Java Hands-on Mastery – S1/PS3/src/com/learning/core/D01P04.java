package com.learning.core;

import java.util.Scanner;

public class D01P04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();

		// Outer loop for rows
		for (int i = 1; i <= rows; i++) {
			// Inner loop for printing numbers
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			// Move to the next line after each row
			System.out.println();
		}

	}

}
