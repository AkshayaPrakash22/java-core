package com.learning.core;

import java.util.Scanner;

public class D01P03 {
	
	 public static int firstRepeatingElement(int num, int[] arr) {
	        for (int i = 0; i < num; i++) {
	            for (int j = i + 1; j < num; j++) {
	                if (arr[i] == arr[j]) {
	                    return j;
	                }
	            }
	        }
	        return -1;
	    }

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		int arr[]=new int[num];
		for(int i=0;i<num;i++) {
			arr[i]=s.nextInt();
		}
		int index = firstRepeatingElement(num,arr);
		if(index==-1) {
			System.out.println("No repeating element found");
		}
		else {
			System.out.println("First repeating element index is "+ index);
		}

	}

}
