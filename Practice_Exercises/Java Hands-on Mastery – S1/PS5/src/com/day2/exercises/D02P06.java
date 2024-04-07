package com.day2.exercises;

import java.util.Scanner;

public class D02P06 {

	public static int longestPrefixSuffix(String s) {
		int n = s.length();
		int longest = 0;

		for (int i = 0; i < n / 2; i++) {
			String prefix = s.substring(0, i + 1);
			String suffix = s.substring(n - i - 1, n);

			if (prefix.equals(suffix)) {
				longest = i + 1;
			}
		}

		return longest;
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println("Length of the longest prefix which is also a suffix: " + longestPrefixSuffix(s));
	}

}
