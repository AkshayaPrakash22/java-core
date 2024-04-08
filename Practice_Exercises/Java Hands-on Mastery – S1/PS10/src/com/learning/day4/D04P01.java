package com.learning.day4;

import java.util.Scanner;

public class D04P01 {
	// Method to perform quick sort
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);

			// Recursively sort the sub-arrays
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	// Method to partition the array
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; 
		int i = low - 1; 

		for (int j = low; j < high; j++) {
			// If current element is smaller than or equal to the pivot
			if (arr[j] <= pivot) {
				i++; // Increment index of smaller element
				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// Method to print the sorted array
	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();

		int[] arr = new int[size];

		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.println("Original array:");
		printArray(arr);

		quickSort(arr, 0, arr.length - 1);

		System.out.println("Sorted array:");
		printArray(arr);

	}

}
