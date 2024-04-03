package com.learning.core;

import java.util.Scanner;

public class D01P03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mark;
		Scanner s=new Scanner(System.in);
		mark=s.nextInt();
	    if(mark >= 60) System.out.println("Grade A");
	    else if(mark >=45 && mark <60)   System.out.println("Grade B");
	    else if (mark >=35 && mark <45)  System.out.println("Grade C");
	    else System.out.println("Fail");

	}

}
