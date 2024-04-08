package com.day2.exercises;

import java.util.Scanner;

public class D02P03 {

	public static void printSubsequences(String str, int index, String current) {
		if (index == str.length()) {
			if (!current.equals("")) {
				System.out.print(current + " ");
			}
			return;
		}


		// Include the character at the current index in the subsequence
		printSubsequences(str, index + 1, current + str.charAt(index));

		// Exclude the character at the current index from the subsequence
		printSubsequences(str, index + 1, current);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = scanner.nextLine();

		System.out.println("All subsequences of the string are:");
		printSubsequences(str, 0, "");
		System.out.println();
		
	}
}
