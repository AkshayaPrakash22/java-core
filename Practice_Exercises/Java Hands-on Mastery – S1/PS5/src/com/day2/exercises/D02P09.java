package com.day2.exercises;

import java.util.Scanner;

public class D02P09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		Scanner s=new Scanner(System.in);
		str=s.nextLine();
		String replace = str.replaceAll(" ", "%20");
        System.out.println(replace);
	}

}
