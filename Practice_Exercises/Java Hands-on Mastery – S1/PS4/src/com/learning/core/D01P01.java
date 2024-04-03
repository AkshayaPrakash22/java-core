package com.learning.core;

import java.util.Scanner;

public class D01P01 {

	public static int checkBingo(int num1, int num2, int[] arr) {
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			if (num1 == arr[i]) {
				flag++;
			}
			if (num2 == arr[i]) {
				flag++;
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers from 1 to 40");
		int num1 = s.nextInt();
		int num2 = s.nextInt();

		int arr[] = new int[5];
		System.out.println("Enter an array of 5 numbers from 1 to 40");
		for (int i = 0; i < 5; i++) {
			arr[i] = s.nextInt();
		}

		if (checkBingo(num1, num2, arr) == 2) {
			System.out.println("Its Bingo");
		} else
			System.out.println("Not found");

	}

}
