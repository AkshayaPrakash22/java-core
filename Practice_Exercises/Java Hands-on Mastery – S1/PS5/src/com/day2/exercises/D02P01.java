package com.day2.exercises;

import java.util.Scanner;

public class D02P01 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int strlength = str.length();
		String str2 = str.toUpperCase();
		System.out.println("Length of the string is:" + strlength);
		System.out.println("String in uppercase:" + str2);
		String rev = "";
		for (int i = strlength - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		if (str.equals(rev))
			System.out.println(str + " is a palindrome");
		else
			System.out.println(str + " is not a palindrome");

	}

}
