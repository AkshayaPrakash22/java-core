package com.learning.core;

import java.util.Scanner;

public class D01P05 {
	
	public static void main(String args[]) {
		int num,fact=1;
		Scanner s=new Scanner(System.in);
		num=s.nextInt();
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}
		System.out.print("Factorial of "+num+ " is "+fact);
	}

}
