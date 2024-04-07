package com.day2.exercises;

import java.util.Scanner;

public class D02P08 {

	public static boolean strcheck(String s1, String s2) {
		if (s1.compareTo(s2) != 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int flag = 0;
		if (str.length() >= 10) {
			flag = 1;
		} else {
			for (int i = 1; i < str.length(); i++) {
				for (int j = i + 1; j < str.length(); j++) {
					for (int k = j + 1; k < str.length(); k++) {
						String s1 = "", s2 = "", s3 = "", s4 = "";
						s1 = str.substring(0, i);
						s2 = str.substring(i, j);
						s3 = str.substring(j, k);
						s4 = str.substring(k, str.length());
						if (strcheck(s1, s2) && strcheck(s1, s3) && strcheck(s1, s4) && strcheck(s2, s3)
								&& strcheck(s2, s4) && strcheck(s3, s4)) {
							flag = 1;
						}
					}
				}
			}
		}
		if (flag == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
