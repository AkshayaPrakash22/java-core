package com.day2.exercises;

import java.util.Scanner;

public class D02P02 {
	
	public static String getLastNVowels(String str, int n) {
		int count = 0;
		String lastVowels = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = Character.toLowerCase(str.charAt(i));
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
				if (count <= n) {
					lastVowels = ch + lastVowels;
				}
			}
		}

		if (count < n) {
			return "Mismatch in Vowel Count";
		}

		return  lastVowels;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string:");
		String input = scanner.nextLine();

		System.out.println("Enter the number of vowels to count from the end:");
		int n = scanner.nextInt();

		String lastNVowels = getLastNVowels(input, n);
		System.out.println(lastNVowels);

	}

	
}