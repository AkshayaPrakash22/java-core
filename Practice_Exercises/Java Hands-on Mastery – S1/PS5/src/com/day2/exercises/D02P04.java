package com.day2.exercises;

import java.util.Scanner;

public class D02P04 {

	public static int minDeletionsToPalindrome(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return n - dp[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println("Minimum deletions: " + minDeletionsToPalindrome(str));
	}

}
