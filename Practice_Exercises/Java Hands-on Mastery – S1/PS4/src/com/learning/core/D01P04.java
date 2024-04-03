package com.learning.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D01P04 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        String[] numbersInput = scanner.nextLine().split(" ");
	        List<Integer> nums = new ArrayList<>();
	        for (String numStr : numbersInput) {
	            nums.add(Integer.parseInt(numStr));
	        }

	        
	       
	        int k = scanner.nextInt();

	        printCombinations(nums, k);
	        
	       
	    }

	    public static void printCombinations(List<Integer> nums, int I) {
	        if (I <= 0 || nums.size() < I) {
	            System.out.println("Invalid input.");
	            return;
	        }

	        List<Integer> combination = new ArrayList<>();
	        generateCombinations(nums, I, 0, combination);
	    }

	    private static void generateCombinations(List<Integer> nums, int I, int start, List<Integer> combination) {
	        if (combination.size() == I) {
	            for (Integer num : combination) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	            return;
	        }

	        for (int i = start; i < nums.size(); i++) {
	            combination.add(nums.get(i));
	            generateCombinations(nums, I, i + 1, combination);
	            combination.remove(combination.size() - 1);
	        }
	    }

}
