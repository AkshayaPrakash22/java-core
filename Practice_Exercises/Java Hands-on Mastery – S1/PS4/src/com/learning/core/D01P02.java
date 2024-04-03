package com.learning.core;

public class D01P02 {

	public static void main(String[] args) {
		int[] array = { 2, 4, 5, 6, 4, 5, 7, 3, 2, 3, 4, 7, 1, 2, 3, 0, 0, 0 };
		int sum = 0, sum1 = 0;
		for (int i = 0; i < 15; i++) {
			sum = sum + array[i];
		}
		array[15] = sum;

		for (int i = 0; i < 18; i++) {
			sum1 += array[i];
		}
		int average = sum1 / 18;
		array[16] = average;

		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		array[17] = min;

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}

	}

}
